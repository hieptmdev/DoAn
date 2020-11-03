package com.datn.app.entity;

import com.datn.app.dto.BaseDto;
import com.datn.app.dto.StudentsDto;
import com.datn.app.util.AppUtil;

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
    @ManyToOne
    private Province province; //tỉnh
    @ManyToOne
    private District district; //quận/thành phố/huyện
    @ManyToOne
    private Ward ward; //phường/xã
    private String numberIdentityCard; //số cmmd/cccd/hộ chiếu
    private Date licenseDate; //ngày cấp
    @ManyToOne
    private Province provinceLicensePlace; //nơi cấp (tỉnh)
    @ManyToOne
    private District districtLicensePlace; //nơi cấp(quận/thành phố/huyện)
    private String motherName;
    private Date motherDob;
    private String motherJob;
    private String motherNumberPhone;
    private String fatherName;
    private Date fatherDob;
    private String fatherJob;
    private String fatherNumberPhone;
    @Column(columnDefinition = "int default 1")
    private int status; //0: nghỉ học; 1: đang học; 2: đã hoàn thành
    @Column(columnDefinition = "int default 2")
    private int gender;

    public Students() { }

    @Override
    public StudentsDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, StudentsDto.class);
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

    public Province getProvinceLicensePlace() {
        return provinceLicensePlace;
    }

    public void setProvinceLicensePlace(Province provinceLicensePlace) {
        this.provinceLicensePlace = provinceLicensePlace;
    }

    public District getDistrictLicensePlace() {
        return districtLicensePlace;
    }

    public void setDistrictLicensePlace(District districtLicensePlace) {
        this.districtLicensePlace = districtLicensePlace;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
