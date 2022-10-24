package com.backendjsp.model.entity;

public class Quarto {

    private int id;
    private int numero;
    private int id_hotel;
    private double valor;
    private int diaria;
    private int qtd_camas;
    private String tipo;

    public Quarto(int id,int numero, int id_hotel, double valor, int qtd_camas, int diaria,String tipo) {
        this.id = id;
        this.numero = numero;
        this.id_hotel = id_hotel;
        this.valor = valor;
        this.diaria = diaria;
        this.qtd_camas = qtd_camas;
        this.tipo = tipo;
    }

    public Quarto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDiaria() {
        return diaria;
    }

    public void setDiaria(int diaria) {
        this.diaria = diaria;
    }

    public int getQtd_camas() {
        return qtd_camas;
    }

    public void setQtd_camas(int qtd_camas) {
        this.qtd_camas = qtd_camas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
