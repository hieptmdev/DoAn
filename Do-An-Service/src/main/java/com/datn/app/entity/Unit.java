package com.datn.app.entity;

import com.datn.app.dto.BaseDto;
import com.datn.app.dto.UnitDto;
import com.datn.app.util.AppUtil;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Unit extends BaseEnt{
    @Column(nullable = false)
    private String name;
    private Date dateFounding;
    @OneToOne
    private User userManager;
    private String description;
    @OneToMany(mappedBy = "unit")
    private List<Department> departments;

    public Unit() { }

    @Override
    public UnitDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, UnitDto.class);
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
