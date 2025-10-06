# Vendor Management API Documentation

## Vendor API Endpoints

### 1. Create Vendor
**Endpoint:** `PUT /api/vendor-master/vendors`

**Request:**
```json
{
  "vendorCode": "V001",
  "vendorType": "Technology",
  "vendorName": "Tech Solutions Inc",
  "vendorDomain": "techsolutions.com",
  "email": "contact@techsolutions.com",
  "contact": "1234567890",
  "country": "US",
  "product": "Software",
  "maxNormalUsers": 10,
  "maxAdminUsers": 2,
  "status": "A",
  "createdBy": "admin",
  "approvedBy": "manager"
}
```

**Success Response (201 Created):**
```json
{
  "vendorId": 1,
  "vendorCode": "V001",
  "vendorType": "Technology",
  "vendorName": "Tech Solutions Inc",
  "vendorDomain": "techsolutions.com",
  "email": "contact@techsolutions.com",
  "contact": "1234567890",
  "country": "US",
  "product": "Software",
  "maxNormalUsers": 10,
  "maxAdminUsers": 2,
  "status": "A",
  "createdBy": "admin",
  "approvedBy": "manager",
  "createdTime": "2025-10-05T10:30:00",
  "updatedTime": null
}
```

**Error Response (400 Bad Request):**
```json
{
  "errorCode": 102,
  "errorDescription": "unable to create"
}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 2. Update Vendor
**Endpoint:** `POST /api/vendor-master/vendors`

**Request:**
```json
{
  "vendorCode": "V001",
  "vendorType": "Technology",
  "vendorName": "Tech Solutions Inc - Updated",
  "vendorDomain": "techsolutions.com",
  "email": "info@techsolutions.com",
  "contact": "9876543210",
  "country": "US",
  "product": "Software & Hardware",
  "maxNormalUsers": 15,
  "maxAdminUsers": 3,
  "status": "A",
  "createdBy": "admin",
  "approvedBy": "manager"
}
```

**Success Response (200 OK):**
```json
{
  "vendorId": 1,
  "vendorCode": "V001",
  "vendorType": "Technology",
  "vendorName": "Tech Solutions Inc - Updated",
  "vendorDomain": "techsolutions.com",
  "email": "info@techsolutions.com",
  "contact": "9876543210",
  "country": "US",
  "product": "Software & Hardware",
  "maxNormalUsers": 15,
  "maxAdminUsers": 3,
  "status": "A",
  "createdBy": "admin",
  "approvedBy": "manager",
  "createdTime": "2025-10-05T10:30:00",
  "updatedTime": "2025-10-05T11:00:00"
}
```

**Error Response (400 Bad Request):**
```json
{
  "errorCode": 101,
  "errorDescription": "unable to update"
}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 3. Get All Vendors
**Endpoint:** `GET /api/vendor-master/vendors`

**Success Response (200 OK):**
```json
[
  {
    "vendorId": 1,
    "vendorCode": "V001",
    "vendorType": "Technology",
    "vendorName": "Tech Solutions Inc",
    "vendorDomain": "techsolutions.com",
    "email": "contact@techsolutions.com",
    "contact": "1234567890",
    "country": "US",
    "product": "Software",
    "maxNormalUsers": 10,
    "maxAdminUsers": 2,
    "status": "A",
    "createdBy": "admin",
    "approvedBy": "manager",
    "createdTime": "2025-10-05T10:30:00",
    "updatedTime": null
  }
]
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 4. Get Vendor by Code
**Endpoint:** `GET /api/vendor-master/vendors?vendorCode={code}`

**Example:** `GET /api/vendor-master/vendors?vendorCode=V001`

**Success Response (200 OK):**
```json
{
  "vendorId": 1,
  "vendorCode": "V001",
  "vendorType": "Technology",
  "vendorName": "Tech Solutions Inc",
  "vendorDomain": "techsolutions.com",
  "email": "contact@techsolutions.com",
  "contact": "1234567890",
  "country": "US",
  "product": "Software",
  "maxNormalUsers": 10,
  "maxAdminUsers": 2,
  "status": "A",
  "createdBy": "admin",
  "approvedBy": "manager",
  "createdTime": "2025-10-05T10:30:00",
  "updatedTime": null
}
```

**Error Response (404 Not Found):**
```json
{}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 5. Delete Vendor
**Endpoint:** `DELETE /api/vendor-master/vendors?vendorCode={code}`

**Example:** `DELETE /api/vendor-master/vendors?vendorCode=V001`

**Success Response (204 No Content):**
```
(Empty response body)
```

**Error Response (404 Not Found):**
```json
{}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

## VendorUser API Endpoints

### 1. Create Vendor User
**Endpoint:** `PUT /api/vendor-master/vendor-users`

**Request:**
```json
{
  "vendorUserName": "John Doe",
  "vendorUserEmail": "john.doe@techsolutions.com",
  "vendorUserRole": "A",
  "vendorUserCountry": "US",
  "vendorUserStatus": "A",
  "vendorUserContact": "1234567890",
  "vendorCode": "V001",
  "createdBy": "admin",
  "approvedBy": "manager"
}
```

**Success Response (201 Created):**
```json
{
  "vendorUserId": 1,
  "vendorUserName": "John Doe",
  "vendorUserEmail": "john.doe@techsolutions.com",
  "vendorUserRole": "A",
  "vendorUserCountry": "US",
  "vendorUserStatus": "A",
  "vendorUserContact": "1234567890",
  "vendorCode": "V001",
  "createdBy": "admin",
  "approvedBy": "manager",
  "createdTime": "2025-10-05T10:30:00",
  "updatedTime": null
}
```

**Error Response (400 Bad Request - Create Failed):**
```json
{
  "errorCode": 103,
  "errorDescription": "unable to create"
}
```

**Error Response (400 Bad Request - Max Users Reached):**
```json
{
  "errorCode": 105,
  "errorDescription": "users are reached maximum"
}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 2. Update Vendor User
**Endpoint:** `POST /api/vendor-master/vendor-users`

