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
    password VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO client VALUES(1, 'Luiz', 18, 'Av. das Américas', 123, 'São Paulo', 'SP', '(11) 1234-5678', 'luiz@email.com', '$2a$10$R.4eKMlFQg80.Z883wYPQOPMfczCGF.Vj8U4CZcN./PVmuyaxuIWW', true)