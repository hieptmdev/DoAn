package com.datn.app.entity;

import com.datn.app.dto.BaseDto;
import com.datn.app.dto.StudyScoreDto;
import com.datn.app.util.AppUtil;

import javax.persistence.*;

@Entity
@Table
public class StudyScore extends BaseEnt{
    @ManyToOne
    private Students student;
    @OneToOne
    private Class subjectClass;
    @OneToOne
    private Subjects subject;
    @Column(columnDefinition = "int default 1")
    private int studyTimes; // lần học
    private double pointProcess; // điểm quá trình
    private double testScore; // điểm kiểm tra
    private double finalScore;

    public StudyScore() { }

    @Override
    public StudyScoreDto convertToDto() {
        StudyScoreDto dto = AppUtil.mapToDtoAndEnt(this, StudyScoreDto.class);
        dto.setCredits(this.getSubject().getCredits());
        dto.setEvaluate(this.getFinalScore() >= 4.00 ? "ĐẠT" : "HỌC LẠI");
        return dto;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Class getSubjectClass() {
        return subjectClass;
    }

    public void setSubjectClass(Class subjectClass) {
        this.subjectClass = subjectClass;
    }

    public int getStudyTimes() {
        return studyTimes;
    }

    public void setStudyTimes(int studyTimes) {
        this.studyTimes = studyTimes;
    }

    public double getPointProcess() {
        return pointProcess;
    }

    public void setPointProcess(double pointProcess) {
        this.pointProcess = pointProcess;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }
}
