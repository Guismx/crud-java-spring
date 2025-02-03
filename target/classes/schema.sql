drop table if exists Comercio;
drop table if exists Cidade;

create table Cidade(
    id int not null AUTO_INCREMENT,
    nome varchar(100) not null,
    uf varchar(2) not null,
    capital boolean not null,
    PRIMARY KEY (ID)
);

create table Comercio(
    id int not null AUTO_INCREMENT,
    nome_comercio varchar(100) not null,
    nome_responsavel varchar(100) not null,
    tipo_comercio varchar(20) not null,
    cidade_id int not null,
    PRIMARY KEY (ID),
    FOREIGN KEY (cidade_id) REFERENCES Cidade(id) ON DELETE CASCADE
);

