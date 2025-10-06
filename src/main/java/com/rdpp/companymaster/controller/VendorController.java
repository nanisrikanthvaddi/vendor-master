package com.rdpp.companymaster.controller;

import com.rdpp.companymaster.dto.ErrorResponse;
import com.rdpp.companymaster.dto.VendorRequest;
import com.rdpp.companymaster.dto.VendorResponse;
import com.rdpp.companymaster.entity.Vendor;
import com.rdpp.companymaster.service.VendorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vendor-master/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PutMapping
    public ResponseEntity<?> createVendor(@Valid @RequestBody VendorRequest vendorRequest) {
        try {
            Vendor vendor = convertToEntity(vendorRequest);
            Vendor createdVendor = vendorService.createVendor(vendor);
            return new ResponseEntity<>(new VendorResponse(createdVendor), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            ErrorResponse errorResponse = new ErrorResponse(102, "unable to create");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<?> updateVendor(@Valid @RequestBody VendorRequest vendorRequest) {
        try {
            if (vendorRequest.getVendorCode() == null || vendorRequest.getVendorCode().isEmpty()) {
                throw new RuntimeException("Vendor Code is required for update operation");
            }

            Vendor vendorDetails = convertToEntity(vendorRequest);
            Vendor updatedVendor = vendorService.updateVendorByCode(vendorRequest.getVendorCode(), vendorDetails);
            return ResponseEntity.ok(new VendorResponse(updatedVendor));
        } catch (RuntimeException e) {
            ErrorResponse errorResponse = new ErrorResponse(101, "unable to update");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllVendors() {
        try {
            List<Vendor> vendors = vendorService.getAllVendors();
            List<VendorResponse> response = vendors.stream()
                    .map(VendorResponse::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping(params = "vendorCode")
    public ResponseEntity<?> getVendorByCodeQueryParam(@RequestParam String vendorCode) {
        try {
            return vendorService.getVendorByCode(vendorCode)
                    .map(vendor -> ResponseEntity.ok(new VendorResponse(vendor)))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @DeleteMapping(params = "vendorCode")
    public ResponseEntity<?> deleteVendor(@RequestParam String vendorCode) {
        try {
            vendorService.deleteVendorByCode(vendorCode);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    private Vendor convertToEntity(VendorRequest vendorRequest) {
        Vendor vendor = new Vendor();
        vendor.setVendorCode(vendorRequest.getVendorCode());
        vendor.setVendorType(vendorRequest.getVendorType());
        vendor.setVendorName(vendorRequest.getVendorName());
        vendor.setVendorDomain(vendorRequest.getVendorDomain());
        vendor.setEmail(vendorRequest.getEmail());
        vendor.setContact(vendorRequest.getContact());
        vendor.setCountry(vendorRequest.getCountry());
        vendor.setProduct(vendorRequest.getProduct());
        vendor.setMaxNormalUsers(vendorRequest.getMaxNormalUsers());
        vendor.setMaxAdminUsers(vendorRequest.getMaxAdminUsers());
        vendor.setStatus(vendorRequest.getStatus());
        vendor.setCreatedBy(vendorRequest.getCreatedBy());
        vendor.setApprovedBy(vendorRequest.getApprovedBy());
        return vendor;
    }
}
