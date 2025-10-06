package com.rdpp.companymaster.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VENDOR_USER")
public class VendorUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_user_seq")
    @SequenceGenerator(name = "vendor_user_seq", sequenceName = "VENDOR_USER_SEQ", allocationSize = 1)
    @Column(name = "VENDOR_USER_ID")
    private Long vendorUserId;

    @Column(name = "VENDOR_USER_NAME", length = 50, nullable = false)
    private String vendorUserName;

    @Column(name = "VENDOR_USER_EMAIL", length = 100)
    private String vendorUserEmail;

    @Column(name = "VENDOR_USER_ROLE", length = 1)
    @Enumerated(EnumType.STRING)
    private VendorUserRole vendorUserRole;

    @Column(name = "VENDOR_USER_COUNTRY", length = 5)
    private String vendorUserCountry;

    @Column(name = "VENDOR_USER_STATUS", length = 20)
    private String vendorUserStatus;

    @Column(name = "VENDOR_USER_CONTACT", length = 20)
    private String vendorUserContact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VENDOR_ID", referencedColumnName = "VENDOR_ID")
    private Vendor vendor;

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "APPROVED_BY", length = 100)
    private String approvedBy;

    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

    public enum VendorUserRole {
        A, U
    }

    @PrePersist
    protected void onCreate() {
        createdTime = LocalDateTime.now();
        if (vendorUserStatus == null) {
            vendorUserStatus = "A";
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTime = LocalDateTime.now();
    }

    public VendorUser() {}

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

    public VendorUserRole getVendorUserRole() {
        return vendorUserRole;
    }

    public void setVendorUserRole(VendorUserRole vendorUserRole) {
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

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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