package com.travelagency.herlivre.model;

import javax.persistence.*;

@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false,name = "id_cargo")
    private Cargo cargo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String cpf;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    public Usuario(Long id, Cargo cargo, String nome, String cpf, String email, String password) {
        this.id = id;
        this.cargo = cargo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
