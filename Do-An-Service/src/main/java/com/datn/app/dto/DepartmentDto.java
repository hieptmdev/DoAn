package com.datn.app.dto;

import com.datn.app.entity.Department;
import com.datn.app.util.AppUtil;

import java.util.Date;

public class DepartmentDto extends BaseDto{
    private String name;
    private Date dateFounding;
    private Long unitId;
    private Long userManagerId;
    private String description;

    public DepartmentDto() {}

    @Override
    public Department convertToEnt() {
        return AppUtil.mapToDtoAndEnt(this, Department.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateFounding() {
        return dateFounding;
    }

    public void setDateFounding(Date dateFounding) {
        this.dateFounding = dateFounding;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUserManagerId() {
        return userManagerId;
    }

    public void setUserManagerId(Long userManagerId) {
        this.userManagerId = userManagerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
