package model.entity;

public class Cidade {
    private int id;
    private String nome;
    private String uf;
    private String pais;
    private String continente;

    public Cidade(int id, String nome, String uf, String pais, String continente) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
        this.continente = continente;
    }

    public Cidade(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
