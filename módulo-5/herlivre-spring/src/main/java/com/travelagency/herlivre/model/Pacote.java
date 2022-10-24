package com.travelagency.herlivre.model;

import javax.persistence.*;

@Entity
@Table
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_voo_1",nullable = false)
    private Voo voo_1;
    @ManyToOne
    @JoinColumn(name = "id_voo_2")
    private Voo voo_2;
    @ManyToOne
    @JoinColumn(name = "id_registro_aluguel_quarto",nullable = false)
    private RegistroAluguelQuarto registroAluguelQuarto;
    @Column(nullable = false)
    private Integer total_pessoas;
    @Column(nullable = false)
    private double valor_original;
    @Column(nullable = false)
    private Integer desconto;
    @Column(nullable = false)
    private double valor_promocional;

    public Pacote(Long id, Voo voo_1, Voo voo_2, RegistroAluguelQuarto registroAluguelQuarto, Integer total_pessoas, double valor_original, Integer desconto, Integer valor_promocional) {
        this.id = id;
        this.voo_1 = voo_1;
        this.voo_2 = voo_2;
        this.registroAluguelQuarto = registroAluguelQuarto;
        this.total_pessoas = total_pessoas;
        this.valor_original = valor_original;
        this.desconto = desconto;
        this.valor_promocional = valor_promocional;
    }

    public Pacote() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Voo getVoo_1() {
        return voo_1;
    }

    public void setVoo_1(Voo voo_1) {
        this.voo_1 = voo_1;
    }

    public Voo getVoo_2() {
        return voo_2;
    }

    public void setVoo_2(Voo voo_2) {
        this.voo_2 = voo_2;
    }

    public RegistroAluguelQuarto getRegistroAluguelQuarto() {
        return registroAluguelQuarto;
    }

    public void setRegistroAluguelQuarto(RegistroAluguelQuarto registroAluguelQuarto) {
        this.registroAluguelQuarto = registroAluguelQuarto;
    }

    public Integer getTotal_pessoas() {
        return total_pessoas;
    }

    public void setTotal_pessoas(Integer total_pessoas) {
        this.total_pessoas = total_pessoas;
    }

    public double getValor_original() {
        return valor_original;
    }

    public void setValor_original(double valor_original) {
        this.valor_original = valor_original;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }

    public double getValor_promocional() {
        return valor_promocional;
    }

    public void setValor_promocional(double valor_promocional) {
        this.valor_promocional = valor_promocional;
    }
}
