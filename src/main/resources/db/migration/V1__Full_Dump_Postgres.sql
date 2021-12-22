CREATE SEQUENCE customers_seq;

CREATE TABLE IF NOT EXISTS customers (
  id int NOT NULL DEFAULT NEXTVAL ('customers_seq'),
  name varchar(120),
  document varchar(11),
  PRIMARY KEY (id)
);

INSERT INTO customers (name, document) VALUES
    ('Michael C. Feathers', '11111111111'),
    ('Ralph Johnson', '22222222222'),
    ('Robert C', '33333333333'),
    ('Crockford', '44444444444');

CREATE SEQUENCE permission_seq;

CREATE TABLE IF NOT EXISTS permission (
    id bigint NOT NULL DEFAULT NEXTVAL ('permission_seq'),
    description varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

INSERT INTO permission (description) VALUES
    ('ADMIN'),
    ('MANAGER'),
    ('COMMON_USER');

ALTER SEQUENCE permission_seq RESTART WITH 4;

CREATE SEQUENCE users_seq;

CREATE TABLE IF NOT EXISTS users (
    id bigint NOT NULL DEFAULT NEXTVAL ('users_seq'),
    user_name varchar(255) DEFAULT NULL,
    full_name varchar(255) DEFAULT NULL,
    password varchar(255) DEFAULT NULL,
    account_non_expired boolean DEFAULT TRUE,
    account_non_locked boolean DEFAULT TRUE,
    credentials_non_expired boolean DEFAULT TRUE,
    enabled boolean DEFAULT TRUE,
    PRIMARY KEY (id),
    CONSTRAINT uk_user_name UNIQUE  (user_name)
);

INSERT INTO users (user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES
    ('admin', 'Administrador', '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', TRUE, TRUE, TRUE, TRUE),
    ('user', 'User', '$2a$16$h4yDQCYTy62R6xrtFDWONeMH3Lim4WQuU/aj8hxW.dJJoeyvtEkhK', TRUE, TRUE, TRUE, TRUE);

ALTER SEQUENCE users_seq RESTART WITH 3;

CREATE TABLE IF NOT EXISTS user_permission (
    id_user bigint NOT NULL,
    id_permission bigint NOT NULL,
    PRIMARY KEY (id_user,id_permission),
    CONSTRAINT fk_user_permission FOREIGN KEY (id_user) REFERENCES users (id),
    CONSTRAINT fk_user_permission_permission FOREIGN KEY (id_permission) REFERENCES permission (id)
);

CREATE INDEX fk_user_permission_permission ON user_permission (id_permission);

INSERT INTO user_permission (id_user, id_permission) VALUES
    (1, 1),
    (2, 1),
    (1, 2);
