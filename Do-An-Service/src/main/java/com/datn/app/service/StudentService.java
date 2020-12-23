package com.datn.app.service;

import com.datn.app.constant.ConstantData;
import com.datn.app.dao.idao.*;
import com.datn.app.dto.StudentsDto;
import com.datn.app.dto.StudyScoreDto;
import com.datn.app.entity.Students;
import com.datn.app.entity.StudyScore;
import com.datn.app.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UnitDao unitDao;
    @Autowired
    private NationDao nationDao;
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private DistrictDao districtDao;
    @Autowired
    private WardDao wardDao;

    public Page<StudentsDto> search(Pageable pageable, String code, String name, String courseId, String unitId){
        if (code.equals("undefined") || code.equals("")) code = "";
        if (name.equals("undefined") || name.equals("")) name = "";
        if (courseId.equals("undefined") || courseId.equals("")) courseId = "0";
        if (unitId.equals("undefined") || courseId.equals("")) unitId = "0";
        Page<Students> studentsPage = studentDao.search(pageable, code, name.toLowerCase(), Long.parseLong(courseId), Long.parseLong(unitId));
        if (studentsPage != null && !studentsPage.isEmpty()){
            Page<StudentsDto> dtoPage = studentsPage.map(ent -> {
                StudentsDto dto = new StudentsDto();
                return convertStudentsDto(dto, ent);
            });
            return dtoPage;
        }
        return  null;
    }

    public StudentsDto findByCode(String code) {
        return convertStudentsDto(new StudentsDto(), studentDao.findByCode(code));
    }

    public List<StudyScoreDto> findAllScore(String code) {
        Students students = studentDao.findByCode(code);
        if (students != null){
            List<StudyScoreDto> scoreDtoList = new ArrayList<>();
            List<StudyScore> scoreList = students.getStudyScores();
            if (scoreList != null && !scoreList.isEmpty()){
                return scoreList.stream().map(StudyScore::convertToDto).collect(Collectors.toList());
            }
            return null;
        }
        return null;
    }

    public String exportScore(String code){
        String path = null;
        Students students = studentDao.findByCode(code);
        if (students != null){
            List<StudyScore> scoreList = students.getStudyScores();
            if (scoreList != null && !scoreList.isEmpty()){

            }
        }
        return null;
    }

    @Transactional
    public StudentsDto saveOrUpdate(StudentsDto dto) {
        Students students;
        if (dto != null) {
            if (dto.getId() == null || dto.getId() == 0L) {
                students = dto.convertToEnt();
                students.setCode(AppUtil.generateStudentCode());
                students.setCourse(courseDao.findById(dto.getCourseId()).orElse(null));
                students.setUnit(unitDao.findById(dto.getUnitId()).orElse(null));
                students.setNation(nationDao.findById(dto.getNationId()).orElse(null));
                students.setProvince(provinceDao.findById(dto.getProvinceId()).orElse(null));
                students.setProvinceLicensePlace(provinceDao.findById(dto.getProvinceLicensePlaceId()).orElse(null));
                students.setDistrict(districtDao.findById(dto.getDistrictId()).orElse(null));
                students.setDistrictLicensePlace(districtDao.findById(dto.getDistrictLicensePlaceId()).orElse(null));
            } else {
                students = studentDao.findById(dto.getId()).orElse(null);
                if (students == null) {
                    return null;
                }
                students = dto.convertToEnt();
                students.setStatus(students.getStatus() == dto.getStatus() ? students.getStatus() : dto.getStatus());
                students.setCourse(courseDao.findById(dto.getCourseId()).orElse(null));
                students.setUnit(unitDao.findById(dto.getUnitId()).orElse(null));
                students.setProvince(provinceDao.findById(dto.getProvinceId()).orElse(null));
                students.setDistrict(districtDao.findById(dto.getDistrictId()).orElse(null));
            }
            students.setWard(wardDao.findById(dto.getWardId()).orElse(null));

            return studentDao.saveEntity(students).convertToDto();
        }
        return null;

    }

    private StudentsDto convertStudentsDto(StudentsDto dto, Students ent){
        dto = ent.convertToDto();
        dto.setUnitId(ent.getUnit() != null ? ent.getUnit().getId() : null);
        dto.setUnitName(ent.getUnit() != null ? ent.getUnit().getName() : null);
        dto.setStatusName(ConstantData.StudentsStatus.getStatusNameByCode(ent.getStatus()));
        if (ent.getStudyScores() != null || !ent.getStudyScores().isEmpty()){
            int totalCredits = 0;
            double totalScore = 0;
            List<StudyScore> clone = new ArrayList<>();
            clone.addAll(ent.getStudyScores());
            for (StudyScore s : ent.getStudyScores()){
                totalCredits += s.getSubject().getCredits();
                double score = AppUtil.convertScore(s.getFinalScore());
                for (StudyScore c : clone){
                    if (c.getSubject().equals(s.getSubject()) && c.getFinalScore() > score){
                        score = AppUtil.convertScore(c.getFinalScore());
                    }
                }
                totalScore += score * s.getSubject().getCredits();
            }
//            double totalScore = ent.getStudyScores().stream()
//                    .mapToDouble(s -> s.getFinalScore() * s.getSubject().getCredits()).sum();
//            int totalCredits = ent.getStudyScores().stream()
//                    .mapToInt(s -> s.getSubject().getCredits()).sum();
            dto.setGpa(Math.round((totalScore / totalCredits) * 100) / 100);
        }
        return dto;
    }
}
