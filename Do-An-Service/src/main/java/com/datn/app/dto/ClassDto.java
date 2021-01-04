package com.datn.app.dto;

import com.datn.app.entity.Class;
import com.datn.app.util.AppUtil;

import java.util.Date;
import java.util.List;

public class ClassDto extends BaseDto{
    private String name;
    private String subjectsCode; //môn học
    private Long subjectsId;
    private String teacherName; //giảng viên phụ trách
    private Long userId;
    private String courseName; //khóa học
    private Long courseId;
    private Date startDate;
    private Date endDate;
    private String calendar; //lịch học
    private int status; //0: chuẩn bị, 1: đang học, 2: kết thúc
    private String statusName;
    private List<ClassDetailDto> classDetails;

    public ClassDto () {}

    @Override
    public Class convertToEnt() {
        return AppUtil.mapToDtoAndEnt(this, Class.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectsCode() {
        return subjectsCode;
    }

    public void setSubjectsCode(String subjectsCode) {
        this.subjectsCode = subjectsCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getSubjectsId() {
        return subjectsId;
    }

    public void setSubjectsId(Long subjectId) {
        this.subjectsId = subjectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<ClassDetailDto> getClassDetails() {
        return classDetails;
    }

    public void setClassDetails(List<ClassDetailDto> classDetails) {
        this.classDetails = classDetails;
    }
}
