package model.dao;

import model.entity.Quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public int getIdByIdHotelAndNumero(int id_hotel,int numero){

        String sql = "SELECT * FROM quartos WHERE id_hotel = ? AND numero = ?";
        ResultSet rset = null;
        int id_quarto = -1;

        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_hotel);
            pstm.setInt(2, numero);
            rset = pstm.executeQuery();

            if(rset.next()) {
                id_quarto = rset.getInt("id");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha as conexões
            try {
                if(rset != null) {
                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return id_quarto;
    }

    public List<Quarto> getQuartosByIdHotel(int id_hotel){
        String sql = "SELECT * FROM quartos WHERE id_hotel = ?";
        ResultSet rset = null;
        List<Quarto> quartos = new ArrayList<>();

        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_hotel);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Quarto quarto = new Quarto();
                quarto.setNumero(rset.getInt("numero"));
                quarto.setId_hotel(rset.getInt("id_hotel"));
                quarto.setQtd_camas(rset.getInt("qtd_camas"));
                quarto.setValor(rset.getDouble("valor"));
                quarto.setTipo(rset.getString("tipo"));
                quartos.add(quarto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha as conexões
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return quartos;
    }
}
