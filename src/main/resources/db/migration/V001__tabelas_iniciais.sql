create table cliente(
    id int primary key auto_increment,
    nome varchar(200),
    password varchar(10)
);
create table cliente_amigos(
  cliente int references cliente(id),
  cliente2 int references cliente(id)
);
create table album(
    id int primary key auto_increment,
    nome varchar(200) not null,
    catalog_url  varchar(200),
    id_cliente int references cliente(id)
);