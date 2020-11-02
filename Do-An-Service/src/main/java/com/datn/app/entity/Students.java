package com.datn.app.entity;

import com.datn.app.dto.BaseDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Students extends BaseEnt{
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private Date dob;
    private String address;
    private String email;
    private String phoneNumber;
    @ManyToOne
    private Nation nation; //quốc tịch

    @Override
    public BaseDto convertToDto() {
        return null;
    }
}
