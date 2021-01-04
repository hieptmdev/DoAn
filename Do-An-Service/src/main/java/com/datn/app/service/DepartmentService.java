package com.datn.app.service;

import com.datn.app.dao.idao.DepartmentDao;
import com.datn.app.dto.DepartmentDto;
import com.datn.app.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public List<DepartmentDto> findAll(){
        List<Department> departmentList = departmentDao.findAll();
        if (departmentList != null || !departmentList.isEmpty()){
            return departmentList.stream().map(Department::convertToDto).collect(Collectors.toList());
        }
        return null;
    }

    public List<DepartmentDto> findAllByUnit(Long unitId){
        List<Department> departmentList = departmentDao.findAllByUnit_Id(unitId);
        if (departmentList != null || !departmentList.isEmpty()){
            return departmentList.stream().map(Department::convertToDto).collect(Collectors.toList());
        }
        return null;
    }
}
