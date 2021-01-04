package com.datn.app.service;

import com.datn.app.dao.idao.RoleDao;
import com.datn.app.dto.RoleDto;
import com.datn.app.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public List<RoleDto> findAll(){
        List<Role> roleList = roleDao.findAll();
        if (roleList != null || !roleList.isEmpty()){
            return roleList.stream().map(Role::convertToDto).collect(Collectors.toList());
        }
        return null;
    }
}
