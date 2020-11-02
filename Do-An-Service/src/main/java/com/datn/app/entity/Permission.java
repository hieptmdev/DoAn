package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Permission extends BaseEnt{
    @ManyToOne
    private Category category;
    @ManyToOne
    private Role role;

    public Permission() { }

    @Override
    public BaseDto convertToDto() {
        return null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
