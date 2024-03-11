-- V2__create-table-jogos.sql

create table jogos (
    codigo serial primary key,
    desenvolvedor_codigo  integer not null references desenvolvedores (codigo),
    nome varchar(255) not null,
    descricao text,
    data_lancamento date,
    website varchar(255),
    genero varchar(50),
    url_capa varchar(255)
);
