package com.rdpp.companymaster.repository;

import com.rdpp.companymaster.entity.Vendor;
import com.rdpp.companymaster.entity.VendorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorUserRepository extends JpaRepository<VendorUser, Long> {
    long countByVendorAndVendorUserRole(Vendor vendor, VendorUser.VendorUserRole role);
    List<VendorUser> findByVendorUserStatus(String status);
}