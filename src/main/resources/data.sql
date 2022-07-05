INSERT INTO `USER` (`ID`, `USER_NAME`, `PASSWORD`, `DATE`, ACTIVE)
VALUES
	(1,'admin','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',1),
	(2,'emingora','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',1),
	(3,'nonactiveuser','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',0);
INSERT INTO `USER` (`ID`,ACTIVE ,`DATE`, `PASSWORD`,   `USER_NAME`)
VALUES
    (4,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'jma'),
    (5,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'pepe'),
    (6,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'enrique'),
    (7,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'olga'),
    (8,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'luisa');

INSERT INTO `ROLE` (`ID`, `ROLE_NAME`)
VALUES
	(1,'ROLE_ADMIN'),
	(2,'ROLE_USER');

INSERT INTO `USER_ROLES` (`USERS_ID`, `ROLES_ID`)
VALUES
	(1,1),
	(1,2),
	(2,2),
	(3,2),
    (4,2),
    (5,2),
    (6,2),
    (7,2),
    (8,2);


-- Menu
INSERT INTO `MENU` (`ID`, `DESCRIPTION`, `APP_ORDER`, `ACTIVE`, `URL`)
VALUES
	(1,'Home',0, 1, '/'),
	(2,'Tasks',1, 1, '/tasks'),
	(3,'Admin',10, 1, '/admin'),
	(4,'Books',20, 1, '/books'),
	(5,'Books read',30, 1, '/booksread'),
	(6,'Books sold',40, 1, '/bookssolds');

INSERT INTO `MENU_ROLES` (`MENU_ID`, `ROLES_ID`)
VALUES
	(1,1),
	(1,2),
	(2,1),
	(2,2),
	(3,1),
    (4,1),
    (4,2),
    (5,1),
    (5,2),
    (6,1),
    (6,2);