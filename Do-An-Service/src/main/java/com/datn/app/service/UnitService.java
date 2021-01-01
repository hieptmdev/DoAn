package com.datn.app.service;

import com.datn.app.dao.idao.UnitDao;
import com.datn.app.dto.UnitDto;
import com.datn.app.dto.UserDto;
import com.datn.app.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitService {
    @Autowired
    private UnitDao unitDao;
    @Autowired
    private UserService userService;

    public List<UnitDto> getAllForStudent(Long unitId){
        Unit unit = unitDao.findById(unitId).orElse(null);
        if (unit != null){
            return unitDao.findAllForStudent(unitId)
                    .stream().map(Unit::convertToDto).collect(Collectors.toList());
        }
        return null;
    }

    public List<UnitDto> getAllForStudent(HttpServletRequest request){
        UserDto userDto = userService.findByUsername(request.getUserPrincipal().getName());
        if (userDto != null) {
            Unit unit = unitDao.findById(userDto.getUnitId()).orElse(null);
            if (unit != null) {
                return unitDao.findAllForStudent(unit.getId())
                        .stream().map(Unit::convertToDto).collect(Collectors.toList());
            }
            return null;
        }
        return null;
    }
}
