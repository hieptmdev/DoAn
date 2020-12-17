package com.datn.app.entity;

import com.datn.app.dto.BaseDto;
import com.datn.app.dto.CourseDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Course extends BaseEnt{
    private String name;
    private Date startDate;
    private Date endDate;
    private int targets; //chỉ tiêu số lượng tuyển sinh
    private int reality; //thực tế tuyển sinh
    private String description;
    private int number;

    public Course() { }

    @Override
    public CourseDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, CourseDto.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getTargets() {
        return targets;
    }

    public void setTargets(int targets) {
        this.targets = targets;
    }

    public int getReality() {
        return reality;
    }

    public void setReality(int reality) {
        this.reality = reality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
