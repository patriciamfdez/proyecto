delete from `menu_role`;
delete from `user_role`;
delete from `menu`;
delete from `role`;
delete from `services_user`;
delete from `catalogue`;
delete from `daycare`;
delete from `dog_walker_address`;
delete from `dog_walker`;
delete from `users`;
delete from `dog`;
delete from `address`;
delete from `invoice`;

INSERT INTO users (id, active, birth_date, date_initial, email, surname, name, password, phone, user_name)
VALUES (1,1,'2022-05-08','2022-05-08','admin@gmail.com','admin','admin','$2a$04$UWl44lyROes50n/qHGQKbu.3JwDMXkZZSaL1Tz5V7IF4EORU6p2fG','956783542','admin'),
       (2,1,'2022-05-08','2022-05-08','emingora@gmail.com','emingora','emingora','$2a$04$UWl44lyROes50n/qHGQKbu.3JwDMXkZZSaL1Tz5V7IF4EORU6p2fG','956783541','emingora'),
       (3,0,'2022-05-08','2022-05-08','emingora@gmail.com','nonactiveuser','nonactiveuser','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','956783540','nonactiveuser'),
       (4,1,'2022-05-08','2022-05-08','pepe@gmail.com','Garcia Rodriguez','Pepe','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','956783542','pepe'),
       (5,1,'2022-05-08','2022-05-08','daniel@gmail.com','Perez Callejo','Daniel','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','956783541','daniel'),
       (6,1,'2022-05-08','2022-05-08','antonio@gmail.com','Peralta Castillo','Antonio','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','956783540','antonio'),
       (7,1,'2022-05-08','2022-05-08','laura@gmail.com','Martinez Ruiz','Laura','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','956783540','laura'),
       (8,1,'2022-05-08','2022-05-08','enrique@gmail.com','Lopez Gomez','Enrique','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','956783540','enrique');
INSERT INTO users (id, user_name, password, date_initial, active)
VALUES (99999,'default','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',1);

INSERT INTO role (id, role_name)
VALUES
	  (1,'ROLE_ADMIN'),
	  (2,'ROLE_USER'),
	  (3,'ROLE_DOGWALKER'),
      (4,'ROLE_DAYCARE'),
      (5,'ROLE_ANONYMOUS');

INSERT INTO user_role (user_id, role_id)
VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (2,2),
    (3,2),
    (4,2),
    (4,3),
    (5,2),
    (5,3),
    (6,2),
    (6,4),
    (7,2),
    (7,4),
    (99999,5);

-- Menu
INSERT INTO menu (id, description, app_order, active, url)
VALUES
    (1,'Home',0, 1, '/'),
    (2,'Tasks',1, 1, '/tasks'),
    (3,'Admin',10, 1, '/admin'),
    (4,'Daycare',20, 1, '/Daycare'),
    (5,'DogWalker',30, 1, '/Dogwalker'),
    (6,'Users',40, 1, '/users'),
    (9,'Login',1000, 1, '/login');

INSERT INTO menu_role(menu_id, role_id)
VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (2,1),
    (2,2),
    (2,3),
    (2,4),
    (3,1),
    (4,1),
    (4,2),
    (5,1),
    (5,2),
    (1,5),
    (6,1),
    (9,5);



INSERT INTO dog (id, age, allergies, compatible, gender, inf_additional, microchip, name, race, sterilized, weight_kg)
VALUES
( 1, 2, 'yes',1,'F','X', 1,'Federica', 'dalmatian',1, 20),
( 2, 4, 'no',1,'M','X', 1,'Estanislao','bull dog',1,10),
( 3, 1, 'no',1,'M','My dog bite', 1,'Sigofredo','Chihuahua',1,3),
( 4, 7, 'yes',1,'F','X', 1,'Don Dog','beagle',1, 14),
( 5, 8, 'no',1,'F','X', 1,'Juanita','galgo', 1,18);

INSERT INTO address (id,address,city,country,postal_code,province)
VALUES
  ( 1, '1','Don Dog','Rumania','22178', 'Sevilla'),
  ( 2, '2','Don Dog','Rumania','22178', 'Sevilla'),
  ( 3, '3','Don Dog','Rumania','22178', 'Sevilla'),
  ( 4, '4','Don Dog','Rumania','22178', 'Sevilla'),
  ( 5, '5','Don Dog','Rumania','22178', 'Sevilla');

INSERT INTO daycare (id,name,night_price,phone,email,ranking,address_id)
VALUES
  ( -1, 'dummy',25,'dummy','dummy', 7, 5),
  ( 1, 'pets junior',25,'666777888','pruebaguarderia@gmail.com', 7, 5),
  ( 2, 'pets seniors',23,'666777888','pruebaguarderia@gmail.com', 7, 4),
  ( 3, 'dogs seniors',15,'666777888','pruebaguarderia@gmail.com', 7, 3),
  ( 4, 'dogs junios',10,'666777888','pruebaguarderia@gmail.com', 7, 2),
  ( 5, 'pipi junios',5,'666777888','pruebaguarderia@gmail.com', 7, 1);

INSERT INTO dog_walker (id, assessment, availability, birthdate, doc_identification, email, gallery, max_num_dogs, name, password, phone, price_walk, profile_picture, reviews, sterilized, user_name, weight_dogs, surname)
VALUES
  (-1, 4.1, 'dummy', '2022-05-08','87653976G','dummy', null, 2, 'pepe', '123', '956783542', 10.7, null, 'Buena persona', 'No', 'pepe', 14.6, 'castro'),
  (1, 4.1, 'Todo el año', '2022-05-08','87653976G','pepe@gmail.com', null, 2, 'pepe', '123', '956783542', 10.7, null, 'Buena persona', 'No', 'pepe', 14.6, 'castro');

INSERT INTO catalogue (id, service_type, id_product, service_description)
VALUES
    (1, 'daycare', '1', 'residencia canina 1'),
    (2, 'dogwalker', '1', 'paseador 1');

UPDATE users SET dog_id = 1 WHERE id = 1 AND id = 5;
UPDATE users SET dog_id = 2 WHERE id = 3;
UPDATE users SET dog_id = 3 WHERE id = 6;
UPDATE users SET dog_id = 4 WHERE id = 8;
UPDATE users SET dog_id = 5 WHERE id = 2;

commit;