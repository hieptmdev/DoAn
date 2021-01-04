package com.datn.app.service;

import com.datn.app.constant.ConstantData;
import com.datn.app.dao.idao.*;
import com.datn.app.dto.FormChangePassword;
import com.datn.app.dto.MessageResponse;
import com.datn.app.dto.UserDto;
import com.datn.app.entity.*;
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
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private UnitDao unitDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private NationDao nationDao;
    @Autowired
    private DepartmentDao departmentDao;

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

    public Page<UserDto> search(Pageable pageable, String code, String name, String username, String unitId) {
        if (code == null || code.equals("undefined") || code.equals("")) code = "";
        if (name == null || name.equals("undefined") || name.equals("")) name = "";
        if (username == null || username.equals("undefined") || username.equals("")) username = "";
        if (unitId == null || unitId.equals("undefined") || unitId.equals("")) unitId = "0";
        Page<UserInfor> userPage = userInforDao.search(pageable, code.toLowerCase(), name.toLowerCase(), username.toLowerCase(), Long.parseLong(unitId));
        if (userPage != null || !userPage.isEmpty()){
            Page<UserDto> dtoPage = userPage.map(userInfor -> {
                UserDto dto = new UserDto();
                return convertUserDto(dto, userInfor);
            });
            return dtoPage;
        }
        return null;
    }

    public Page<UserDto> searchTeacher(Pageable pageable, String code, String name, String departmentId, String unitId) {
        if (code == null || code.equals("undefined") || code.equals("")) code = "";
        if (name == null || name.equals("undefined") || name.equals("")) name = "";
        if (departmentId == null || departmentId.equals("undefined") || departmentId.equals("")) departmentId = "0";
        if (unitId == null || unitId.equals("undefined") || unitId.equals("")) unitId = "0";
        Page<UserInfor> userPage = userInforDao.searchTeacher(pageable, code.toLowerCase(), name.toLowerCase(), Long.parseLong(departmentId), Long.parseLong(unitId));
        if (userPage != null || !userPage.isEmpty()){
            Page<UserDto> dtoPage = userPage.map(userInfor -> {
                UserDto dto = new UserDto();
                return convertUserDto(dto, userInfor);
            });
            return dtoPage;
        }
        return null;
    }

    @Transactional
    public UserDto saveOrUpdate(UserDto dto) {
        if (dto != null){
            User user = new User();
            UserInfor userInfor;
            if (dto.getId() == null || dto.getId() == 0L){
                userInfor = dto.convertToEnt();
                userInfor.setNation(nationDao.findById(232L).orElse(null));
                user.setCode(AppUtil.generateEmpCode());
                user.setUsername(dto.getUsername());
                user.setPassword(passwordEncoder.encode(dto.getPassword()));
            }else {
                userInfor = userInforDao.findById(dto.getId()).orElse(null);
                if (userInfor != null){
                    userInfor.setFirstName(dto.getFirstName());
                    userInfor.setLastName(dto.getLastName());
                    userInfor.setAddress(dto.getAddress());
                    userInfor.setDob(dto.getDob());
                    userInfor.setEmail(dto.getEmail());
                    userInfor.setGender(dto.getGender());
                    user = userInfor.getUser();
                    if (!passwordEncoder.matches(dto.getPassword(), user.getPassword()))
                        user.setPassword(passwordEncoder.encode(dto.getPassword()));
                }
            }
            userInfor.setNumberPhone(dto.getNumberPhone());
            if (dto.getRoleId() != null || dto.getRoleId() != 0L)
                userInfor.setRole(roleDao.findById(dto.getRoleId()).orElse(null));
            if (dto.getUnitId() != null || dto.getUnitId() != 0L)
                userInfor.setUnit(unitDao.findById(dto.getUnitId()).orElse(null));

            user = userDao.saveEntity(user);
            userInfor.setUser(user);
            userInfor.setCode(user.getCode());
            userInfor = userInforDao.saveEntity(userInfor);
            return convertUserDto(dto, userInfor);
        }
        return null;
    }

    @Transactional
    public MessageResponse deleteById(Long id) {
        MessageResponse messageResponse;
        User user = userDao.findById(id).orElse(null);
        if (user == null){
            messageResponse = new MessageResponse(400, "error.fail");
        }else {
            userInforDao.deleteByUser_Id(id);
            userDao.deleteById(id);
            messageResponse = new MessageResponse(200, "success.delete");
        }
        return messageResponse;
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
        if (codeResetPassword != null && !codeResetPassword.isUsed() && codeResetPassword.getExpireDate().after(new Date())){
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
        return dto;
    }

    public List<UserDto> findAllTeacherByDepartment(Long departmentId) {
        Department department = departmentDao.findById(departmentId).orElse(null);
        if (department != null){
            List<UserInfor> userInforList = userInforDao.findAllTeacherByDepartment(departmentId);
            if(userInforList != null || !userInforList.isEmpty()){
                List<UserDto> userDtoList = userInforList.stream()
                        .map(ent -> {
                            UserDto dto = new UserDto();
                            return convertUserDto(dto, ent);
                        }).collect(Collectors.toList());
                return userDtoList;
            }
            return null;
        }
        return null;
    }

    public List<UserDto> findAllTeacher() {
        List<UserInfor> userInforList = userInforDao.findAllByRole_Id(6L);

        if(userInforList != null || !userInforList.isEmpty()){
            List<UserDto> userDtoList = userInforList.stream()
                    .map(ent -> {
                        UserDto dto = new UserDto();
                        return convertUserDto(dto, ent);
                    }).collect(Collectors.toList());
            return userDtoList;
        }
        return null;
    }
}
