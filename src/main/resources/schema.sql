create table if not exists EMPLOYEES
(ID integer auto_increment primary key, FIRST_NAME varchar(100), LAST_NAME varchar(100), EMAIL varchar(50));

create table if not exists ROLES
(ID integer auto_increment primary key, NAME varchar(50));

CREATE TABLE IF NOT EXISTS USER (
    ID INTEGER AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL,
    ACCOUNTEXPIRYDATE DATE NOT NULL DEFAULT '2025-12-31',
    ACCOUNTLOCKEDSTATUS INT NOT NULL DEFAULT 1,
    CREDENTIALSEXPIRYDATE DATE NOT NULL DEFAULT '2025-12-31',
    ACCOUNTENABLEDSTATUS INT NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS USER_ROLES (
    USER_ID INTEGER,
    ROLE_ID INTEGER,
    FOREIGN KEY (USER_ID) REFERENCES USER(ID),
    FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ID),
    PRIMARY KEY (USER_ID, ROLE_ID)
);