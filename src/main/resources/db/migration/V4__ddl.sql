create table pacientes(
    id serial primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20),
    cpf varchar(11) not null unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    active boolean not null
);