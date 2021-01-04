package com.datn.app.dto;

import com.datn.app.entity.Role;
import com.datn.app.util.AppUtil;

public class RoleDto extends BaseDto{
    private String name;
    private String description;

    public RoleDto() {}

    @Override
    public Role convertToEnt() {
        return AppUtil.mapToDtoAndEnt(this, Role.class);
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
