create table curso(
    id bigint auto_increment not null,
    nome varchar(50),
    categoria varchar(50),
    primary key(id)
);

insert into curso values (1, 'Kotlin', 'Kotlin no Backend');
insert into curso values (2, 'Kotlin', 'Kotlin no FrontEnd');