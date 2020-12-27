package com.datn.app.dto;

import com.datn.app.entity.BaseEnt;

public class ClassDetailDto extends BaseDto{
    private Long studentId;
    private String studentCode;
    private Long classSubjectId;
    private Double scoreProcess;
    private Double scoreExam;

    public ClassDetailDto() { }

    @Override
    public BaseEnt convertToEnt() {
        return null;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
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
}
