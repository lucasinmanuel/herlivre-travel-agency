package com.backendjsp.model.entity;

public class RegistroAluguelQuarto {
    private int id;
    private int id_quarto;
    private java.util.Date entrada;
    private java.util.Date saida;

    public RegistroAluguelQuarto(int id, int id_quarto, java.util.Date entrada, java.util.Date saida) {
        this.id = id;
        this.id_quarto = id_quarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public RegistroAluguelQuarto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public java.util.Date getEntrada() {
        return entrada;
    }

    public void setEntrada(java.util.Date entrada) {
        this.entrada = entrada;
    }

    public java.util.Date getSaida() {
        return saida;
    }

    public void setSaida(java.util.Date saida) {
        this.saida = saida;
    }
}
