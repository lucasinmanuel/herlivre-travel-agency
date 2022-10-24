Algoritmo "cadastro-viagens"
// Disciplina   : [Linguagem e Lógica de Programação]

// Descrição   : Cadastra clientes em uma agência  de viagens
// e faz uma consulta nos dados cadastrados

// Autor(a)    : Lucas Emanuel Santana dos Santos | Turma 3
// Data atual  : 16/06/2022
Var
nome,destino: vetor[1..5] de caractere
idade,day,month,year: vetor[1..5] de inteiro
i,encerrar: inteiro

Inicio
i <- 1
encerrar <- 1

enquanto encerrar = 1 faca //Efetua o cadastro

   escreva("Qual o seu nome? ")
   leia(nome[i])
   
   escreva("Qual sua idade? ")
   leia(idade[i])
   
   escreva("Qual o seu destino? ")
   leia(destino[i])
   
   escreva("Ano da viagem? ")
   leia(year[i])
   
   escreva("Mês da viagem? ")
   leia(month[i])
   
   escreva("Dia da viagem? ")
   leia(day[i])
   
   escreval(" ")
   
   escreval("Deseja fazer mais um cadastro? ")
   escreval("Digite '1' para Sim ou qualquer outra tecla para Não")
   leia(encerrar)
   
   escreval(" ")
   escreval("============================")
   escreval(" ")
   
   se (encerrar = 1) e (i >= 5) entao
   
      escreval(" ")
      escreval("Limite de cadastro alcançado :(")
      escreval(" ")
      
      encerrar <- 0
      
   fimse
   
   i <- i + 1
         
fimenquanto //Fim do cadastro

escreval("Deseja mostrar lista de cadastros efetuados?")
escreval("Digite '1' para Sim ou qualquer outra tecla para Não")
leia(encerrar)

se encerrar = 1 entao //Efetua a consulta aos dados

   limpatela
   
   escreval("Lista de clientes: ")

   para i de 1 ate 5 faca

     escreval(" ")
     escreval("============================")
     escreval(" ")

     escreval("Cliente ID: ",i)
     escreval(" ")

     escreval("Nome: ",nome[i])
     escreval("Idade: ",idade[i])
     escreval("Destino: ",destino[i])
     escreval("Data: ",day[i],"/",month[i],"/",year[i])

   fimpara

   escreval(" ")
   escreval("============================")
   escreval(" ")

fimse //Fim da consulta aos dados

Fimalgoritmo