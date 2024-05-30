insert into EMPLOYEES (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES
(1, 'Beta', 'New', 'Beta@son.com'),
(2, 'omega', 'TOPS', 'Omega@yahoo.com'),
(3, 'Alpha', 'User', 'Alpha@gmail.com');

INSERT INTO ROLES (ID, NAME) VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO USER (ID, USERNAME, PASSWORD) VALUES
(1, 'ADMIN', 'ADMIN123'),
(2, 'USER', 'USER123');

INSERT INTO USER_ROLES(USER_ID, ROLE_ID) VALUES
(1, 1),
(2, 2);