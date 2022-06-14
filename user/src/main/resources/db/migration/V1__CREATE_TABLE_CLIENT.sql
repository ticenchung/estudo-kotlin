CREATE TABLE client(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    street VARCHAR(50),
    number INT,
    city VARCHAR(25),
    state VARCHAR(2),
    telephone VARCHAR(15) NOT NULL,
    email VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    is_active BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);