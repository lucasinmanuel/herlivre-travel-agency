package model.entity;

import java.sql.Date;

public class RegistroAluguel {
    private int id;
    private int id_hotel;
    private int numero_quarto;
    private Date entrada;
    private Date saida;

    public RegistroAluguel(int id, int id_hotel, int numero_quarto, Date entrada, Date saida) {
        this.id = id;
        this.id_hotel = id_hotel;
        this.numero_quarto = numero_quarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public RegistroAluguel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getNumero_quarto() {
        return numero_quarto;
    }

    public void setNumero_quarto(int numero_quarto) {
        this.numero_quarto = numero_quarto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }
}
