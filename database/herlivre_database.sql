create database if not exists herlivre;

create table if not exists cidades(

	id int primary key auto_increment,
    nome varchar(50),
    uf char(2)

);

insert into cidades(nome,uf) values("Salvador","BA");
insert into cidades(nome,uf) values("Duque de Caxias","RJ");
insert into cidades(nome,uf) values("São Paulo","SP");
insert into cidades(nome,uf) values("Recife","PE");
insert into cidades(nome,uf) values("Fortaleza","CE");
insert into cidades(nome,uf) values("Rio de Janeiro","RJ");
insert into cidades(nome,uf) values("Brasília","DF");
select * from cidades;

create table if not exists hoteis(
	
    id int primary key auto_increment,
    id_cidade int,
	nome varchar(50),
    qtd_estrelas int,
    valor_min double,
    wifi boolean,
    cafe_manha boolean,
    cep varchar(10),
    logradouro varchar(50),
    bairro varchar(50),
    foreign key (id_cidade) references cidades (id) 

);

/*HOTÉIS DA CIDADE DE SALVADOR*/
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(1,"Sotero Hotel",4,206,true,true,"41770-235","R. Dr. José Peroba, 97","Stiep");
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(1,"Bahia Othon Palace",5,247,true,true,"40170-010","Av. Oceânica, 2294","Ondina");

/*HOTÉIS DA CIDADE DE SÃO PAULO*/
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro) 
values(3,"Radisson Vila Olímpia Atlantica",5,740,true,true,"04551-010","Rua Fidêncio Ramos, 420");
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(3,"Vila Galé Paulista",4,627,true,true,"01415-002","R. Bela Cintra, 952","Consolação");

select * from hoteis;

create table if not exists quartos(

	id int primary key auto_increment,
	numero int,
    id_hotel int,
    valor double,
    diaria int,
    qtd_camas int,
    tipo varchar(20),
    foreign key (id_hotel) references hoteis (id)

);

/*QUARTOS DO HOTEL SOTERO HOTEL*/
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(212,1,206,3,1,"Single room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(215,1,212,2,2,"Twin room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(302,1,232,3,2,"Twin room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(310,1,257,3,1,"Double room");

/*QUARTOS DO HOTEL BAHIA OTHON PALACE*/
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(322,2,267,3,1,"Double room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(219,2,247,2,2,"Twin room");

select * from quartos;

create table if not exists usuarios(

	id int primary key auto_increment,
    nome varchar(50),
    cpf varchar(20) unique,
    email varchar(30) unique,
    senha varchar(255)
    
);

insert into usuarios(nome,cpf,email,senha) 
values("Lucas","123-345-678-99","lucas.recode@gmail.com","123");
insert into usuarios(nome,cpf,email,senha) 
values("Flavio","111-234-125-45","flavio.recode@gmail.com","321");
insert into usuarios(nome,cpf,email,senha) 
values("bruno","231-324-256-67","bruno.recode@gmail.com","132");

select * from usuarios;

create table if not exists registroAlugueis(

	id int primary key auto_increment,
    id_quarto int,
    id_usuario int,
	entrada date,
    saida date,
    foreign key (id_quarto) references quartos (id),
    foreign key (id_usuario) references usuarios (id)

);

insert into registroAlugueis(id_quarto,id_usuario,entrada,saida) values(1,1,"2022-08-25","2022-08-27");
insert into registroAlugueis(id_quarto,id_usuario,entrada,saida) values(1,2,"2022-09-8","2022-09-16");
insert into registroAlugueis(id_quarto,id_usuario,entrada,saida) values(2,3,"2022-09-12","2022-09-16");
insert into registroAlugueis(id_quarto,id_usuario,entrada,saida) values(1,2,"2022-07-01","2022-07-12");
insert into registroAlugueis(id_quarto,id_usuario,entrada,saida) values(1,1,"2022-10-03","2022-10-20");

/*GARANTE QUE UM NOVO REGISTRO SEJA ADICIONADO ATRÁS DESSE DELIMITADOR*/
insert into registroAlugueis(entrada,saida) values("9999-12-31","9999-12-31");

select * from registroAlugueis order by entrada;
SELECT * FROM registroAlugueis WHERE id_quarto = 1 OR entrada = "9999-12-31" ORDER BY entrada;


