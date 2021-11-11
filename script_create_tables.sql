create table usuario
(
    id       int auto_increment
        primary key,
    nome     varchar(50)                not null,
    cpf      varchar(14)                not null,
    username varchar(50)                not null,
    password varchar(100)               not null,
    role     varchar(60) default 'user' not null
);

create table ordem
(
    id      int auto_increment
        primary key,
    preco   decimal(6, 2) not null,
    tipo    varchar(20)   not null,
    data    datetime      not null,
    status  varchar(30)   not null,
    user_id int           not null,
    constraint ordem_ibfk_1
        foreign key (user_id) references usuario (id)
);

create index user_id
    on ordem (user_id);


