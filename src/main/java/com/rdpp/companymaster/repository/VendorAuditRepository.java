package com.rdpp.companymaster.repository;

import com.rdpp.companymaster.entity.VendorAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAuditRepository extends JpaRepository<VendorAudit, Long> {
}