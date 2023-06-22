CREATE DATABASE IF NOT EXISTS skadoosh;

USE skadoosh;

CREATE TABLE  IF NOT EXISTS usuario(
	id_usuario int not null auto_increment,
    nome varchar(40) not null,
    cpf varchar(11) not null unique,
    email varchar(40) not null unique,
    senha varchar(8) not null,
    permissao tinyint not null,
    PRIMARY KEY (id_usuario)
);

CREATE TABLE IF NOT EXISTS voo(
	id_voo int not null auto_increment,
    dt_hr_decolagem varchar(20) not null,
    preco_passagem varchar(10) not null,
    aero_origem varchar(100) not null,
    aero_destino varchar(100) not null,
    PRIMARY KEY (id_voo)
);

insert into usuario (nome, cpf, email, senha, permissao) 
values ("José marcola de horn", "12345678901", "marcola@gmail.com", "1111", 1),
("Gabriza rasquito", "23456789012", "gabriza@gmail.com", "2222", 1),
("Luizito carrarito", "34567890123", "luizito@gmail.com", "3333", 1),
("admin", "00000000000", "admin@skadoosh.com", "0000", 0);