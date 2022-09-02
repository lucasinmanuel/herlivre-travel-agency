select v.id as "id_voo",v.ponto_partida,v.data_partida,c.nome as "ponto_chegada",v.data_chegada,r.id as "id_registro",r.entrada,r.saida,h.id as "id_hotel",h.nome as "hotel",q.id as "id_quarto",q.numero,q.qtd_camas,q.tipo,c.id as "id_cidade",c.uf,c.pais 
from voos v,pacotes p,registroaluguelquarto r,quartos q,hoteis h,cidades c where r.id_quarto = q.id and q.id_hotel = h.id and h.id_cidade = c.id and
v.data_partida < r.entrada;

/*CIDADES*/
insert into cidades(nome,uf,pais,continente) values("Salvador","BA","Brasil","America do Sul");
insert into cidades(nome,uf,pais,continente) values("Duque de Caxias","RJ","Brasil","America do Sul");
insert into cidades(nome,uf,pais,continente) values("São Paulo","SP","Brasil","America do Sul");
insert into cidades(nome,uf,pais,continente) values("Recife","PE","Brasil","America do Sul");
insert into cidades(nome,uf,pais,continente) values("Fortaleza","CE","Brasil","America do Sul");
insert into cidades(nome,uf,pais,continente) values("Rio de Janeiro","RJ","Brasil","America do Sul");
insert into cidades(nome,uf,pais,continente) values("Brasília","DF","Brasil","America do Sul");

/*HOTÉIS DA CIDADE DE SALVADOR*/
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(2,"Sotero Hotel",4,206,true,true,"41770-235","R. Dr. José Peroba, 97","Stiep");
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(2,"Bahia Othon Palace",5,247,true,true,"40170-010","Av. Oceânica, 2294","Ondina");

/*HOTÉIS DA CIDADE DE SÃO PAULO*/
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(4,"Radisson Vila Olímpia Atlantica",5,740,true,true,"04551-010","Rua Fidêncio Ramos, 420","Vila Olímpia");
insert into hoteis(id_cidade,nome,qtd_estrelas,valor_min,wifi,cafe_manha,cep,logradouro,bairro) 
values(4,"Vila Galé Paulista",4,627,true,true,"01415-002","R. Bela Cintra, 952","Consolação");

/*QUARTOS DO HOTEL SOTERO HOTEL - SALVADOR*/
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(212,2,206,3,1,"Single room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(215,2,212,2,2,"Twin room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(302,2,232,3,2,"Twin room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(310,2,257,3,1,"Double room");

/*QUARTOS DO HOTEL BAHIA OTHON PALACE - SALVADOR*/
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(322,3,267,3,1,"Double room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(219,3,247,2,2,"Twin room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(233,3,238,3,2,"Double room");

/*QUARTOS DO HOTEL Radisson Vila Olímpia Atlantica - SÂO PAULO*/
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(402,4,897,3,1,"Double room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(512,4,740,2,2,"Twin room");
insert into quartos(numero,id_hotel,valor,diaria,qtd_camas,tipo) 
values(335,4,818,3,2,"Double room");

/*REGISTRO DE ALUGUEIS DOS QUARTOS
insert into registroaluguelquarto(id_quarto,entrada,saida) values(2,"2022-11-04","2022-11-08");
insert into registroaluguelquarto(id_quarto,entrada,saida) values(2,"2022-10-26","2022-10-30");
insert into registroaluguelquarto(id_quarto,entrada,saida) values(3,"2022-10-25","2022-10-29");
insert into registroaluguelquarto(id_quarto,entrada,saida) values(3,"2022-11-18","2022-11-22");
insert into registroaluguelquarto(id_quarto,entrada,saida) values(9,"2022-11-04","2022-11-08");
insert into registroaluguelquarto(id_quarto,entrada,saida) values(9,"2022-12-26","2022-12-30");
insert into registroaluguelquarto(id_quarto,entrada,saida) values(9,"2022-10-25","2022-10-29");
insert into registroaluguelquarto(id_quarto,entrada,saida) values(9,"2022-11-18","2022-11-22");*/

/*VOOS*/
insert into voos(id_cidade,ponto_partida,companhia,num_voo,num_assento,qtd_assentos_disp,data_partida,data_chegada) 
values(2,"Rio de Janeiro","Gol Transportes Aéreos","GA14CS","4C",54,"2022-10-23 22:30:00","2022-10-20 23:12:00");
insert into voos(id_cidade,ponto_partida,companhia,num_voo,num_assento,qtd_assentos_disp,data_partida,data_chegada) 
values(2,"Duque de Caxias","Gol Transportes Aéreos","GA14CS","4C",10,"2022-10-19 10:20:00","2022-10-19 13:02:00");
insert into voos(id_cidade,ponto_partida,companhia,num_voo,num_assento,qtd_assentos_disp,data_partida,data_chegada)
values(2,"São Paulo","Avianca","TU72VSF","8B",30,"2022-11-02 22:30:00","2022-11-03 07:12:00");
insert into voos(id_cidade,ponto_partida,companhia,num_voo,num_assento,qtd_assentos_disp,data_partida,data_chegada)
values(2,"São Paulo","Avianca","TU72VSF","3A",20,"2022-10-02 10:20:00","2022-10-02 13:40:15");

/*USUÁRIOS*/
insert into usuarios(nome,cpf,email,senha) 
values("Lucas","123-345-678-99","lucas.recode@gmail.com","123");
insert into usuarios(nome,cpf,email,senha) 
values("Flavio","111-234-125-45","flavio.recode@gmail.com","321");
insert into usuarios(nome,cpf,email,senha) 
values("bruno","231-324-256-67","bruno.recode@gmail.com","132");