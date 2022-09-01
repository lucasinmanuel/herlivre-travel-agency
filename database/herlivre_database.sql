create database if not exists herlivre;

create table if not exists cidades(

	id int primary key auto_increment,
    nome varchar(50) not null,
    uf char(2) not null,
    pais varchar(30) not null,
    continente varchar(20) not null

);

insert into cidades(nome,uf,pais,continente) values("null","nu","null","null");

select * from cidades where id != 1;

create table if not exists hoteis(
	
    id int primary key auto_increment,
    id_cidade int not null,
	nome varchar(50) unique not null,
    qtd_estrelas int not null,
    valor_min double not null,
    wifi boolean not null,
    cafe_manha boolean not null,
    cep varchar(10) not null,
    logradouro varchar(50) not null,
    bairro varchar(50) not null,
    foreign key (id_cidade) references cidades (id) 

);

insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(1,"null",0,0,true,true,"null","null","null");

select * from hoteis where id != 1;

create table if not exists quartos(

	id int primary key auto_increment,
	numero int not null,
    id_hotel int not null,
    valor double not null,
    diaria int not null,
    qtd_camas int not null,
    tipo varchar(20) not null,
    foreign key (id_hotel) references hoteis (id)

);

insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(0,1,0,0,0,"null");

select * from quartos where id != 1;

create table if not exists registroaluguelquarto(

	id int primary key auto_increment,
    id_quarto int not null,
	entrada date not null,
    saida date not null,
    foreign key (id_quarto) references quartos (id)

);

/*GARANTE QUE UM NOVO REGISTRO SEJA ADICIONADO ATRÁS DESSE DELIMITADOR*/
insert into registroaluguelquarto(id_quarto,entrada,saida) values(1,"9999-12-31","9999-12-31");

select * from registroaluguelquarto order by entrada;
SELECT * FROM registroaluguelquarto WHERE id_quarto = 4 OR entrada = "9999-12-31" ORDER BY entrada;

create table if not exists voos(

	id int primary key auto_increment,
    id_cidade int not null,
    ponto_partida varchar(30) not null,
    companhia varchar(30) not null,
    num_voo varchar(10) not null,
    num_assento char(2) not null,
    qtd_assentos_disp int,
    data_partida datetime not null,
    data_chegada datetime not null,
    foreign key (id_cidade) references cidades (id)
    
);

insert into voos(id_cidade,ponto_partida,companhia,num_voo,num_assento,data_partida,data_chegada) 
values(1,"null","null",0,0,"9999-12-31","9999-12-31");

select * from voos where id != 1;

create table if not exists pacotes(

	id int primary key auto_increment,
    id_voo int not null,
    id_registroaluguelquarto int not null,
    total_pessoas int not null,
    valor_original double not null,
    desconto int,
    valor_promocional double,
    foreign key (id_voo) references voos (id),
    foreign key (id_registroaluguelquarto) references registroaluguelquarto (id)
    
);

insert into pacotes(id_voo,id_registroaluguelquarto,total_pessoas,valor_original,desconto,valor_promocional) 
values(1,1,0,0,0,0);

select * from pacotes;

create table if not exists usuarios(

	id int primary key auto_increment,
    nome varchar(50) not null,
    cpf varchar(20) unique not null,
    email varchar(30) unique not null,
    senha varchar(255) not null
    
);

insert into usuarios(nome,cpf,email,senha) 
values("adm","0","adm.recode@gmail.com","123456789");

select * from usuarios where id != 1;

create table if not exists comprovantes(

	id int primary key auto_increment,
    id_registroaluguelquarto int not null,
    id_usuario int not null,
    id_pacote int,
    data_compra datetime not null,
    foreign key (id_registroaluguelquarto) references registroaluguelquarto (id),
    foreign key (id_usuario) references usuarios (id),
    foreign key (id_pacote) references pacotes (id)
    
);

insert into comprovantes(id_registroaluguelquarto,id_usuario,id_pacote,data_compra) 
values(1,1,1,"9999-12-31");

select * from comprovantes where id != 1;
