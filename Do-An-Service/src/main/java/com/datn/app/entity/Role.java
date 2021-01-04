package com.datn.app.entity;

import com.datn.app.dto.RoleDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Role extends BaseEnt {
    @Column(nullable = false)
    private String name;
    private String description;

    public Role() { }

    @Override
    public RoleDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, RoleDto.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
