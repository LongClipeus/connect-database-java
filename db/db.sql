CREATE DATABASE test_db;
USE test_db;

CREATE TABLE man_hinh (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    text VARCHAR(255) DEFAULT ""
);

INSERT INTO man_hinh (type)
VALUES ("JFrame");

INSERT INTO man_hinh (type, text)
VALUES ("JLabel", 'Welcome');

INSERT INTO man_hinh (type, text)
VALUES ("Button", 'Ok');