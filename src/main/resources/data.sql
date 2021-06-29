DROP TABLE IF EXISTS User;

CREATE TABLE User
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    pseudo     VARCHAR(250) DEFAULT NULL
);

INSERT INTO User (first_name, last_name, pseudo)
VALUES ('Eric', 'Morandini', 'H0wrus'),
       ('Arthur', 'Allen', 'ZiArtist'),
       ('Alexis', 'Baï', 'Delkoss');