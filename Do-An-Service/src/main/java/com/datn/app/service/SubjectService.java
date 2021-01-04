package com.datn.app.service;

import com.datn.app.dao.idao.SubjectDao;
import com.datn.app.dto.SubjectsDto;
import com.datn.app.entity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    public List<SubjectsDto> findAll(){
        List<Subjects> subjectsList = subjectDao.findAll();
        if (subjectsList != null || !subjectsList.isEmpty()){
            return subjectsList.stream().map(Subjects::convertToDto).collect(Collectors.toList());
        }
        return null;
    }

    public List<SubjectsDto> findAllByDepartment(Long departmentId){
        List<Subjects> subjectsList = subjectDao.findAllByDepartment_Id(departmentId);
        if (subjectsList != null || !subjectsList.isEmpty()){
            return subjectsList.stream().map(Subjects::convertToDto).collect(Collectors.toList());
        }
        return null;
    }
}
