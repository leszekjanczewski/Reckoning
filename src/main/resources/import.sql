INSERT INTO roles (role) VALUES ('ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);

-- CLIENTS
INSERT INTO clients (first_name, last_name, gender, phone, email, active, street, city, post_code) VALUES ('Adam', 'Kowalski', 'M', '601203405', 'adam@adam.pl', true, 'Kolorowa 2a', 'Gorzów Wlkp.', '66-400');
INSERT INTO clients (first_name, last_name, gender, phone, email, active, street, city, post_code) VALUES ('Anna', 'Kwiatkowska', 'K', '606708910', 'anna@test.pl', true, 'Jaśminowa 5', 'Gorzów Wlkp.', '66-400');
--

-- TYPE OF CLASSES
INSERT INTO types_of_classes (type_name) VALUES ('Minecraft: Wstęp do programowania');
INSERT INTO types_of_classes (type_name) VALUES ('Minecraft: Podstawy programowania');
INSERT INTO types_of_classes (type_name) VALUES ('Minecraft: Programowanie dla zaawansowanych');
INSERT INTO types_of_classes (type_name) VALUES ('Elektronika: Dla początkujących');
INSERT INTO types_of_classes (type_name) VALUES ('Robotyka: Mój pierwszy robot');
INSERT INTO types_of_classes (type_name) VALUES ('Robotyka: Wyzwanie');


-- CLASSES
INSERT INTO classes (class_name, day_of_week, duration, start_hour, type_id) VALUES ('PON-MC-PODST-17', 'PONIEDZIAŁEK', 90, '17:00', 1);
INSERT INTO classes (class_name, day_of_week, duration, start_hour, type_id) VALUES ('WT-EL-PODST-17', 'WTOREK', 90, '16:30', 4);

-- CHILDREN
INSERT INTO children (active, first_name, last_name, gender, age, client_id) VALUES (true, 'Jan', 'Kowalski', 'M', 11, 1);
INSERT INTO children (active, first_name, last_name, gender, age, client_id) VALUES (true, 'Joanna', 'Kwiatkowska', 'K', 8, 2);

-- CHILD - CLASS
INSERT INTO child_class (child_id, class_id) VALUES (1, 2);
INSERT INTO child_class (child_id, class_id) VALUES (2, 1);