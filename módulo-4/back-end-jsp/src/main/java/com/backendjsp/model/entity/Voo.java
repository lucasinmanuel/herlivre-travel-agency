package com.backendjsp.model.entity;

import java.util.Date;

public class Voo {
    private int id;
    private int id_cidade;
    private String ponto_partida;
    private String companhia;
    private String num_voo;
    private String num_assento;
    private int qtd_assentos_disp;
    private Date data_partida;
    private Date data_chegada;

    public Voo(int id, int id_cidade, String ponto_partida, String companhia, String num_voo, String num_assento, int qtd_assentos_disp, Date data_partida, Date data_chegada) {
        this.id = id;
        this.id_cidade = id_cidade;
        this.ponto_partida = ponto_partida;
        this.companhia = companhia;
        this.num_voo = num_voo;
        this.num_assento = num_assento;
        this.qtd_assentos_disp = qtd_assentos_disp;
        this.data_partida = data_partida;
        this.data_chegada = data_chegada;
    }

    public Voo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getPonto_partida() {
        return ponto_partida;
    }

    public void setPonto_partida(String ponto_partida) {
        this.ponto_partida = ponto_partida;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getNum_voo() {
        return num_voo;
    }

    public void setNum_voo(String num_voo) {
        this.num_voo = num_voo;
    }

    public String getNum_assento() {
        return num_assento;
    }

    public void setNum_assento(String num_assento) {
        this.num_assento = num_assento;
    }

    public int getQtd_assentos_disp() {
        return qtd_assentos_disp;
    }

    public void setQtd_assentos_disp(int qtd_assentos_disp) {
        this.qtd_assentos_disp = qtd_assentos_disp;
    }

    public Date getData_partida() {
        return data_partida;
    }

    public void setData_partida(Date data_partida) {
        this.data_partida = data_partida;
    }

    public Date getData_chegada() {
        return data_chegada;
    }

    public void setData_chegada(Date data_chegada) {
        this.data_chegada = data_chegada;
    }
}
