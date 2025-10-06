# Vendor Management API Reference - Table Format

## Vendor API Endpoints

| Method | Endpoint | Description | Request Body Required | Success Status | Error Codes |
|--------|----------|-------------|----------------------|----------------|-------------|
| PUT | `/api/vendor-master/vendors` | Create Vendor | Yes | 201 Created | 102, 106 |
| POST | `/api/vendor-master/vendors` | Update Vendor | Yes (with vendorCode) | 200 OK | 101, 106 |
| GET | `/api/vendor-master/vendors` | Get All Vendors | No | 200 OK | 106 |
| GET | `/api/vendor-master/vendors?vendorCode={code}` | Get Vendor by Code | No | 200 OK | 106 |
| DELETE | `/api/vendor-master/vendors?vendorCode={code}` | Delete Vendor | No | 204 No Content | 106 |

---

## VendorUser API Endpoints

| Method | Endpoint | Description | Request Body Required | Success Status | Error Codes |
|--------|----------|-------------|----------------------|----------------|-------------|
| PUT | `/api/vendor-master/vendor-users` | Create Vendor User | Yes (with vendorId) | 201 Created | 103, 105, 106 |
| POST | `/api/vendor-master/vendor-users` | Update Vendor User | Yes (with vendorUserId) | 200 OK | 104, 106 |
| GET | `/api/vendor-master/vendor-users` | Get All Vendor Users | No | 200 OK | 106 |
| GET | `/api/vendor-master/vendor-users?vendorUserId={id}` | Get Vendor User by ID | No | 200 OK | 106 |
| DELETE | `/api/vendor-master/vendor-users?vendorUserId={id}` | Delete Vendor User | No | 204 No Content | 106 |

---

## Request Body Fields

### Vendor Request Fields

| Field Name | Type | Max Length | Required | Default | Validation | Description |
|------------|------|------------|----------|---------|------------|-------------|
| vendorCode | String | 50 | Yes | - | @NotBlank | Unique vendor code (required for all operations, used as identifier for update/delete) |
| vendorType | String | 50 | No | - | - | Type of vendor |
| vendorName | String | 100 | Yes | - | @NotBlank | Vendor name |
| vendorDomain | String | 100 | No | - | - | Vendor domain |
| email | String | 1000 | No | - | @Email | Vendor email |
| contact | String | 100 | No | - | - | Contact number |
| country | String | 5 | No | - | - | Country code |
| product | String | 100 | No | - | - | Product details |
| maxNormalUsers | Integer | - | No | - | - | Maximum normal users allowed |
| maxAdminUsers | Integer | - | No | - | - | Maximum admin users allowed |
| status | String | 20 | No | "A" | - | Status: A (Active) or I (Inactive) |
| createdBy | String | 50 | No | - | - | Created by user |
| approvedBy | String | 50 | No | - | - | Approved by user |

### VendorUser Request Fields

| Field Name | Type | Max Length | Required | Default | Validation | Description |
|------------|------|------------|----------|---------|------------|-------------|
| vendorUserId | Long | - | No (Yes for update) | - | - | Vendor User ID (required for update only) |
| vendorUserName | String | 50 | Yes | - | @NotBlank | User name |
| vendorUserEmail | String | 100 | No | - | - | User email |
| vendorUserRole | String | 1 | Yes | - | @NotNull | User role: A (Admin) or U (User) |
| vendorUserCountry | String | 5 | No | - | - | User country |
| vendorUserStatus | String | 20 | No | "A" | - | User status: A (Active) or I (Inactive) |
| vendorUserContact | String | 20 | No | - | - | User contact |
| vendorCode | String | 50 | Yes | - | @NotNull | Parent vendor code |
| createdBy | String | 100 | No | - | - | Created by user |
| approvedBy | String | 100 | No | - | - | Approved by user |

---

## Response Body Fields

### Vendor Response Fields

| Field Name | Type | Description |
|------------|------|-------------|
| vendorId | Long | Vendor ID |
| vendorCode | String | Unique vendor code |
| vendorType | String | Type of vendor |
| vendorName | String | Vendor name |
| vendorDomain | String | Vendor domain |
| email | String | Vendor email |
| contact | String | Contact number |
| country | String | Country code |
| product | String | Product details |
| maxNormalUsers | Integer | Maximum normal users allowed |
| maxAdminUsers | Integer | Maximum admin users allowed |
| status | String | Status: A (Active) or I (Inactive) |
| createdBy | String | Created by user |
| approvedBy | String | Approved by user |
| createdTime | LocalDateTime | Creation timestamp |
| updatedTime | LocalDateTime | Last update timestamp |

