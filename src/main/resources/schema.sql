create table if not exists EMPLOYEES
(ID integer auto_increment primary key, FIRST_NAME varchar(100), LAST_NAME varchar(100), EMAIL varchar(50));

create table if not exists ROLES
(ID integer auto_increment primary key, NAME varchar(50));

create table if not exists USER
(ID integer auto_increment primary key, USERNAME varchar(50), PASSWORD varchar(50), ACCOUNTEXPIRYDATE DATE NOT NULL,
ACCOUNTLOCKEDSTATUS INT, CREDENTIALSEXPIRYDATE DATE NOT NULL, ACCOUNTENABLEDSTATUS INT);

CREATE TABLE IF NOT EXISTS USER_ROLES (
    USER_ID INTEGER,
    ROLE_ID INTEGER,
    FOREIGN KEY (USER_ID) REFERENCES USER(ID),
    FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ID),
    PRIMARY KEY (USER_ID, ROLE_ID)
);