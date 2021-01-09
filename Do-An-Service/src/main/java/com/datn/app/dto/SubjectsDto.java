package com.datn.app.dto;

import com.datn.app.entity.Subjects;
import com.datn.app.util.AppUtil;

public class SubjectsDto extends BaseDto{
    private String name;
    private int credits; //số tín chỉ
    private Long departmentId;
    private String departmentName;
    private String departmentUnitName;

    public SubjectsDto() {}

    @Override
    public Subjects convertToEnt() {
        return AppUtil.mapToDtoAndEnt(this, Subjects.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentUnitName() {
        return departmentUnitName;
    }

    public void setDepartmentUnitName(String departmentUnitName) {
        this.departmentUnitName = departmentUnitName;
    }
}
