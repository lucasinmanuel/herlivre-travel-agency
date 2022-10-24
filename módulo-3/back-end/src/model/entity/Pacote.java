package model.entity;

public class Pacote {
    private int id;
    private int id_voo;
    private int id_voo2;
    private int id_registroaluguelquarto;
    private int total_pessoas;
    private double valor_original;
    private int desconto;
    private double valor_promocional;

    public Pacote(int id, int id_voo, int id_voo2, int id_registroaluguelquarto, int total_pessoas, double valor_original, int desconto, double valor_promocional) {
        this.id = id;
        this.id_voo = id_voo;
        this.id_voo2 = id_voo2;
        this.id_registroaluguelquarto = id_registroaluguelquarto;
        this.total_pessoas = total_pessoas;
        this.valor_original = valor_original;
        this.desconto = desconto;
        this.valor_promocional = valor_promocional;
    }

    public Pacote() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_voo() {
        return id_voo;
    }

    public void setId_voo(int id_voo) {
        this.id_voo = id_voo;
    }

    public int getId_voo2() {
        return id_voo2;
    }

    public void setId_voo2(int id_voo2) {
        this.id_voo2 = id_voo2;
    }

    public int getId_registroaluguelquarto() {
        return id_registroaluguelquarto;
    }

    public void setId_registroaluguelquarto(int id_registroaluguelquarto) {
        this.id_registroaluguelquarto = id_registroaluguelquarto;
    }

    public int getTotal_pessoas() {
        return total_pessoas;
    }

    public void setTotal_pessoas(int total_pessoas) {
        this.total_pessoas = total_pessoas;
    }

    public double getValor_original() {
        return valor_original;
    }

    public void setValor_original(double valor_original) {
        this.valor_original = valor_original;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public double getValor_promocional() {
        return valor_promocional;
    }

    public void setValor_promocional(double valor_promocional) {
        this.valor_promocional = valor_promocional;
    }
}
