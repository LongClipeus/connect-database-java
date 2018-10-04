CREATE DATABASE test_db;
USE test_db;

CREATE TABLE man_hinh (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten VARCHAR(255) NOT NULL
);

INSERT INTO man_hinh (ten)
VALUES ("login");

INSERT INTO man_hinh (ten)
VALUES ("logout");