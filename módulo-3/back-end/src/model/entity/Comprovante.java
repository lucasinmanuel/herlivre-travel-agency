package model.entity;

import java.util.Date;

public class Comprovante {
    private int id;
    private int id_registroAluguel;
    private int id_usuario;
    private int id_pacote;
    private Date data_compra;

    public Comprovante(int id, int id_registroAluguel, int id_usuario, int id_pacote, Date data_compra) {
        this.id = id;
        this.id_registroAluguel = id_registroAluguel;
        this.id_usuario = id_usuario;
        this.id_pacote = id_usuario;
        this.data_compra = data_compra;
    }

    public Comprovante(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_registroAluguel() {
        return id_registroAluguel;
    }

    public void setId_registroAluguel(int id_registroAluguel) {this.id_registroAluguel = id_registroAluguel;}

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_pacote() {
        return id_pacote;
    }

    public void setId_pacote(int id_pacote) {
        this.id_pacote = id_pacote;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }
}
