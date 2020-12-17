package com.datn.app.entity;

import com.datn.app.dto.WardDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ward extends BaseEnt{
    private String name;
    private String prefix;
    private Long districtId;
    private Long provinceId;

    public Ward() { }

    @Override
    public WardDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, WardDto.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}
