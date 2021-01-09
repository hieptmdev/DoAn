package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Date createdDate;
    private Date updatedDate;

    public BaseEnt() { }

    public BaseEnt(Long id, String code, Date createdDate, Date updatedDate) {
        this.id = id;
        this.code = code;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public abstract BaseDto convertToDto();

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