### VendorUser Response Fields

| Field Name | Type | Description |
|------------|------|-------------|
| vendorUserId | Long | Vendor User ID |
| vendorUserName | String | User name |
| vendorUserEmail | String | User email |
| vendorUserRole | String | User role: A (Admin) or U (User) |
| vendorUserCountry | String | User country |
| vendorUserStatus | String | User status: A (Active) or I (Inactive) |
| vendorUserContact | String | User contact |
| vendorCode | String | Parent vendor code |
| createdBy | String | Created by user |
| approvedBy | String | Approved by user |
| createdTime | LocalDateTime | Creation timestamp |
| updatedTime | LocalDateTime | Last update timestamp |

---

## Error Codes Reference

| Error Code | Error Description | HTTP Status | Applies To | When It Occurs |
|------------|-------------------|-------------|------------|----------------|
| 101 | unable to update | 400 Bad Request | Vendor | Update vendor fails (vendor not found or validation error) |
| 102 | unable to create | 400 Bad Request | Vendor | Create vendor fails (validation error or runtime exception) |
| 103 | unable to create | 400 Bad Request | VendorUser | Create vendor user fails (vendor not found or validation error) |
| 104 | unable to update | 400 Bad Request | VendorUser | Update vendor user fails (user not found or validation error) |
| 105 | users are reached maximum | 400 Bad Request | VendorUser | Maximum user limit reached for vendor (admin or normal users) |
| 106 | unable to process | 500 Internal Server Error | Both | Unexpected error during processing (any endpoint) |

---

## Sample Requests

### Create Vendor Request
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

### Update Vendor Request
```json
{
  "vendorCode": "V001",
  "vendorName": "Tech Solutions Inc - Updated",
  "status": "I"
}
```

### Create VendorUser Request
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

### Update VendorUser Request
```json
{
  "vendorUserId": 1,
  "vendorUserName": "John Doe Updated",
  "vendorUserStatus": "I"
}
```

---

## Sample Responses

### Success Response - Create/Update Vendor (200/201)
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

### Success Response - Get All Vendors (200)
```json
[
  {
    "vendorId": 1,
    "vendorCode": "V001",
    "vendorName": "Tech Solutions Inc",
    "status": "A"
  }
]
```

### Error Response - Unable to Create (400)
```json
{
  "errorCode": 102,
  "errorDescription": "unable to create"
}
```

### Error Response - Max Users Reached (400)
```json
{
  "errorCode": 105,
  "errorDescription": "users are reached maximum"
}
```

### Error Response - Unable to Process (500)
```json
{
  "errorCode": 106,
  "errorDescription": "unable to process"
}
```

---

## HTTP Status Codes

| Status Code | Description | When Used |
|-------------|-------------|-----------|
| 200 OK | Request successful | GET (found), POST (update success) |
| 201 Created | Resource created | PUT (create success) |
| 204 No Content | Deletion successful | DELETE (success) |
| 400 Bad Request | Validation/business logic error | Create/update failures (101-105) |
| 404 Not Found | Resource not found | GET/DELETE (resource doesn't exist) |
| 500 Internal Server Error | Unexpected server error | Any unexpected exception (106) |

---

## Business Rules

| Rule | Description |
|------|-------------|
| Default Status | Both Vendor and VendorUser default to status "A" (Active) if not provided |
| User Limit Validation | When creating VendorUser, system validates against vendor's maxNormalUsers (role=U) or maxAdminUsers (role=A) |
| Status Values | Status must be "A" (Active) or "I" (Inactive) |
| Role Values | VendorUser role must be "A" (Admin) or "U" (User) |
| Vendor Relationship | VendorUser must reference a valid vendorCode |
| Lazy Loading | VendorUser relationship is lazy-loaded and not included in Vendor responses |
| Audit Trail | Both entities track createdTime and updatedTime automatically |
| Vendor Identifier | **All Vendor operations (GET by code, update, delete) use vendorCode (not vendorId) as the unique identifier** |
| VendorCode Uniqueness | VendorCode must be unique across all vendors and is required for all Vendor operations |
| VendorUser Parent Reference | **VendorUser uses vendorCode (not vendorId) to reference parent vendor** |
| VendorId Usage | VendorId is auto-generated and only used internally; all external API operations use vendorCode |
