package com.datn.app.dto;

import com.datn.app.entity.Subjects;
import com.datn.app.util.AppUtil;

public class SubjectsDto extends BaseDto{
    private String name;
    private int credits; //số tín chỉ
    private Long departmentId;

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
}
