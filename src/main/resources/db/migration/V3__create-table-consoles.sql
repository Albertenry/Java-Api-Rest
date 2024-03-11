-- V3__create-table-consoles.sql

create table consoles (
    codigo serial primary key,
    nome varchar(255) not null,
    data_lancamento date,
    empresa varchar(255)
);

create table jogos_consoles (
    jogo_codigo integer not null references jogos (codigo),
    console_codigo integer not null references consoles (codigo)
);

insert into consoles(nome, data_lancamento, empresa)
values ('PlayStation 5', '2020-11-12', 'Sony');
insert into consoles(nome, data_lancamento, empresa)
values ('Xbox Series X', '2020-11-10', 'Microsoft');
