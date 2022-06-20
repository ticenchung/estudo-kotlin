  CREATE TABLE product(
      id BIGINT NOT NULL AUTO_INCREMENT,
      name VARCHAR(20) NOT NULL,
      quantity INT NOT NULL,
      price DECIMAL(5,2) NOT NULL,
      description VARCHAR(255) NOT NULL,
      is_active BOOLEAN NOT NULL,
      PRIMARY KEY(id)
  );