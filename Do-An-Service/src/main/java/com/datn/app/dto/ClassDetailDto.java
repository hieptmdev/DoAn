package com.datn.app.dto;

import com.datn.app.entity.ClassDetail;
import com.datn.app.util.AppUtil;

import java.util.Date;

public class ClassDetailDto extends BaseDto{
    private Long studentsId;
    private String studentsCode;
    private String studentsFullName;
    private Date studentsDob;
    private Long classSubjectId;
    private Double scoreProcess;
    private Double scoreExam;
    private Double finalScore;
    private String studentsCourseName;

    public ClassDetailDto() { }

    @Override
    public ClassDetail convertToEnt() {
        return AppUtil.mapToDtoAndEnt(this, ClassDetail.class);
    }

    public Long getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(Long studentsId) {
        this.studentsId = studentsId;
    }

    public String getStudentsCode() {
        return studentsCode;
    }

    public void setStudentsCode(String studentsCode) {
        this.studentsCode = studentsCode;
    }

    public Long getClassSubjectId() {
        return classSubjectId;
    }

    public void setClassSubjectId(Long classSubjectId) {
        this.classSubjectId = classSubjectId;
    }

    public Double getScoreProcess() {
        return scoreProcess;
    }

    public void setScoreProcess(Double scoreProcess) {
        this.scoreProcess = scoreProcess;
    }

    public Double getScoreExam() {
        return scoreExam;
    }

    public void setScoreExam(Double scoreExam) {
        this.scoreExam = scoreExam;
    }

    public String getStudentsFullName() {
        return studentsFullName;
    }

    public void setStudentsFullName(String studentsFullName) {
        this.studentsFullName = studentsFullName;
    }

    public Date getStudentsDob() {
        return studentsDob;
    }

    public void setStudentsDob(Date studentsDob) {
        this.studentsDob = studentsDob;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public String getStudentsCourseName() {
        return studentsCourseName;
    }

    public void setStudentsCourseName(String studentsCourseName) {
        this.studentsCourseName = studentsCourseName;
    }
}
