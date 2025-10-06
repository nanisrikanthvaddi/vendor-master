
-- Sequences for unique ID generation
CREATE SEQUENCE VENDOR_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE VENDOR_USER_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

create table VENDOR
(
    VENDOR_ID        NUMBER not null
        primary key,
    VENDOR_CODE      VARCHAR2(50),
    VENDOR_TYPE      VARCHAR2(50),
    VENDOR_NAME      VARCHAR2(100),
    VENDOR_DOMAIN    VARCHAR2(100),
    EMAIL            VARCHAR2(1000),
    CONTACT          VARCHAR2(100),
    COUNTRY          VARCHAR2(5),
    PRODUCT          VARCHAR2(100),
    MAX_NORMAL_USERS NUMBER,
    MAX_ADMIN_USERS  NUMBER,
    STATUS           VARCHAR2(20),
    CREATED_BY       VARCHAR2(50),
    APPROVED_BY      VARCHAR2(50),
    CREATED_TIME     TIMESTAMP(6) default CURRENT_TIMESTAMP,
    UPDATED_TIME     TIMESTAMP(6)
)
    /


create table VENDOR_USER
(
    VENDOR_USER_ID      NUMBER not null primary key,
    VENDOR_USER_NAME    VARCHAR2(50) not null,
    VENDOR_USER_EMAIL   VARCHAR2(100),
    VENDOR_USER_ROLE    VARCHAR2(1),
    CONSTRAINT chk_vendor_user_role CHECK (VENDOR_USER_ROLE IN ('A', 'U')),
    VENDOR_USER_COUNTRY VARCHAR2(5),
    VENDOR_USER_STATUS  VARCHAR2(20),
    VENDOR_USER_CONTACT VARCHAR2(20),
    VENDOR_ID           NUMBER references VENDOR,
    CREATED_BY          VARCHAR2(100),
    APPROVED_BY         VARCHAR2(100),
    CREATED_TIME        TIMESTAMP(6) default CURRENT_TIMESTAMP,
    UPDATED_TIME        TIMESTAMP(6)
)

drop table VENDOR_USER_AUDIT;

drop table VENDOR_AUDIT;


CREATE TABLE VENDOR_USER_AUDIT
(
    VENDOR_USER_ID      NUMBER ,
    VENDOR_USER_NAME    VARCHAR2(50) ,
    VENDOR_USER_EMAIL   VARCHAR2(100),
    VENDOR_USER_ROLE    VARCHAR2(1),
    VENDOR_USER_COUNTRY VARCHAR2(50),
    VENDOR_USER_STATUS  VARCHAR2(20),
    VENDOR_USER_CONTACT VARCHAR2(20),
    VENDOR_ID           NUMBER,
    CREATED_BY          VARCHAR2(100),
    APPROVED_BY         VARCHAR2(100),
    CREATED_TIME        TIMESTAMP(6),
    UPDATED_TIME        TIMESTAMP(6),
    EVENT_TYPE          VARCHAR2(20) NOT NULL
);


CREATE TABLE VENDOR_AUDIT
(
    VENDOR_ID        NUMBER NOT NULL,
    VENDOR_CODE      VARCHAR2(50),
    VENDOR_TYPE      VARCHAR2(50),
    VENDOR_NAME      VARCHAR2(100),
    VENDOR_DOMAIN    VARCHAR2(100),
    EMAIL            VARCHAR2(1000),
    CONTACT          VARCHAR2(100),
    COUNTRY          VARCHAR2(5),
    PRODUCT          VARCHAR2(100),
    MAX_NORMAL_USERS NUMBER,
    MAX_ADMIN_USERS  NUMBER,
    STATUS           VARCHAR2(20),
    CREATED_BY       VARCHAR2(50),
    APPROVED_BY      VARCHAR2(50),
    CREATED_TIME     TIMESTAMP(6),
    UPDATED_TIME     TIMESTAMP(6),
    EVENT_TYPE       VARCHAR2(20) NOT NULL
);
/


CREATE OR REPLACE TRIGGER VENDOR_AUDIT_TRG
    AFTER UPDATE OR DELETE ON VENDOR
    FOR EACH ROW
