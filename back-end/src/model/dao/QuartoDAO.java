package model.dao;

import model.dao.interfaces.IQuartoDAO;
import model.entity.Pacote;
import model.entity.Quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO implements IQuartoDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

//    public int insertIdsVoo(Quarto quarto) {
//
//        String sql = "INSERT INTO pacotes(id_voo,id_voo2,id_registroaluguelquarto,total_pessoas,valor_original,desconto,valor_promocional)" + " VALUES(?,?,?,?,?,?,?)";
//        ResultSet rset;
//        int id_pacote = -1;
//        try {
//
//            conn = ConnectionFactory.createConnectionToMySQL();
//
//            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//            pstm.setInt(1, quarto.getId_voo());
//            pstm.setInt(2, quarto.getId_voo2());
//            pstm.setInt(3, quarto.getId_registroaluguelquarto());
//            pstm.setInt(4, quarto.getTotal_pessoas());
//            pstm.setDouble(5, quarto.getValor_original());
//            pstm.setInt(6, quarto.getDesconto());
//            pstm.setDouble(7, quarto.getValor_promocional());
//
//            pstm.executeUpdate();
//
//            rset = pstm.getGeneratedKeys();
//            if (rset.next()) {
//                id_pacote = rset.getInt(1);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            try {
//                if (pstm != null) {
//
//                    pstm.close();
//                }
//
//                if (conn != null) {
//                    conn.close();
//                }
//
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//        }
//        return id_pacote;
//    }

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
        String sql = "SELECT * FROM quartos WHERE id_hotel = ? AND id != ?";
        ResultSet rset = null;
        List<Quarto> quartos = new ArrayList<>();

        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_hotel);
            pstm.setInt(2, 1);
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

    public Quarto getQuartoById(int id_quarto){
        String sql = "SELECT * FROM quartos WHERE id = ? OR id != ?";
        ResultSet rset = null;
        Quarto quarto = new Quarto();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_quarto);
            pstm.setInt(2, 1);
            rset = pstm.executeQuery();

            if (rset.next()) {
                quarto.setNumero(rset.getInt("numero"));
                quarto.setId_hotel(rset.getInt("id_hotel"));
                quarto.setQtd_camas(rset.getInt("qtd_camas"));
                quarto.setValor(rset.getDouble("valor"));
                quarto.setTipo(rset.getString("tipo"));
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

        return quarto;
    }
}
