package com.datn.app.service;

import com.datn.app.dao.idao.UserDao;
import com.datn.app.dao.idao.UserInforDao;
import com.datn.app.dto.UserDto;
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

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserInforDao userInforDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByUsername(s);
    }

    public UserDto findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user != null){
            UserInfor userInfor = userInforDao.findByUser(user);
            UserDto dto = new UserDto();
            return setDto(dto, userInfor);
        }
        return null;
    }

    public UserDto findById(Long id) {
        User user = userDao.findById(id).orElse(null);
        if (user != null){
            UserInfor userInfor = userInforDao.findByUser(user);
            UserDto dto = new UserDto();
            return setDto(dto, userInfor);
        }
        return null;
    }

    public Page<UserDto> search(Pageable pageable) {
        Page<UserInfor> userPage = userInforDao.search(pageable);
        if (userPage != null || !userPage.isEmpty()){
            Page<UserDto> dtoPage = userPage.map(userInfor -> userInfor.convertToDto());
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
            return setDto(dto, userInfor);
        }
        return null;
    }

    public String deleteById(Long id) {
        return null;
    }

    public UserDto setDto(UserDto dto, UserInfor userInfor){
        dto = userInfor.convertToDto();
        dto.setUsername(userInfor.getUser().getUsername());
        dto.setPassword(userInfor.getUser().getPassword());
        dto.setGenderString(AppUtil.toGenderString(userInfor.getGender()));
        dto.setUnitName(userInfor.getUnit() != null ? userInfor.getUnit().getName() : null);
        dto.setRoleName(userInfor.getRole() != null ? userInfor.getRole().getName() : null);
        return dto;
    }
}
