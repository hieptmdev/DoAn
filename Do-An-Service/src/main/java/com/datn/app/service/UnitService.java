package com.datn.app.service;

import com.datn.app.dao.idao.UnitDao;
import com.datn.app.dto.UnitDto;
import com.datn.app.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitService {
    @Autowired
    private UnitDao unitDao;

    public List<UnitDto> getAllForStudent(Long unitId){
        Unit unit = unitDao.findById(unitId).orElse(null);
        if (unit != null){
            return unitDao.findAllForStudent(unitId)
                    .stream().map(Unit::convertToDto).collect(Collectors.toList());
        }
        return null;
    }
}
