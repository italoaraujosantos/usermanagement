CREATE DATABASE db_users;
USE db_users;
CREATE TABLE tb_users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    birth_date DATE,
    user_type VARCHAR(50) NOT NULL
);
INSERT INTO tb_users (full_name, email, phone, birth_date, user_type) 
VALUES 
('João Silva', 'joao.silva@email.com', '11987654321', '1990-05-15', 'ADMIN'),
('Maria Oliveira', 'maria.oliveira@email.com', '21976543210', '1985-10-20', 'VIEWER'),
('Carlos Santos', 'carlos.santos@email.com', '31998765432', '1992-03-08', 'EDITOR');
