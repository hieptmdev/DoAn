package com.datn.app.entity;

import com.datn.app.dto.BaseDto;
import com.datn.app.dto.ClassDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Class extends BaseEnt {
    private String name;
    @ManyToOne
    private Subjects subjects; //môn học
    @ManyToOne
    private User user; //giảng viên phụ trách
    @ManyToOne
    private Course course; //khóa học
    private Date startDate;
    private Date endDate;
    private String calendar; //lịch học
    private int status; //0: chuẩn bị, 1: đang học, 2: kết thúc

    public Class() { }

    @Override
    public ClassDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, ClassDto.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
