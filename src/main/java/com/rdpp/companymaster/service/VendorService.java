package com.rdpp.companymaster.service;

import com.rdpp.companymaster.entity.Vendor;
import com.rdpp.companymaster.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Long vendorId) {
        return vendorRepository.findById(vendorId);
    }

    public Optional<Vendor> getVendorByCode(String vendorCode) {
        return vendorRepository.findByVendorCode(vendorCode);
    }

    public Vendor updateVendor(Long vendorId, Vendor vendorDetails) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + vendorId));

        vendor.setVendorCode(vendorDetails.getVendorCode());
        vendor.setVendorType(vendorDetails.getVendorType());
        vendor.setVendorName(vendorDetails.getVendorName());
        vendor.setVendorDomain(vendorDetails.getVendorDomain());
        vendor.setEmail(vendorDetails.getEmail());
        vendor.setContact(vendorDetails.getContact());
        vendor.setCountry(vendorDetails.getCountry());
        vendor.setProduct(vendorDetails.getProduct());
        vendor.setMaxNormalUsers(vendorDetails.getMaxNormalUsers());
        vendor.setMaxAdminUsers(vendorDetails.getMaxAdminUsers());
        vendor.setStatus(vendorDetails.getStatus());
        vendor.setApprovedBy(vendorDetails.getApprovedBy());

        return vendorRepository.save(vendor);
    }

    public Vendor updateVendorByCode(String vendorCode, Vendor vendorDetails) {
        Vendor vendor = vendorRepository.findByVendorCode(vendorCode)
                .orElseThrow(() -> new RuntimeException("Vendor not found with code: " + vendorCode));

        vendor.setVendorType(vendorDetails.getVendorType());
        vendor.setVendorName(vendorDetails.getVendorName());
        vendor.setVendorDomain(vendorDetails.getVendorDomain());
        vendor.setEmail(vendorDetails.getEmail());
        vendor.setContact(vendorDetails.getContact());
        vendor.setCountry(vendorDetails.getCountry());
        vendor.setProduct(vendorDetails.getProduct());
        vendor.setMaxNormalUsers(vendorDetails.getMaxNormalUsers());
        vendor.setMaxAdminUsers(vendorDetails.getMaxAdminUsers());
        vendor.setStatus(vendorDetails.getStatus());
        vendor.setApprovedBy(vendorDetails.getApprovedBy());

        return vendorRepository.save(vendor);
    }

    public void deleteVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + vendorId));
        vendorRepository.delete(vendor);
    }

    public void deleteVendorByCode(String vendorCode) {
        Vendor vendor = vendorRepository.findByVendorCode(vendorCode)
                .orElseThrow(() -> new RuntimeException("Vendor not found with code: " + vendorCode));
        vendorRepository.delete(vendor);
    }
}