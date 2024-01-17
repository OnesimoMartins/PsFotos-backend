create table amigo_album(
  id_album int references album(id),
  id_amigo int references cliente(id)
);