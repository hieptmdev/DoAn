package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Province extends BaseEnt{
    private String name;

    public Province() { }

    @Override
    public BaseDto convertToDto() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
