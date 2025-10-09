package com.rdpp.companymaster.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VENDOR_AUDIT")
public class VendorAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENDOR_ID")
    private Long vendorId;

    @Column(name = "VENDOR_CODE", length = 50)
    private String vendorCode;

    @Column(name = "VENDOR_TYPE", length = 50)
    private String vendorType;

    @Column(name = "VENDOR_NAME", length = 100)
    private String vendorName;

    @Column(name = "VENDOR_DOMAIN", length = 100)
    private String vendorDomain;

    @Column(name = "EMAIL", length = 1000)
    private String email;

    @Column(name = "CONTACT", length = 100)
    private String contact;

    @Column(name = "COUNTRY", length = 5)
    private String country;

    @Column(name = "PRODUCT", length = 100)
    private String product;

    @Column(name = "MAX_NORMAL_USERS")
    private Integer maxNormalUsers;

    @Column(name = "MAX_ADMIN_USERS")
    private Integer maxAdminUsers;

    @Column(name = "STATUS", length = 20)
    private String status;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "APPROVED_BY", length = 50)
    private String approvedBy;

    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

    @Column(name = "EVENT_TYPE", length = 20, nullable = false)
    private String eventType;

    public VendorAudit() {}

    public VendorAudit(Vendor vendor, String eventType) {
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
        this.eventType = eventType;
    }

    // Getters and Setters
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}