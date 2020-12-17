package com.datn.app.dto;

import com.datn.app.entity.Ward;

public class WardDto extends BaseDto{
    private String name;
    private String prefix;
    private Long districtId;
    private Long provinceId;

    public WardDto() { }

    @Override
    public Ward convertToEnt() {
        return null;
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
