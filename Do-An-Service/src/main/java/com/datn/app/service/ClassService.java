package com.datn.app.service;

import com.datn.app.constant.ConstantData;
import com.datn.app.dao.idao.ClassDao;
import com.datn.app.dao.idao.ClassDetailDao;
import com.datn.app.dto.ClassDetailDto;
import com.datn.app.dto.ClassDto;
import com.datn.app.dto.UserDto;
import com.datn.app.entity.Class;
import com.datn.app.entity.ClassDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {
    @Autowired
    private ClassDao classDao;
    @Autowired
    private ClassDetailDao classDetailDao;
    @Autowired
    private UserService userService;

    public Page<ClassDto> search(Pageable pageable, String code, String name, String courseId,
                                 String unitId, String departmentId, String subjectId) {
        if (code == null || code.equals("undefined") || code.equals("")) code = "";
        if (name == null || name.equals("undefined") || name.equals("")) name = "";
        if (courseId == null || courseId.equals("undefined") || courseId.equals("")) courseId = "0";
        if (unitId == null || unitId.equals("undefined") || unitId.equals("")) unitId = "0";
        if (departmentId == null || departmentId.equals("undefined") || departmentId.equals("")) departmentId = "0";
        if (subjectId == null || subjectId.equals("undefined") || subjectId.equals("")) subjectId = "0";
        Page<Class> classPage = classDao.search(pageable, code, name,
                Long.parseLong(courseId), Long.parseLong(unitId),
                Long.parseLong(departmentId), Long.parseLong(subjectId));
        if (classPage != null){
            Page<ClassDto> classDtoPage = classPage.map(ent -> {
                ClassDto dto = new ClassDto();
                return convertClassDto(dto, ent);
            });
            return classDtoPage;
        }
        return null;
    }

    private ClassDto convertClassDto(ClassDto dto, Class ent){
        dto = ent.convertToDto();
        dto.setStatusName(ConstantData.ClassSubjectStatus.getStatusNameByCode(ent.getStatus()));
        UserDto userDto = userService.findById(ent.getUser().getId());
        dto.setTeacherName(userDto.getFirstName() + " " + userDto.getLastName());
        return dto;
    }

    public ClassDto findById(Long id) {
        Class classEnt = classDao.findById(id).orElse(null);
        if (classEnt != null){
            ClassDto classDto = new ClassDto();
            classDto = convertClassDto(classDto, classEnt);
            List<ClassDetail> classDetails = classDetailDao.findAllByClassSubject(classEnt);
            if (classDetails != null || !classDetails.isEmpty()){
                List<ClassDetailDto> classDetailDtos = classDetails.stream()
                        .map(ent -> {
                            ClassDetailDto dto = ent.convertToDto();
                            if (ent.getScoreProcess() != null && ent.getScoreProcess() != null){
                                double finalScore = ent.getScoreProcess()*0.3 + ent.getScoreExam()*0.7;
                                dto.setFinalScore((double) Math.round((finalScore*10)/10));
                            }
                            return dto;
                        }).collect(Collectors.toList());
                classDto.setClassDetails(classDetailDtos);
            }
            return classDto;
        }
        return null;
    }
}
