package com.datn.app.dto;

import com.datn.app.entity.*;
import com.datn.app.util.AppUtil;

import java.util.Date;

public class StudentsDto extends BaseDto{
    private String fullName;
    private Date dob;
    private String address;
    private String email;
    private String phoneNumber;
    private Long nationId; //quốc tịch
    private Long provinceId; //tỉnh
    private Long districtId; //quận/thành phố/huyện
    private Long wardId; //phường/xã
    private String numberIdentityCard; //số cmmd/cccd/hộ chiếu
    private Date licenseDate; //ngày cấp
    private Long provinceLicensePlaceId; //nơi cấp (tỉnh)
    private Long districtLicensePlaceId; //nơi cấp(quận/thành phố/huyện)
    private String motherName;
    private Date motherDob;
    private String motherJob;
    private String motherNumberPhone;
    private String fatherName;
    private Date fatherDob;
    private String fatherJob;
    private String fatherNumberPhone;
    private int status; //0: nghỉ học; 1: đang học; 2: đã hoàn thành
    private String statusName;
    private int gender;
    private String currentAddress;
    private Long courseId;
    private String courseName;
    private Long unitId;
    private String unitName;
    private double gpa;

    public StudentsDto() { }

    @Override
    public Students convertToEnt() {
        return AppUtil.mapToDtoAndEnt(this, Students.class);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getNationId() {
        return nationId;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getWardId() {
        return wardId;
    }

    public void setWardId(Long wardId) {
        this.wardId = wardId;
    }

    public String getNumberIdentityCard() {
        return numberIdentityCard;
    }

    public void setNumberIdentityCard(String numberIdentityCard) {
        this.numberIdentityCard = numberIdentityCard;
    }

    public Date getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    public Long getProvinceLicensePlaceId() {
        return provinceLicensePlaceId;
    }

    public void setProvinceLicensePlaceId(Long provinceLicensePlaceId) {
        this.provinceLicensePlaceId = provinceLicensePlaceId;
    }

    public Long getDistrictLicensePlaceId() {
        return districtLicensePlaceId;
    }

    public void setDistrictLicensePlaceId(Long districtLicensePlaceId) {
        this.districtLicensePlaceId = districtLicensePlaceId;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getMotherDob() {
        return motherDob;
    }

    public void setMotherDob(Date motherDob) {
        this.motherDob = motherDob;
    }

    public String getMotherJob() {
        return motherJob;
    }

    public void setMotherJob(String motherJob) {
        this.motherJob = motherJob;
    }

    public String getMotherNumberPhone() {
        return motherNumberPhone;
    }

    public void setMotherNumberPhone(String motherNumberPhone) {
        this.motherNumberPhone = motherNumberPhone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getFatherDob() {
        return fatherDob;
    }

    public void setFatherDob(Date fatherDob) {
        this.fatherDob = fatherDob;
    }

    public String getFatherJob() {
        return fatherJob;
    }

    public void setFatherJob(String fatherJob) {
        this.fatherJob = fatherJob;
    }

    public String getFatherNumberPhone() {
        return fatherNumberPhone;
    }

    public void setFatherNumberPhone(String fatherNumberPhone) {
        this.fatherNumberPhone = fatherNumberPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
