create table Cliente(
    id int primary key,
    nome varchar(200)
);
create table Cliente_Relation(
  Primeiro_Cliente int references Cliente(id),
  Segundo_Cliente int references Cliente(id)
);
create table Album(
    id int primary key,
    nome varchar(200) not null,
    catalog_url  varchar(200),
    id_cliente int references Cliente(id)
);