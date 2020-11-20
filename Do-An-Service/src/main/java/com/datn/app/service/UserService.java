package com.datn.app.service;

import com.datn.app.constant.ConstantData;
import com.datn.app.dao.idao.CodeResetPasswordDao;
import com.datn.app.dao.idao.UserDao;
import com.datn.app.dao.idao.UserInforDao;
import com.datn.app.dto.FormChangePassword;
import com.datn.app.dto.UserDto;
import com.datn.app.entity.CodeResetPassword;
import com.datn.app.entity.User;
import com.datn.app.entity.UserInfor;
import com.datn.app.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserInforDao userInforDao;
    @Autowired
    private SendMailService sendMailService;
    @Autowired
    private CodeResetPasswordDao codeResetPasswordDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByUsername(s);
    }

    public UserDto findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user != null){
            UserInfor userInfor = userInforDao.findByUser(user);
            UserDto dto = new UserDto();
            return convertUserDto(dto, userInfor);
        }
        return null;
    }

    public UserDto findById(Long id) {
        User user = userDao.findById(id).orElse(null);
        if (user != null){
            UserInfor userInfor = userInforDao.findByUser(user);
            UserDto dto = new UserDto();
            return convertUserDto(dto, userInfor);
        }
        return null;
    }

    public Page<UserDto> search(Pageable pageable) {
        Page<UserInfor> userPage = userInforDao.search(pageable);
        if (userPage != null || !userPage.isEmpty()){
            Page<UserDto> dtoPage = userPage.map(userInfor -> {
                UserDto dto = userInfor.convertToDto();
                return convertUserDto(dto, userInfor);
            });
            return dtoPage;
        }
        return null;
    }

    @Transactional
    public UserDto save(UserDto dto) {
        User user = new User();
        UserInfor userInfor;
        if (dto != null){
            if (dto.getId() == 0L){
                userInfor = dto.convertToEnt();
                user.setUsername(dto.getUsername());
                user.setPassword(dto.getPassword());
            }else {
                userInfor = userInforDao.findById(dto.getId()).orElse(null);
                if (userInfor != null){
                    userInfor.setFirstName(dto.getFirstName());
                    userInfor.setLastName(dto.getLastName());
                    userInfor.setAddress(dto.getAddress());
                    userInfor.setDob(dto.getDob());
                    userInfor.setEmail(dto.getEmail());
                    userInfor.setNumberPhone(dto.getNumberPhone());
                    userInfor.setGender(dto.getGender());
                    user = userInfor.getUser();
                    if (!passwordEncoder.matches(dto.getPassword(), user.getPassword()))
                        user.setPassword(passwordEncoder.encode(dto.getPassword()));
                }
            }
            if (dto.getRoleId() != 0L) userInfor.setRole(null);
            if (dto.getUnitId() != 0L) userInfor.setUnit(null);

            user = userDao.saveEntity(user);
            userInfor.setUser(user);
            userInfor = userInforDao.saveEntity(userInfor);
            return convertUserDto(dto, userInfor);
        }
        return null;
    }

    public String deleteById(Long id) {
        return null;
    }

    @Transactional
    public Boolean sendCode(UserDto dto) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        User user = userDao.findByUsername(dto.getUsername());
        if (user != null){
            String subject = "Mã xác thực thay đổi mật khẩu";
            String code = AppUtil.generateCode();

            CodeResetPassword codeResetPassword = codeResetPasswordDao.findByUser(user);
            if (codeResetPassword != null){
                codeResetPassword.setCode(code);
            }else {
                codeResetPassword = new CodeResetPassword();
                codeResetPassword.setCode(code);
                codeResetPassword.setUser(user);
            }
            codeResetPassword.setExpireDate(dateFormat.parse(dateFormat.format((new Date().getTime() + 600000))));
            codeResetPasswordDao.saveEntity(codeResetPassword);
            sendMailService.sendCodeMail(dto.getEmail(), subject, code);
            return true;
        }
        return false;
    }

    @Transactional
    public Integer changePassword(FormChangePassword dto){
        CodeResetPassword codeResetPassword = codeResetPasswordDao.findByCode(dto.getCode());
        if (codeResetPassword != null && !codeResetPassword.isUsed() && codeResetPassword.getExpireDate().before(new Date())){
            User user = codeResetPassword.getUser();
            if (dto.getNewPassword().equals(dto.getConfirmNewPassword())){
                user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
                codeResetPassword.setUsed(true);
                userDao.saveEntity(user);
                codeResetPasswordDao.saveEntity(codeResetPassword);
                return 1;
            }
            return 0;
        }
        return -1;
    }

    @Transactional
    public Boolean lockUser(Long id){
        User user = userDao.findById(id).orElse(null);
        if (user != null){
            user.setAccountNonLocked(false);
            userDao.saveEntity(user);
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean openLockUser(Long id){
        User user = userDao.findById(id).orElse(null);
        if (user != null){
            user.setAccountNonLocked(true);
            userDao.saveEntity(user);
            return true;
        }
        return false;
    }

    public UserDto convertUserDto(UserDto dto, UserInfor userInfor){
        dto = userInfor.convertToDto();
        dto.setUsername(userInfor.getUser().getUsername());
        dto.setPassword(userInfor.getUser().getPassword());
        dto.setAccountNonLocked(userInfor.getUser().isAccountNonLocked());
        dto.setGenderString(ConstantData.Gender.getGenderNameByCode(userInfor.getGender()));
        dto.setUnitName(userInfor.getUnit() != null ? userInfor.getUnit().getName() : null);
        dto.setRoleName(userInfor.getRole() != null ? userInfor.getRole().getName() : null);
        dto.setNationId(userInfor.getNation() != null ? userInfor.getNation().getId() : null);
        dto.setProvinceId(userInfor.getProvince() != null ? userInfor.getProvince().getId() : null);
        dto.setDistrictId(userInfor.getDistrict() != null ? userInfor.getDistrict().getId(): null);
        dto.setWardId(userInfor.getWard() != null ? userInfor.getWard().getId(): null);
        return dto;
    }
}
