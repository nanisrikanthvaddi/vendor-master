# Vendor Master API - Architecture Diagrams

This folder contains PlantUML diagrams documenting the Vendor Master API architecture and data flows.

## Diagrams Overview

### 1. Architecture Diagram (`architecture-diagram.puml`)
**Purpose:** Shows the complete system architecture from Service Bench to Database

**Key Components:**
- Service Bench (UI Layer)
- Experience API (Orchestration Layer)
- Wrapper Process API (Process Layer)
- Vendor Master API (Controllers, Services, Repositories, Entities)
- Oracle Database (Tables and Audit Tables)

**Use this to understand:** Overall system architecture and component relationships

---

### 2. Sequence Diagram (`sequence-diagram.puml`)
**Purpose:** Shows the detailed request-response flow for CRUD operations

**Scenarios Covered:**
- Create Vendor
- Update Vendor (with audit logging)
- Delete Vendor (with audit logging)
- Get Vendor by Code

**Use this to understand:** Step-by-step execution flow and audit mechanism

---

### 3. API Endpoints Diagram (`api-endpoints-diagram.puml`)
**Purpose:** Comprehensive overview of all available API endpoints

**Includes:**
- Vendor Endpoints (`/api/vendor-master/vendors`)
- Vendor User Endpoints (`/api/vendor-master/vendor-users`)
- HTTP Methods (PUT, POST, GET, DELETE)
- Error Codes (101-107)
- User Roles (A: Admin, U: Normal User)

**Use this to understand:** Available APIs and their purposes

---

### 4. Data Flow Diagram (`data-flow-diagram.puml`)
**Purpose:** Shows complete data flow with audit trail and business logic

**Highlights:**
- Request flow through all layers
- Audit logging mechanism (on update/delete)
- User limit validation logic
- Database interaction patterns

**Use this to understand:** Data flow and business rules implementation

---

## How to View PlantUML Diagrams

### Option 1: Online PlantUML Editor
1. Go to [PlantUML Web Server](http://www.plantuml.com/plantuml/uml/)
2. Copy the content of any `.puml` file
3. Paste and view the rendered diagram

### Option 2: VS Code Extension
1. Install "PlantUML" extension in VS Code
2. Open any `.puml` file
3. Press `Alt+D` to preview the diagram

### Option 3: IntelliJ IDEA Plugin
1. Install "PlantUML integration" plugin
2. Open any `.puml` file
3. Right-click and select "Show PlantUML Diagram"

### Option 4: Command Line (requires PlantUML)
```bash
# Install PlantUML (macOS)
brew install plantuml

# Generate PNG images
plantuml architecture-diagram.puml
plantuml sequence-diagram.puml
plantuml api-endpoints-diagram.puml
plantuml data-flow-diagram.puml
```

---

## Audit Trail Implementation

The audit trail is implemented in Java code (not database triggers):

**On Update/Delete Operations:**
1. Service layer fetches the existing entity
2. Creates an audit record with old values
3. Sets `event_type` = `"update"` or `"delete"`
4. Saves audit record to respective audit table
5. Performs the actual update/delete operation

**Audit Tables:**
- `VENDOR_AUDIT` - Stores vendor history
- `VENDOR_USER_AUDIT` - Stores vendor user history

---

## API Flow Summary

```
Service Bench → Experience API → Wrapper Process API → Vendor Master API
                                                        ↓
                                                   Controller Layer
                                                        ↓
                                                   Service Layer
                                                   (Business Logic + Audit)
                                                        ↓
                                                   Repository Layer
                                                        ↓
                                                   Oracle Database
                                                   (Main + Audit Tables)
```

---

## Error Codes Reference

| Code | Description |
|------|-------------|
| 101  | Unable to update |
| 102  | Unable to create |
| 103  | Unable to create (vendor user) |
| 104  | Unable to update (vendor user) |
| 105  | Maximum users reached |
| 106  | Unable to process |
| 107  | Unable to delete (vendor user) |

---

## Contact
For questions or updates to these diagrams, please contact the development team.
