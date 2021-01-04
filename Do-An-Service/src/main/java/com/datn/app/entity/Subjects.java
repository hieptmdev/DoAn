package com.datn.app.entity;

import com.datn.app.dto.SubjectsDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Subjects extends BaseEnt{
    private String name;
    private int credits; //số tín chỉ
    @ManyToOne
    private Department department;

    public Subjects() { }

    @Override
    public SubjectsDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, SubjectsDto.class);
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
