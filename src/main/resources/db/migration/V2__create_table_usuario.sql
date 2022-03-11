create table usuario(
    id bigint auto_increment not null,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into usuario values(1,'Joao Carlos','joao@webmaster.com.br');