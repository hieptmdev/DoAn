package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class CodeResetPassword extends BaseEnt{
    private Date expireDate;
    @Column(columnDefinition = "boolean default false")
    private boolean used;
    @ManyToOne
    private User user;

    public CodeResetPassword() { }

    @Override
    public BaseDto convertToDto() {
        return null;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
