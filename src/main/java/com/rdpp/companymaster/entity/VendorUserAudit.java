package com.rdpp.companymaster.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VENDOR_USER_AUDIT")
public class VendorUserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENDOR_USER_ID")
    private Long vendorUserId;

    @Column(name = "VENDOR_USER_NAME", length = 50)
    private String vendorUserName;

    @Column(name = "VENDOR_USER_EMAIL", length = 100)
    private String vendorUserEmail;

    @Column(name = "VENDOR_USER_ROLE", length = 1)
    private String vendorUserRole;

    @Column(name = "VENDOR_USER_COUNTRY", length = 50)
    private String vendorUserCountry;

    @Column(name = "VENDOR_USER_STATUS", length = 20)
    private String vendorUserStatus;

    @Column(name = "VENDOR_USER_CONTACT", length = 20)
    private String vendorUserContact;

    @Column(name = "VENDOR_ID")
    private Long vendorId;

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "APPROVED_BY", length = 100)
    private String approvedBy;

    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

    @Column(name = "EVENT_TYPE", length = 20, nullable = false)
    private String eventType;

    public VendorUserAudit() {}

    public VendorUserAudit(VendorUser vendorUser, String eventType) {
        this.vendorUserId = vendorUser.getVendorUserId();
        this.vendorUserName = vendorUser.getVendorUserName();
        this.vendorUserEmail = vendorUser.getVendorUserEmail();
        this.vendorUserRole = vendorUser.getVendorUserRole() != null ? vendorUser.getVendorUserRole().name() : null;
        this.vendorUserCountry = vendorUser.getVendorUserCountry();
        this.vendorUserStatus = vendorUser.getVendorUserStatus();
        this.vendorUserContact = vendorUser.getVendorUserContact();
        this.vendorId = vendorUser.getVendor() != null ? vendorUser.getVendor().getVendorId() : null;
        this.createdBy = vendorUser.getCreatedBy();
        this.approvedBy = vendorUser.getApprovedBy();
        this.createdTime = vendorUser.getCreatedTime();
        this.updatedTime = vendorUser.getUpdatedTime();
        this.eventType = eventType;
    }

    // Getters and Setters
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

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}