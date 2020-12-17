package com.datn.app.dto;

import com.datn.app.entity.BaseEnt;
import com.datn.app.entity.StudyScore;

public class StudyScoreDto extends BaseDto{
    private String subjectCode; // mã môn
    private String subjectName; // tên môn học
    private String codeClass; // Mã lớp học
    private int credits; // số tín chỉ
    private int studyTimes;
    private double pointProcess;
    private double testScore;
    private double finalScore; // điểm tổng kết
    private String evaluate; // đánh giá

    public StudyScoreDto() { }

    @Override
    public StudyScore convertToEnt() {
        return null;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
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

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
