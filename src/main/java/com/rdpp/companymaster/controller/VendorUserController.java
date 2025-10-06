package com.rdpp.companymaster.controller;

import com.rdpp.companymaster.dto.ErrorResponse;
import com.rdpp.companymaster.dto.VendorUserRequest;
import com.rdpp.companymaster.dto.VendorUserResponse;
import com.rdpp.companymaster.entity.VendorUser;
import com.rdpp.companymaster.service.VendorUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vendor-master/vendor-users")
public class VendorUserController {

    @Autowired
    private VendorUserService vendorUserService;

    @PutMapping
    public ResponseEntity<?> createVendorUser(@Valid @RequestBody VendorUserRequest vendorUserRequest) {
        try {
            VendorUser vendorUser = convertToEntity(vendorUserRequest);
            VendorUser createdVendorUser = vendorUserService.createVendorUser(vendorUser, vendorUserRequest.getVendorCode());
            return new ResponseEntity<>(new VendorUserResponse(createdVendorUser), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("Maximum")) {
                ErrorResponse errorResponse = new ErrorResponse(105, "users are reached maximum");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
            ErrorResponse errorResponse = new ErrorResponse(103, "unable to create");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<?> updateVendorUser(@Valid @RequestBody VendorUserRequest vendorUserRequest) {
        try {
            if (vendorUserRequest.getVendorUserId() == null) {
                throw new RuntimeException("Vendor User ID is required for update operation");
            }

            VendorUser vendorUserDetails = convertToEntity(vendorUserRequest);
            VendorUser updatedVendorUser = vendorUserService.updateVendorUser(vendorUserRequest.getVendorUserId(), vendorUserDetails);
            return ResponseEntity.ok(new VendorUserResponse(updatedVendorUser));
        } catch (RuntimeException e) {
            ErrorResponse errorResponse = new ErrorResponse(104, "unable to update");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllVendorUsers() {
        try {
            List<VendorUser> vendorUsers = vendorUserService.getAllVendorUsers();
            List<VendorUserResponse> response = vendorUsers.stream()
                    .map(VendorUserResponse::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping(params = "vendorUserId")
    public ResponseEntity<?> getVendorUserById(@RequestParam Long vendorUserId) {
        try {
            return vendorUserService.getVendorUserById(vendorUserId)
                    .map(vendorUser -> ResponseEntity.ok(new VendorUserResponse(vendorUser)))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @DeleteMapping(params = "vendorUserId")
    public ResponseEntity<?> deleteVendorUser(@RequestParam Long vendorUserId) {
        try {
            vendorUserService.deleteVendorUser(vendorUserId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(106, "unable to process");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    private VendorUser convertToEntity(VendorUserRequest vendorUserRequest) {
        VendorUser vendorUser = new VendorUser();
        vendorUser.setVendorUserName(vendorUserRequest.getVendorUserName());
        vendorUser.setVendorUserEmail(vendorUserRequest.getVendorUserEmail());
        vendorUser.setVendorUserRole(VendorUser.VendorUserRole.valueOf(vendorUserRequest.getVendorUserRole()));
        vendorUser.setVendorUserCountry(vendorUserRequest.getVendorUserCountry());
        vendorUser.setVendorUserStatus(vendorUserRequest.getVendorUserStatus());
        vendorUser.setVendorUserContact(vendorUserRequest.getVendorUserContact());
        vendorUser.setCreatedBy(vendorUserRequest.getCreatedBy());
        vendorUser.setApprovedBy(vendorUserRequest.getApprovedBy());
        return vendorUser;
    }
}
