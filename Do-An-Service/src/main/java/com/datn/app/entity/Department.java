package com.datn.app.entity;

import com.datn.app.dto.DepartmentDto;
import com.datn.app.util.AppUtil;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Department extends BaseEnt{
    private String name;
    private Date dateFounding;
    @ManyToOne
    private Unit unit;
    @OneToOne
    private User userManager;
    private String description;

    public Department() { }

    @Override
    public DepartmentDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, DepartmentDto.class);
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public User getUserManager() {
        return userManager;
    }

    public void setUserManager(User userManager) {
        this.userManager = userManager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
