package com.travelagency.herlivre.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Comprovante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_registro_aluguel_quarto",nullable = false)
    private RegistroAluguelQuarto registroAluguelQuarto;
    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_pacote")
    private Pacote pacote;
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data_compra;

    public Comprovante(Long id, RegistroAluguelQuarto registroAluguelQuarto, Usuario usuario, Pacote pacote, LocalDate data_compra) {
        this.id = id;
        this.registroAluguelQuarto = registroAluguelQuarto;
        this.usuario = usuario;
        this.pacote = pacote;
        this.data_compra = data_compra;
    }

    public Comprovante(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegistroAluguelQuarto getRegistroAluguelQuarto() {
        return registroAluguelQuarto;
    }

    public void setRegistroAluguelQuarto(RegistroAluguelQuarto registroAluguelQuarto) {
        this.registroAluguelQuarto = registroAluguelQuarto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public LocalDate getData_compra() {
        return data_compra;
    }

    public void setData_compra(LocalDate data_compra) {
        this.data_compra = data_compra;
    }
}
