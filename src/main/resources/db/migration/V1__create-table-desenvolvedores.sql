-- V2__create-table-desenvolvedores.sql

create table desenvolvedores (
    codigo serial primary key,
    nome varchar(255) not null,
    data_fundacao date,
    website varchar(255),
    sede varchar(255)
);

insert into desenvolvedores(nome, data_fundacao, website, sede)
values ('Activision', '1996-05-01', 'https://www.activision.com/', 'Estados Unidos');