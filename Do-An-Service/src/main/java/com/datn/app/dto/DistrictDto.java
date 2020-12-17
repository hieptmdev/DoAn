package com.datn.app.dto;

import com.datn.app.entity.District;

public class DistrictDto extends BaseDto{
    private String name;
    private String prefix;
    private Long provinceId;

    public DistrictDto() { }

    @Override
    public District convertToEnt() {
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

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}
