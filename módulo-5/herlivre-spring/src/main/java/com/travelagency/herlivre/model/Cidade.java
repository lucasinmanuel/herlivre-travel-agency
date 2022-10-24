package com.travelagency.herlivre.model;

import javax.persistence.*;

@Entity
@Table
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,length = 2)
    private String uf;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String continente;

    public Cidade(Long id, String nome, String uf, String pais, String continente) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
        this.continente = continente;
    }

    public Cidade(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
