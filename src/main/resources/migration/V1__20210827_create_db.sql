CREATE DATABASE  IF NOT EXISTS  storeuniajc;

USE storeuniajc;

CREATE TABLE  IF NOT EXISTS product(
                        id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        NAME                VARCHAR(30),
                        description         VARCHAR(30),
                        alternate_reference VARCHAR(30)
)ENGINE=INNODB;


CREATE TABLE  IF NOT EXISTS provider(
                         id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         NAME                VARCHAR(30),
                         direction           VARCHAR(30),
                         enrollment_date     VARCHAR(30)
)ENGINE=INNODB;

CREATE TABLE  IF NOT EXISTS  store(
                      id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      NAME                VARCHAR(30),
                      description         VARCHAR(30)
)ENGINE=INNODB;


CREATE TABLE  IF NOT EXISTS  detail(
                       id               INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       quantity         VARCHAR(30),
                       amount           VARCHAR(30),
                       amount_total     VARCHAR(30),
                       product_id       INT,
                       store_id         INT,
                       FOREIGN KEY(product_id)  REFERENCES product(id),
                       FOREIGN KEY(store_id)  REFERENCES   store(id)
)ENGINE=INNODB;


CREATE TABLE   IF NOT EXISTS movement(
                         id    INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         description     VARCHAR(30),
                         provider_id     INT,
                         detail_id       INT,
                         FOREIGN KEY(provider_id)  REFERENCES provider(id),
                         FOREIGN KEY(detail_id)  REFERENCES   detail(id)
)ENGINE=INNODB;

USE storeuniajc;

CREATE TABLE  IF NOT EXISTS product(
                        id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        NAME                VARCHAR(30),
                        description         VARCHAR(30),
                        alternate_reference VARCHAR(30)
)ENGINE=INNODB;


CREATE TABLE  IF NOT EXISTS provider(
                         id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         NAME                VARCHAR(30),
                         direction           VARCHAR(30),
                         enrollment_date     VARCHAR(30)
)ENGINE=INNODB;

CREATE TABLE   IF NOT EXISTS store(
                      id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      NAME                VARCHAR(30),
                      description         VARCHAR(30)
)ENGINE=INNODB;


CREATE TABLE  IF NOT EXISTS  detail(
                       id               INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       quantity         VARCHAR(30),
                       amount           VARCHAR(30),
                       amount_total     VARCHAR(30),
                       product_id       INT,
                       store_id         INT,
                       FOREIGN KEY(product_id)  REFERENCES product(id),
                       FOREIGN KEY(store_id)  REFERENCES   store(id)
)ENGINE=INNODB;


CREATE TABLE  IF NOT EXISTS movement(
                         id    INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         description     VARCHAR(30),
                         provider_id     INT,
                         detail_id       INT,
                         FOREIGN KEY(provider_id)  REFERENCES provider(id),
                         FOREIGN KEY(detail_id)  REFERENCES   detail(id)
)ENGINE=INNODB;