package com.datn.app.dto;

import com.datn.app.entity.BaseEnt;

import java.util.Date;

public abstract class BaseDto {
    private Long id;
    private String code;

    public BaseDto() { }

    public abstract BaseEnt convertToEnt();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
