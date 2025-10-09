package com.rdpp.companymaster.service;

import com.rdpp.companymaster.entity.Vendor;
import com.rdpp.companymaster.entity.VendorUser;
import com.rdpp.companymaster.entity.VendorUserAudit;
import com.rdpp.companymaster.repository.VendorRepository;
import com.rdpp.companymaster.repository.VendorUserRepository;
import com.rdpp.companymaster.repository.VendorUserAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VendorUserService {

    @Autowired
    private VendorUserRepository vendorUserRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorUserAuditRepository vendorUserAuditRepository;

    public VendorUser createVendorUser(VendorUser vendorUser, String vendorCode) {
        Vendor vendor = vendorRepository.findByVendorCode(vendorCode)
                .orElseThrow(() -> new RuntimeException("Vendor not found with code: " + vendorCode));

        // Check user limits based on role
        VendorUser.VendorUserRole role = vendorUser.getVendorUserRole();
        long currentUserCount = vendorUserRepository.countByVendorAndVendorUserRole(vendor, role);

        if (role == VendorUser.VendorUserRole.A) {
            if (vendor.getMaxAdminUsers() != null && currentUserCount >= vendor.getMaxAdminUsers()) {
                throw new RuntimeException("Maximum admin users reached");
            }
        } else if (role == VendorUser.VendorUserRole.U) {
            if (vendor.getMaxNormalUsers() != null && currentUserCount >= vendor.getMaxNormalUsers()) {
                throw new RuntimeException("Maximum normal users reached");
            }
        }

        vendorUser.setVendor(vendor);
        return vendorUserRepository.save(vendorUser);
    }

    public List<VendorUser> getAllVendorUsers() {
        return vendorUserRepository.findByVendorUserStatus("A");
    }

    public Optional<VendorUser> getVendorUserById(Long vendorUserId) {
        return vendorUserRepository.findById(vendorUserId);
    }

    public VendorUser updateVendorUser(Long vendorUserId, VendorUser vendorUserDetails) {
        VendorUser vendorUser = vendorUserRepository.findById(vendorUserId)
                .orElseThrow(() -> new RuntimeException("Vendor User not found with id: " + vendorUserId));

        // Save old state to audit table
        VendorUserAudit audit = new VendorUserAudit(vendorUser, "update");
        vendorUserAuditRepository.save(audit);

        vendorUser.setVendorUserName(vendorUserDetails.getVendorUserName());
        vendorUser.setVendorUserEmail(vendorUserDetails.getVendorUserEmail());
        vendorUser.setVendorUserRole(vendorUserDetails.getVendorUserRole());
        vendorUser.setVendorUserCountry(vendorUserDetails.getVendorUserCountry());
        vendorUser.setVendorUserStatus(vendorUserDetails.getVendorUserStatus());
        vendorUser.setVendorUserContact(vendorUserDetails.getVendorUserContact());
        vendorUser.setApprovedBy(vendorUserDetails.getApprovedBy());

        return vendorUserRepository.save(vendorUser);
    }

    public void deleteVendorUser(Long vendorUserId) {
        VendorUser vendorUser = vendorUserRepository.findById(vendorUserId)
                .orElseThrow(() -> new RuntimeException("Vendor User not found with id: " + vendorUserId));

        // Save old state to audit table
        VendorUserAudit audit = new VendorUserAudit(vendorUser, "delete");
        vendorUserAuditRepository.save(audit);

        vendorUserRepository.delete(vendorUser);
    }
}
