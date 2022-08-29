package model.entity;

public class Hotel {
    private int id;
    private int id_cidade;
    private String nome;
    private int qtd_estrelas;
    private double diarias_min;
    private boolean wifi;
    private boolean cafe_manha;
    private String cep;
    private String logradouro;
    private String bairro;

    public Hotel(int id, int id_cidade, String nome, int qtd_estrelas, double diarias_min, boolean wifi, boolean cafe_manha, String cep, String logradouro, String bairro) {
        this.id = id;
        this.id_cidade = id_cidade;
        this.nome = nome;
        this.qtd_estrelas = qtd_estrelas;
        this.diarias_min = diarias_min;
        this.wifi = wifi;
        this.cafe_manha = cafe_manha;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    public Hotel(){

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

    public double getDiarias_min() {
        return diarias_min;
    }

    public void setDiarias_min(double diarias_min) {
        this.diarias_min = diarias_min;
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
