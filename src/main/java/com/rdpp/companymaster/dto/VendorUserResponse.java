package com.rdpp.companymaster.dto;

import com.rdpp.companymaster.entity.VendorUser;

import java.time.LocalDateTime;

public class VendorUserResponse {

    private Long vendorUserId;
    private String vendorUserName;
    private String vendorUserEmail;
    private String vendorUserRole;
    private String vendorUserCountry;
    private String vendorUserStatus;
    private String vendorUserContact;
    private String vendorCode;
    private String createdBy;
    private String approvedBy;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public VendorUserResponse() {}

    public VendorUserResponse(VendorUser vendorUser) {
        this.vendorUserId = vendorUser.getVendorUserId();
        this.vendorUserName = vendorUser.getVendorUserName();
        this.vendorUserEmail = vendorUser.getVendorUserEmail();
        this.vendorUserRole = vendorUser.getVendorUserRole() != null ? vendorUser.getVendorUserRole().name() : null;
        this.vendorUserCountry = vendorUser.getVendorUserCountry();
        this.vendorUserStatus = vendorUser.getVendorUserStatus();
        this.vendorUserContact = vendorUser.getVendorUserContact();
        this.vendorCode = vendorUser.getVendor() != null ? vendorUser.getVendor().getVendorCode() : null;
        this.createdBy = vendorUser.getCreatedBy();
        this.approvedBy = vendorUser.getApprovedBy();
        this.createdTime = vendorUser.getCreatedTime();
        this.updatedTime = vendorUser.getUpdatedTime();
    }

    public Long getVendorUserId() {
        return vendorUserId;
    }

    public void setVendorUserId(Long vendorUserId) {
        this.vendorUserId = vendorUserId;
    }

    public String getVendorUserName() {
        return vendorUserName;
    }

    public void setVendorUserName(String vendorUserName) {
        this.vendorUserName = vendorUserName;
    }

    public String getVendorUserEmail() {
        return vendorUserEmail;
    }

    public void setVendorUserEmail(String vendorUserEmail) {
        this.vendorUserEmail = vendorUserEmail;
    }

    public String getVendorUserRole() {
        return vendorUserRole;
    }

    public void setVendorUserRole(String vendorUserRole) {
        this.vendorUserRole = vendorUserRole;
    }

    public String getVendorUserCountry() {
        return vendorUserCountry;
    }

    public void setVendorUserCountry(String vendorUserCountry) {
        this.vendorUserCountry = vendorUserCountry;
    }

    public String getVendorUserStatus() {
        return vendorUserStatus;
    }

    public void setVendorUserStatus(String vendorUserStatus) {
        this.vendorUserStatus = vendorUserStatus;
    }

    public String getVendorUserContact() {
        return vendorUserContact;
    }

    public void setVendorUserContact(String vendorUserContact) {
        this.vendorUserContact = vendorUserContact;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
