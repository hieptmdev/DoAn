package com.datn.app.dto;

import com.datn.app.entity.BaseEnt;
import java.util.Date;

public class UnitDto extends BaseDto{
    private String name;
    private Date dateFounding;
    private Long userManagerId;
    private String userManagerName;
    private Long userDeputyManagerId;
    private String userDeputyManagerName;
    private String description;

    public UnitDto() { }

    @Override
    public BaseEnt convertToEnt() { return null; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateFounding() {
        return dateFounding;
    }

    public void setDateFounding(Date dateFounding) {
        this.dateFounding = dateFounding;
    }

    public Long getUserManagerId() {
        return userManagerId;
    }

    public void setUserManagerId(Long userManagerId) {
        this.userManagerId = userManagerId;
    }

    public String getUserManagerName() {
        return userManagerName;
    }

    public void setUserManagerName(String userManagerName) {
        this.userManagerName = userManagerName;
    }

    public Long getUserDeputyManagerId() {
        return userDeputyManagerId;
    }

    public void setUserDeputyManagerId(Long userDeputyManagerId) {
        this.userDeputyManagerId = userDeputyManagerId;
    }

    public String getUserDeputyManagerName() {
        return userDeputyManagerName;
    }

    public void setUserDeputyManagerName(String userDeputyManagerName) {
        this.userDeputyManagerName = userDeputyManagerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
