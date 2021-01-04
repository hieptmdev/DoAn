package com.datn.app.entity;

import com.datn.app.dto.UserDto;
import com.datn.app.util.AppUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class UserInfor extends BaseEnt {
    @OneToOne
    private User user;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(columnDefinition = "int default 2")
    private int gender; //0: nam, 1: nữ, 2: khác
    private Date dob;
    private String address;
    private String email;
    private String numberPhone;
    @ManyToOne
    private Role role;
    @ManyToOne
    private Unit unit;
    private Date workStartDate;
    private Date workEndDate;
    private int qualifications; //trình độ chuyên môn
    @ManyToOne
    private Nation nation; //quốc tịch
    @ManyToOne
    private Province province; //tỉnh
    @ManyToOne
    private District district; //quận/thành phố/huyện
    @ManyToOne
    private Ward ward; //phường/xã
    @ManyToOne
    private Department department;

    public UserInfor() { }

    @Override
    public UserDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, UserDto.class);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public Date getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate(Date workEndDate) {
        this.workEndDate = workEndDate;
    }

    public int getQualifications() {
        return qualifications;
    }

    public void setQualifications(int qualifications) {
        this.qualifications = qualifications;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
