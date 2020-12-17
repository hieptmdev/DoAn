package com.datn.app.dto;

import com.datn.app.entity.BaseEnt;

public class ProvinceDto extends BaseDto{
    private String name;

    public ProvinceDto() { }

    @Override
    public BaseEnt convertToEnt() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
