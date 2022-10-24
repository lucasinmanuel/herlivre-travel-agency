package com.travelagency.herlivre.model;

import javax.persistence.*;

@Entity
@Table
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer numero;
    @ManyToOne
    @JoinColumn(name = "id_hotel",nullable = false)
    private Hotel hotel;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private Integer diaria;
    @Column(nullable = false)
    private Integer qtd_camas;
    @Column(nullable = false)
    private String tipo;

    public Quarto(Long id, Integer numero, Hotel hotel, double valor, Integer diaria, Integer qtd_camas, String tipo) {
        this.id = id;
        this.numero = numero;
        this.hotel = hotel;
        this.valor = valor;
        this.diaria = diaria;
        this.qtd_camas = qtd_camas;
        this.tipo = tipo;
    }

    public Quarto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getDiaria() {
        return diaria;
    }

    public void setDiaria(Integer diaria) {
        this.diaria = diaria;
    }

    public Integer getQtd_camas() {
        return qtd_camas;
    }

    public void setQtd_camas(Integer qtd_camas) {
        this.qtd_camas = qtd_camas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
