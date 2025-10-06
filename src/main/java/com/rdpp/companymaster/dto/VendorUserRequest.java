package com.rdpp.companymaster.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VendorUserRequest {

    private Long vendorUserId;

    @NotBlank(message = "Vendor user name is required")
    @Size(max = 50, message = "Vendor user name must not exceed 50 characters")
    private String vendorUserName;

    @Size(max = 100, message = "Vendor user email must not exceed 100 characters")
    private String vendorUserEmail;

    @NotNull(message = "Vendor user role is required")
    private String vendorUserRole;

    @Size(max = 5, message = "Vendor user country must not exceed 5 characters")
    private String vendorUserCountry;

    @Size(max = 20, message = "Vendor user status must not exceed 20 characters")
    private String vendorUserStatus;

    @Size(max = 20, message = "Vendor user contact must not exceed 20 characters")
    private String vendorUserContact;

    @NotNull(message = "Vendor Code is required")
    @Size(max = 50, message = "Vendor code must not exceed 50 characters")
    private String vendorCode;

    @Size(max = 100, message = "Created by must not exceed 100 characters")
    private String createdBy;

    @Size(max = 100, message = "Approved by must not exceed 100 characters")
    private String approvedBy;

    public VendorUserRequest() {}

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
}
