package com.datn.app.entity;

import com.datn.app.dto.BaseDto;
import com.datn.app.dto.ProvinceDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Province extends BaseEnt{
    private String name;

    public Province() { }

    @Override
    public ProvinceDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, ProvinceDto.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
