INSERT INTO users (email, enable, first_name, last_name, login, password) VALUES ('admin@admin', true, 'admin', 'admin', 'admin', '$2a$10$PABIIGOFqtzC8A3eBcYaauQrsxaJlzTJdDKjWZUhD5GgduwfNvwW6');
INSERT INTO users (email, enable, first_name, last_name, login, password) VALUES ('user@user', true, 'user', 'user', 'user', '$2a$10$D/bgcitxQlRKEifUCIXBZuX/d.hBuVAsmpT4DQtdaKSd1zQ1/Orfu');
INSERT INTO roles (role) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role) VALUES ('ROLE_USER');
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);

-- CLIENTS
INSERT INTO clients (first_name, last_name, gender, phone, email, active, street, city, post_code) VALUES ('Adam', 'Kowalski', 'M', '601203405', 'adam@adam.pl', true, 'Kolorowa 2a', 'Gorzów Wlkp.', '66-400');
INSERT INTO clients (first_name, last_name, gender, phone, email, active, street, city, post_code) VALUES ('Anna', 'Kwiatkowska', 'K', '606708910', 'anna@test.pl', true, 'Jaśminowa 5', 'Gorzów Wlkp.', '66-400');
--

-- TYPE OF DIVISIONS
INSERT INTO types_of_division (type_name) VALUES ('Minecraft: Wstęp do programowania');
INSERT INTO types_of_division (type_name) VALUES ('Minecraft: Podstawy programowania');
INSERT INTO types_of_division (type_name) VALUES ('Minecraft: Programowanie dla zaawansowanych');
INSERT INTO types_of_division (type_name) VALUES ('Elektronika: Dla początkujących');
INSERT INTO types_of_division (type_name) VALUES ('Robotyka: Mój pierwszy robot');
INSERT INTO types_of_division (type_name) VALUES ('Robotyka: Wyzwanie');
--

-- DIVISIONS
INSERT INTO divisions (division_name, day_of_week, duration, start_hour, type_id) VALUES ('PON-MC-PODST-17', 'PONIEDZIAŁEK', 90, '17:00', 1);
INSERT INTO divisions (division_name, day_of_week, duration, start_hour, type_id) VALUES ('WT-EL-PODST-17', 'WTOREK', 90, '16:30', 4);
--

-- CHILDREN
INSERT INTO children (active, first_name, last_name, gender, age, client_id) VALUES (true, 'Jan', 'Kowalski', 'M', 11, 1);
INSERT INTO children (active, first_name, last_name, gender, age, client_id) VALUES (true, 'Joanna', 'Kwiatkowska', 'K', 8, 2);
--

-- CHILD - CLASS
INSERT INTO child_class (child_id, class_id) VALUES (1, 2);
INSERT INTO child_class (child_id, class_id) VALUES (2, 1);
--

-- CALLENDAR
INSERT INTO calendar (date_of_activities) VALUES ('2018-10-20');
INSERT INTO calendar (date_of_activities) VALUES ('2018-10-27');
INSERT INTO calendar (date_of_activities) VALUES ('2018-11-05');
INSERT INTO calendar (date_of_activities) VALUES ('2018-11-17');

-- CLASSESS - CALENDARS
INSERT INTO classes_calendars (class_id, calendar_id) VALUES (1, 1);
INSERT INTO classes_calendars (class_id, calendar_id) VALUES (1, 2);
INSERT INTO classes_calendars (class_id, calendar_id) VALUES (2, 3);
INSERT INTO classes_calendars (class_id, calendar_id) VALUES (2, 4);

-- PAYMENTS
INSERT INTO payments (amount, paymant_day) VALUES (100.00, '2018-11-01');
INSERT INTO payments (amount, paymant_day) VALUES (100.00, '2018-12-01');
INSERT INTO payments (amount, paymant_day) VALUES (100.00, '2018-11-01');
INSERT INTO payments (amount, paymant_day) VALUES (100.00, '2018-12-01');

-- CLIENT - PAYMENTS
INSERT INTO clients_payments (client_id, paymant_id) VALUES (1, 1);
INSERT INTO clients_payments (client_id, paymant_id) VALUES (1, 2);
INSERT INTO clients_payments (client_id, paymant_id) VALUES (2, 3);
INSERT INTO clients_payments (client_id, paymant_id) VALUES (2, 4);

-- INSTALLMENTS
INSERT INTO installments (amount, paymant_day, payment_id) VALUES (200.00, '2018-09-01', 1);
INSERT INTO installments (amount, paymant_day, payment_id) VALUES (100.00, '2018-10-01', 2);
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2018-11-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2018-12-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2019-01-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2019-02-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2019-03-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2019-04-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2019-05-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2019-06-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2018-11-01');
INSERT INTO installments (amount, paymant_day) VALUES (100.00, '2018-12-01');

-- CLIENTS - INSTALLMENTS
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 1);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 2);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 3);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 4);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 5);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 6);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 7);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 8);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 9);
INSERT INTO clients_installments (client_id, installment_id) VALUES (1, 10);
INSERT INTO clients_installments (client_id, installment_id) VALUES (2, 11);
INSERT INTO clients_installments (client_id, installment_id) VALUES (2, 12);