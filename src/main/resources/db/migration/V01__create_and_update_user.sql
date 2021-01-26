CREATE TABLE users(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INTEGER NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL,
    sex VARCHAR(50) NOT NULL
);

INSERT INTO users(name, age, phone, email, sex) VALUES ('Pedro', 22, '+5583986862912', 'pedro.sousa@phoebus.com.br', 'MASCULINO');