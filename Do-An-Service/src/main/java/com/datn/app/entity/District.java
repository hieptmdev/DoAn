package com.datn.app.entity;

import com.datn.app.dto.DistrictDto;
import com.datn.app.util.AppUtil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class District extends BaseEnt{
    private String name;
    private String prefix;
    private Long provinceId;

    public District() { }

    @Override
    public DistrictDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, DistrictDto.class);
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
