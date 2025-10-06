package com.rdpp.companymaster.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VendorRequest {

    @NotBlank(message = "Vendor code is required")
    @Size(max = 50, message = "Vendor code must not exceed 50 characters")
    private String vendorCode;
    @Size(max = 50, message = "Vendor type must not exceed 50 characters")
    private String vendorType;

    @NotBlank(message = "Vendor name is required")
    @Size(max = 100, message = "Vendor name must not exceed 100 characters")
    private String vendorName;

    @Size(max = 100, message = "Vendor domain must not exceed 100 characters")
    private String vendorDomain;

    @Email(message = "Email should be valid")
    @Size(max = 1000, message = "Email must not exceed 1000 characters")
    private String email;

    @Size(max = 100, message = "Contact must not exceed 100 characters")
    private String contact;

    @Size(max = 5, message = "Country must not exceed 5 characters")
    private String country;

    @Size(max = 100, message = "Product must not exceed 100 characters")
    private String product;

    private Integer maxNormalUsers;
    private Integer maxAdminUsers;

    @Size(max = 20, message = "Status must not exceed 20 characters")
    private String status;

    @Size(max = 50, message = "Created by must not exceed 50 characters")
    private String createdBy;

    @Size(max = 50, message = "Approved by must not exceed 50 characters")
    private String approvedBy;

    public VendorRequest() {}

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
}
