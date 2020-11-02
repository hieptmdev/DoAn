package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Nation extends BaseEnt{
    private String name;
    private String niceName;
    private String code3;
    private Long numCode;
    private Long phoneCode;

    public Nation() { }

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

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public Long getNumCode() {
        return numCode;
    }

    public void setNumCode(Long numCode) {
        this.numCode = numCode;
    }

    public Long getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(Long phoneCode) {
        this.phoneCode = phoneCode;
    }
}
