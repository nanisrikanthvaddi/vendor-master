package com.rdpp.companymaster.repository;

import com.rdpp.companymaster.entity.VendorUserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorUserAuditRepository extends JpaRepository<VendorUserAudit, Long> {
}