BEGIN
    IF UPDATING THEN
        INSERT INTO VENDOR_AUDIT (
            VENDOR_ID,
            VENDOR_CODE,
            VENDOR_TYPE,
            VENDOR_NAME,
            VENDOR_DOMAIN,
            EMAIL,
            CONTACT,
            COUNTRY,
            PRODUCT,
            MAX_NORMAL_USERS,
            MAX_ADMIN_USERS,
            STATUS,
            CREATED_BY,
            APPROVED_BY,
            CREATED_TIME,
            UPDATED_TIME,
            EVENT_TYPE
        ) VALUES (
                     :OLD.VENDOR_ID,
                     :OLD.VENDOR_CODE,
                     :OLD.VENDOR_TYPE,
                     :OLD.VENDOR_NAME,
                     :OLD.VENDOR_DOMAIN,
                     :OLD.EMAIL,
                     :OLD.CONTACT,
                     :OLD.COUNTRY,
                     :OLD.PRODUCT,
                     :OLD.MAX_NORMAL_USERS,
                     :OLD.MAX_ADMIN_USERS,
                     :OLD.STATUS,
                     :OLD.CREATED_BY,
                     :OLD.APPROVED_BY,
                     :OLD.CREATED_TIME,
                     :OLD.UPDATED_TIME,
                     'update'
                 );
END IF;
    IF DELETING THEN
        INSERT INTO VENDOR_AUDIT (
            VENDOR_ID,
            VENDOR_CODE,
            VENDOR_TYPE,
            VENDOR_NAME,
            VENDOR_DOMAIN,
            EMAIL,
            CONTACT,
            COUNTRY,
            PRODUCT,
            MAX_NORMAL_USERS,
            MAX_ADMIN_USERS,
            STATUS,
            CREATED_BY,
            APPROVED_BY,
            CREATED_TIME,
            UPDATED_TIME,
            EVENT_TYPE
        ) VALUES (
                     :OLD.VENDOR_ID,
                     :OLD.VENDOR_CODE,
                     :OLD.VENDOR_TYPE,
                     :OLD.VENDOR_NAME,
                     :OLD.VENDOR_DOMAIN,
                     :OLD.EMAIL,
                     :OLD.CONTACT,
                     :OLD.COUNTRY,
                     :OLD.PRODUCT,
                     :OLD.MAX_NORMAL_USERS,
                     :OLD.MAX_ADMIN_USERS,
                     :OLD.STATUS,
                     :OLD.CREATED_BY,
                     :OLD.APPROVED_BY,
                     :OLD.CREATED_TIME,
                     :OLD.UPDATED_TIME,
                     'delete'
                 );
END IF;
END;
/



CREATE OR REPLACE TRIGGER VENDOR_USER_AUDIT_TRG
    AFTER UPDATE OR DELETE ON VENDOR_USER
    FOR EACH ROW
BEGIN
    IF UPDATING THEN
        INSERT INTO VENDOR_USER_AUDIT (
            VENDOR_USER_ID,
            VENDOR_USER_NAME,
            VENDOR_USER_EMAIL,
            VENDOR_USER_ROLE,
            VENDOR_USER_COUNTRY,
            VENDOR_USER_STATUS,
            VENDOR_USER_CONTACT,
            VENDOR_ID,
            CREATED_BY,
            APPROVED_BY,
            CREATED_TIME,
            UPDATED_TIME,
            EVENT_TYPE
        ) VALUES (
                     :OLD.VENDOR_USER_ID,
                     :OLD.VENDOR_USER_NAME,
                     :OLD.VENDOR_USER_EMAIL,
                     :OLD.VENDOR_USER_ROLE,
                     :OLD.VENDOR_USER_COUNTRY,
                     :OLD.VENDOR_USER_STATUS,
                     :OLD.VENDOR_USER_CONTACT,
                     :OLD.VENDOR_ID,
                     :OLD.CREATED_BY,
                     :OLD.APPROVED_BY,
                     :OLD.CREATED_TIME,
                     :OLD.UPDATED_TIME,
                     'update'
                 );
END IF;
    IF DELETING THEN
        INSERT INTO VENDOR_USER_AUDIT (
            VENDOR_USER_ID,
            VENDOR_USER_NAME,
            VENDOR_USER_EMAIL,
            VENDOR_USER_ROLE,
            VENDOR_USER_COUNTRY,
            VENDOR_USER_STATUS,
            VENDOR_USER_CONTACT,
            VENDOR_ID,
            CREATED_BY,
            APPROVED_BY,
            CREATED_TIME,
            UPDATED_TIME,
            EVENT_TYPE
        ) VALUES (
                     :OLD.VENDOR_USER_ID,
                     :OLD.VENDOR_USER_NAME,
                     :OLD.VENDOR_USER_EMAIL,
                     :OLD.VENDOR_USER_ROLE,
                     :OLD.VENDOR_USER_COUNTRY,
                     :OLD.VENDOR_USER_STATUS,
                     :OLD.VENDOR_USER_CONTACT,
                     :OLD.VENDOR_ID,
                     :OLD.CREATED_BY,
                     :OLD.APPROVED_BY,
                     :OLD.CREATED_TIME,
                     :OLD.UPDATED_TIME,
                     'delete'
                 );
END IF;
END;
/
