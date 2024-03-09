-- V1__create-table-jogos.sql

create table jogo (
    id serial primary key,
    nome varchar(255) not null,
    descricao text,
    data_lancamento date,
    website varchar(255),
    desenvolvedor_codigo bigint,
    genero varchar(50),
    url_capa varchar(255)
);

create table desenvolvedor (
    codigo bigint primary key,
    nome varchar(255) not null,
    data_fundacao date,
    website varchar(255),
    sede varchar(255)
);

create table console (
    codigo serial primary key,
    nome varchar(255) not null,
    data_lancamento date,
    empresa varchar(255)
);

create table jogo_console (
    jogo_id bigint,
    console_codigo bigint,
    primary key (jogo_id, console_codigo),
    foreign key (jogo_id) references jogo(id),
    foreign key (console_codigo) references console(codigo)
);

-- Certifique-se de ajustar as datas no formato correto para o seu banco de dados
insert into jogo (nome, descricao, data_lancamento, website, desenvolvedor_codigo, genero, url_capa)
values ('Call of Duty Ghost', 'Welcome to Call of Duty: Ghosts', '2013-05-01', 'https://www.callofduty.com/br/pt', 1, 'FPS', 'https://upload.wikimedia.org/Call_of_duty_ghosts_box_art.jpg');

insert into console (nome, data_lancamento, empresa)
values('Playstation 4', '2013-11-12', 'Sony');

insert into console (nome, data_lancamento, empresa)
values ('Playstation 5', '2020-11-15', 'Sony');

insert into jogo_console (jogo_id, console_codigo)
values (1, 1), (1, 2);
