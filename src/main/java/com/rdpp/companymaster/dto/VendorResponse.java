package com.rdpp.companymaster.dto;

import com.rdpp.companymaster.entity.Vendor;

import java.time.LocalDateTime;

public class VendorResponse {

    private Long vendorId;
    private String vendorCode;
    private String vendorType;
    private String vendorName;
    private String vendorDomain;
    private String email;
    private String contact;
    private String country;
    private String product;
    private Integer maxNormalUsers;
    private Integer maxAdminUsers;
    private String status;
    private String createdBy;
    private String approvedBy;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public VendorResponse() {}

    public VendorResponse(Vendor vendor) {
        this.vendorId = vendor.getVendorId();
        this.vendorCode = vendor.getVendorCode();
        this.vendorType = vendor.getVendorType();
        this.vendorName = vendor.getVendorName();
        this.vendorDomain = vendor.getVendorDomain();
        this.email = vendor.getEmail();
        this.contact = vendor.getContact();
        this.country = vendor.getCountry();
        this.product = vendor.getProduct();
        this.maxNormalUsers = vendor.getMaxNormalUsers();
        this.maxAdminUsers = vendor.getMaxAdminUsers();
        this.status = vendor.getStatus();
        this.createdBy = vendor.getCreatedBy();
        this.approvedBy = vendor.getApprovedBy();
        this.createdTime = vendor.getCreatedTime();
        this.updatedTime = vendor.getUpdatedTime();
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorDomain() {
        return vendorDomain;
    }

    public void setVendorDomain(String vendorDomain) {
        this.vendorDomain = vendorDomain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getMaxNormalUsers() {
        return maxNormalUsers;
    }

    public void setMaxNormalUsers(Integer maxNormalUsers) {
        this.maxNormalUsers = maxNormalUsers;
    }

    public Integer getMaxAdminUsers() {
        return maxAdminUsers;
    }

    public void setMaxAdminUsers(Integer maxAdminUsers) {
        this.maxAdminUsers = maxAdminUsers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
