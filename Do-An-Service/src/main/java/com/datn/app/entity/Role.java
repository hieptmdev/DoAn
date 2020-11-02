package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Role extends BaseEnt {
    @Column(nullable = false)
    private String name;
    private String description;
    @OneToMany(mappedBy = "role")
    private List<UserInfor> userInforList;

    public Role() { }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserInfor> getUserInforList() {
        return userInforList;
    }

    public void setUserInforList(List<UserInfor> userInforList) {
        this.userInforList = userInforList;
    }
}