**Request:**
```json
{
  "vendorUserId": 1,
  "vendorUserName": "John Doe Updated",
  "vendorUserEmail": "john.updated@techsolutions.com",
  "vendorUserRole": "A",
  "vendorUserCountry": "US",
  "vendorUserStatus": "I",
  "vendorUserContact": "9876543210",
  "vendorCode": "V001",
  "createdBy": "admin",
  "approvedBy": "manager"
}
```

**Success Response (200 OK):**
```json
{
  "vendorUserId": 1,
  "vendorUserName": "John Doe Updated",
  "vendorUserEmail": "john.updated@techsolutions.com",
  "vendorUserRole": "A",
  "vendorUserCountry": "US",
  "vendorUserStatus": "I",
  "vendorUserContact": "9876543210",
  "vendorCode": "V001",
  "createdBy": "admin",
  "approvedBy": "manager",
  "createdTime": "2025-10-05T10:30:00",
  "updatedTime": "2025-10-05T11:00:00"
}
```

**Error Response (400 Bad Request):**
```json
{
  "errorCode": 104,
  "errorDescription": "unable to update"
}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 3. Get All Vendor Users
**Endpoint:** `GET /api/vendor-master/vendor-users`

**Success Response (200 OK):**
```json
[
  {
    "vendorUserId": 1,
    "vendorUserName": "John Doe",
    "vendorUserEmail": "john.doe@techsolutions.com",
    "vendorUserRole": "A",
    "vendorUserCountry": "US",
    "vendorUserStatus": "A",
    "vendorUserContact": "1234567890",
    "vendorCode": "V001",
    "createdBy": "admin",
    "approvedBy": "manager",
    "createdTime": "2025-10-05T10:30:00",
    "updatedTime": null
  }
]
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 4. Get Vendor User by ID
**Endpoint:** `GET /api/vendor-master/vendor-users?vendorUserId={id}`

**Example:** `GET /api/vendor-master/vendor-users?vendorUserId=1`

**Success Response (200 OK):**
```json
{
  "vendorUserId": 1,
  "vendorUserName": "John Doe",
  "vendorUserEmail": "john.doe@techsolutions.com",
  "vendorUserRole": "A",
  "vendorUserCountry": "US",
  "vendorUserStatus": "A",
  "vendorUserContact": "1234567890",
  "vendorCode": "V001",
  "createdBy": "admin",
  "approvedBy": "manager",
  "createdTime": "2025-10-05T10:30:00",
  "updatedTime": null
}
```

**Error Response (404 Not Found):**
```json
{}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

### 5. Delete Vendor User
**Endpoint:** `DELETE /api/vendor-master/vendor-users?vendorUserId={id}`

**Example:** `DELETE /api/vendor-master/vendor-users?vendorUserId=1`

**Success Response (204 No Content):**
```
(Empty response body)
```

**Error Response (404 Not Found):**
```json
{}
```

**Error Response (500 Internal Server Error):**
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

## Error Codes Summary

| Error Code | Description | HTTP Status |
|------------|-------------|-------------|
| 101 | unable to update (Vendor) | 400 Bad Request |
| 102 | unable to create (Vendor) | 400 Bad Request |
| 103 | unable to create (VendorUser) | 400 Bad Request |
| 104 | unable to update (VendorUser) | 400 Bad Request |
| 105 | users are reached maximum | 400 Bad Request |
| 106 | unable to process | 500 Internal Server Error |

---

## Field Descriptions

### Vendor Fields
- **vendorCode**: Unique vendor code (max 50 chars, required) - Used for update and delete operations
- **vendorType**: Type of vendor (max 50 chars)
- **vendorName**: Vendor name (max 100 chars, required)
- **vendorDomain**: Vendor domain (max 100 chars)
- **email**: Vendor email (max 1000 chars)
- **contact**: Contact number (max 100 chars)
- **country**: Country code (max 5 chars)
- **product**: Product details (max 100 chars)
- **maxNormalUsers**: Maximum normal users allowed
- **maxAdminUsers**: Maximum admin users allowed
- **status**: Status - "A" (Active) or "I" (Inactive), defaults to "A"
- **createdBy**: Created by user (max 50 chars)
- **approvedBy**: Approved by user (max 50 chars)

### VendorUser Fields
- **vendorUserName**: User name (max 50 chars, required)
- **vendorUserEmail**: User email (max 100 chars)
- **vendorUserRole**: User role - "A" (Admin) or "U" (User), required
- **vendorUserCountry**: User country (max 5 chars)
- **vendorUserStatus**: User status - "A" (Active) or "I" (Inactive), defaults to "A"
- **vendorUserContact**: User contact (max 20 chars)
- **vendorCode**: Parent vendor code (max 50 chars, required)
- **createdBy**: Created by user (max 100 chars)
- **approvedBy**: Approved by user (max 100 chars)

---

## Notes
1. Default status is "A" (Active) for both Vendor and VendorUser if not provided
2. When creating VendorUser, the system validates against maxNormalUsers and maxAdminUsers limits
3. All timestamps are in ISO 8601 format
4. VendorUser relationship with Vendor is lazy-loaded and not included in Vendor responses
5. **All Vendor operations (GET by code, update, delete) use vendorCode (not vendorId) as the identifier**
6. VendorCode must be unique and is required for all Vendor operations
7. **VendorUser uses vendorCode (not vendorId) to reference the parent vendor**
8. VendorId is auto-generated and only used internally; all external API operations use vendorCode
