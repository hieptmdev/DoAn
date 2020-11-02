package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Unit extends BaseEnt{
    @Column(nullable = false)
    private String name;
    private Date dateFounding;
    @OneToOne
    private User userManager;
    @OneToOne
    private User userDeputyManager;
    private String description;
    @OneToMany(mappedBy = "unit")
    private List<UserInfor> userInforList;
    @OneToMany(mappedBy = "unit")
    private List<Department> departments;

    public Unit() { }

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

    public Date getDateFounding() {
        return dateFounding;
    }

    public void setDateFounding(Date dateFounding) {
        this.dateFounding = dateFounding;
    }

    public User getUserManager() {
        return userManager;
    }

    public void setUserManager(User userManager) {
        this.userManager = userManager;
    }

    public User getUserDeputyManager() {
        return userDeputyManager;
    }

    public void setUserDeputyManager(User userDeputyManager) {
        this.userDeputyManager = userDeputyManager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserInfor> getUsers() {
        return userInforList;
    }

    public void setUsers(List<UserInfor> userInforList) {
        this.userInforList = userInforList;
    }

    public List<UserInfor> getUserInforList() {
        return userInforList;
    }

    public void setUserInforList(List<UserInfor> userInforList) {
        this.userInforList = userInforList;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
