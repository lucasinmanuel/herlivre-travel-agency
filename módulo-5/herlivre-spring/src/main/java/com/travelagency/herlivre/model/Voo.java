package com.travelagency.herlivre.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Voo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cidade",nullable = false)
    private Cidade cidade;
    @Column(nullable = false)
    private String local_partida;
    @Column(nullable = false)
    private String companhia;
    @Column(nullable = false)
    private String num_voo;
    @Column(nullable = false)
    private String num_assento;
    @Column(nullable = false)
    private Integer qtd_assentos_disp;
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data_partida;
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data_chegada;

    public Voo(Long id, Cidade cidade, String local_partida, String companhia, String num_voo, String num_assento, Integer qtd_assentos_disp, LocalDate data_partida, LocalDate data_chegada) {
        this.id = id;
        this.cidade = cidade;
        this.local_partida = local_partida;
        this.companhia = companhia;
        this.num_voo = num_voo;
        this.num_assento = num_assento;
        this.qtd_assentos_disp = qtd_assentos_disp;
        this.data_partida = data_partida;
        this.data_chegada = data_chegada;
    }

    public Voo() {
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

    public String getLocal_partida() {
        return local_partida;
    }

    public void setLocal_partida(String local_partida) {
        this.local_partida = local_partida;
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

    public Integer getQtd_assentos_disp() {
        return qtd_assentos_disp;
    }

    public void setQtd_assentos_disp(Integer qtd_assentos_disp) {
        this.qtd_assentos_disp = qtd_assentos_disp;
    }

    public LocalDate getData_partida() {
        return data_partida;
    }

    public void setData_partida(LocalDate data_partida) {
        this.data_partida = data_partida;
    }

    public LocalDate getData_chegada() {
        return data_chegada;
    }

    public void setData_chegada(LocalDate data_chegada) {
        this.data_chegada = data_chegada;
    }
}
