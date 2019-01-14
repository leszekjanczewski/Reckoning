INSERT INTO users (email, enable, first_name, last_name, login, password) VALUES ('admin@recon', true, 'Admin', 'Admin', 'admin', 'admin');
INSERT INTO users (email, enable, first_name, last_name, login, password) VALUES ('user@recon', true, 'User', 'User', 'user', 'user');

INSERT INTO roles (role) VALUES ('ADMIN');
INSERT INTO roles (role) VALUES ('USER');

INSERT INTO users_roles (users_user_id, roles_role_id) VALUES (1, 1);
INSERT INTO users_roles (users_user_id, roles_role_id) VALUES (2, 2);