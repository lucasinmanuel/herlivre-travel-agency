package model.entity;

import java.sql.Date;

public class Aluga {
    private int codigo;
    private int numero_quarto;
    private Date entrada;
    private Date saida;

    public Aluga(int codigo, int numero_quarto, Date entrada, Date saida) {
        this.codigo = codigo;
        this.numero_quarto = numero_quarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Aluga(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
