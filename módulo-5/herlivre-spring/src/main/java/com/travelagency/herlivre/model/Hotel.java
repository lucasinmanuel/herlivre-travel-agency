package com.travelagency.herlivre.model;

import javax.persistence.*;

@Entity
@Table
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cidade",nullable = false)
    private Cidade cidade;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int qtd_estrelas;
    @Column(nullable = false)
    private double valor_min;
    @Column(nullable = false)
    private boolean wifi;
    @Column(nullable = false)
    private boolean cafe_manha;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String bairro;

    public Hotel(Long id, Cidade cidade, String nome, int qtd_estrelas, double valor_min, boolean wifi, boolean cafe_manha, String cep, String logradouro, String bairro) {
        this.id = id;
        this.cidade = cidade;
        this.nome = nome;
        this.qtd_estrelas = qtd_estrelas;
        this.valor_min = valor_min;
        this.wifi = wifi;
        this.cafe_manha = cafe_manha;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    public Hotel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd_estrelas() {
        return qtd_estrelas;
    }

    public void setQtd_estrelas(int qtd_estrelas) {
        this.qtd_estrelas = qtd_estrelas;
    }

    public double getValor_min() {
        return valor_min;
    }

    public void setValor_min(double valor_min) {
        this.valor_min = valor_min;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isCafe_manha() {
        return cafe_manha;
    }

    public void setCafe_manha(boolean cafe_manha) {
        this.cafe_manha = cafe_manha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
