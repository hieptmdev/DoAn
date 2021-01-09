package com.datn.app.service;

import com.datn.app.constant.ConstantData;
import com.datn.app.dao.idao.*;
import com.datn.app.dto.ClassDetailDto;
import com.datn.app.dto.ClassDto;
import com.datn.app.dto.MessageResponse;
import com.datn.app.dto.UserDto;
import com.datn.app.entity.*;
import com.datn.app.entity.Class;
import com.datn.app.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @Autowired
    private UserDao userDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private CourseDao courseDao;

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
        if (ent.getUser() != null) {
            UserDto userDto = userService.findById(ent.getUser().getId());
            dto.setTeacherName(userDto.getFirstName() + " " + userDto.getLastName());
        }
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

    @Transactional
    public MessageResponse deleteClassDetails(ClassDto dto, HttpServletRequest request) {
        Class ent = classDao.findById(dto.getId()).orElse(null);
        if (ent != null){
            dto.getClassDetails().stream().forEach(cd -> {
                if (cd.isChecked()) {
                    classDetailDao.deleteById(cd.getId());
                }
            });
            return new MessageResponse(200, "Xóa thành công");
        }
        return new MessageResponse(404, "Dữ liệu không tồn tại");
    }

    @Transactional
    public MessageResponse deleteClassDetails(Long id, HttpServletRequest request) {
        ClassDetail classDetail = classDetailDao.findById(id).orElse(null);
        if (classDetail != null){
            classDetailDao.deleteById(id);
            return new MessageResponse(200, "Xóa thành công");
        }
        return new MessageResponse(404, "Dữ liệu không tồn tại");
    }

    public List<ClassDto> findAllClassSameSubject(String classSubjectId, String subjectId, String courseId) {
        List<Class> entities = classDao.findAllClassSameSubject(Long.parseLong(classSubjectId), Long.parseLong(subjectId), Long.parseLong(courseId));
        if (entities != null || !entities.isEmpty()){
            return entities.stream().map(Class::convertToDto).collect(Collectors.toList());
        }
        return null;
    }

    public MessageResponse transfer(ClassDto dto, String classSubjectId, HttpServletRequest request) {
        Class classSubjectTransfer = classDao.findById(Long.parseLong(classSubjectId)).orElse(null);
        if (classSubjectTransfer != null) {
            if (dto != null) {
                if (dto.getId() != null || dto.getId() > 0L) {
                    Class entity = classDao.findById(dto.getId()).orElse(null);
                    if (entity != null) {
                        if (dto.getClassDetails() != null || !dto.getClassDetails().isEmpty()) {
                            List<ClassDetail> classDetails = new ArrayList<>();
                            dto.getClassDetails().stream().forEach(cd -> {
                                ClassDetail classDetail = classDetailDao.findById(cd.getId()).orElse(null);
                                if (classDetail != null && cd.isChecked()) {
                                    classDetail.setClassSubject(classSubjectTransfer);
                                }
                            });
                            classDetailDao.saveAllEntities(classDetails);
                            return new MessageResponse(200, "Thực hiện thao tác thành công");
                        }
                        return new MessageResponse(400, "Không có dữ liệu được gửi về");
                    }
                    return new MessageResponse(404, "Dữ liệu không tồn tại");
                }
                return new MessageResponse(400, "Không có dữ liệu được gửi về");
            }
            return new MessageResponse(400, "Không có dữ liệu được gửi về");
        }
        return new MessageResponse(404, "Lớp học phần chuyển đến không tồn tại");
    }

    public MessageResponse transfer(String classDetailId, String classSubjectId, HttpServletRequest request) {
        Class classSubjectTransfer = classDao.findById(Long.parseLong(classSubjectId)).orElse(null);
        if (classSubjectTransfer != null){
            ClassDetail classDetail = classDetailDao.findById(Long.parseLong(classDetailId)).orElse(null);
            if (classDetail != null){
                classDetail.setClassSubject(classSubjectTransfer);
                classDetailDao.saveEntity(classDetail);
            }
            return new MessageResponse(404, "Dữ liệu không tồn tại");
        }
        return new MessageResponse(404, "Lớp học phần chuyển đến không tồn tại");
    }

    @Transactional
    public ClassDto saveOrUpdate(ClassDto dto, HttpServletRequest request) {
        Class entity;
        User user = new User();
        Subjects subjects = new Subjects();
        Course course = new Course();
        if (dto != null){
            if (dto.getUserId() != null) user = userDao.findById(dto.getUserId()).orElse(null);
            if (dto.getSubjectsId() != null) subjects = subjectDao.findById(dto.getSubjectsId()).orElse(null);
            if (dto.getCourseId() != null) course = courseDao.findById(dto.getCourseId()).orElse(null);
            if (dto.getId() == null){
                entity = dto.convertToEnt();
                entity.setStatus(0);
                if (subjects != null) {
                    entity.setCode(AppUtil.generateCSCode(subjects.getCode()));
                }
                String str[] = entity.getCode().split("\\.");
                entity.setName(dto.getName().trim() + " (" + str[str.length - 1] + ")");
            }else {
                entity = classDao.findById(dto.getId()).get();
                entity.setName(dto.getName());
                entity.setCalendar(dto.getCalendar());
                entity.setStatus(dto.getStatus());
                entity.setStartDate(dto.getStartDate());
                entity.setEndDate(dto.getEndDate());
            }
            entity.setUser(user);
            entity.setSubjects(subjects);
            entity.setCourse(course);
            return classDao.saveEntity(entity).convertToDto();
        }
        return null;
    }
}
