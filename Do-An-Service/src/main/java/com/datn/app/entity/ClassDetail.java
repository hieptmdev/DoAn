package com.datn.app.entity;

import com.datn.app.dto.ClassDetailDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ClassDetail extends BaseEnt {
    @ManyToOne
    private Students students;
    @ManyToOne
    private Class classSubject;
    private Double scoreProcess;
    private Double scoreExam;

    public ClassDetail() {}

    @Override
    public ClassDetailDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, ClassDetailDto.class);
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Class getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(Class classSubject) {
        this.classSubject = classSubject;
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
