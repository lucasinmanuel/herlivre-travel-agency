package model.entity;

public class Quarto {
    private int numero;
    private int id_hotel;
    private double valor;
    private int qtd_camas;
    private String tipo;

    public Quarto(int numero, int id_hotel, double valor, int qtd_camas, String tipo) {
        this.numero = numero;
        this.id_hotel = id_hotel;
        this.valor = valor;
        this.qtd_camas = qtd_camas;
        this.tipo = tipo;
    }

    public Quarto(){

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
