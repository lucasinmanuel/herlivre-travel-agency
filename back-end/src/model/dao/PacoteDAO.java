package model.dao;

import model.entity.Pacote;
import model.entity.Voo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO {
    Connection conn = null;
    PreparedStatement pstm = null;

    public int insert(Pacote pacote) {

        String sql = "INSERT INTO pacotes(id_voo,id_registroaluguelquarto,total_pessoas,valor_original,desconto,valor_promocional)" + " VALUES(?,?,?,?,?,?)";
        ResultSet rset;
        int id_pacote = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, pacote.getId_voo());
            pstm.setInt(2, pacote.getId_registroaluguelquarto());
            pstm.setInt(3, pacote.getTotal_pessoas());
            pstm.setDouble(4, pacote.getValor_original());
            pstm.setInt(5, pacote.getDesconto());
            pstm.setDouble(6, pacote.getValor_promocional());

            pstm.executeUpdate();

            rset = pstm.getGeneratedKeys();
            if (rset.next()) {
                id_pacote = rset.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
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
        return id_pacote;
    }

    public int insertIdsVoo(Pacote pacote) {

        String sql = "INSERT INTO pacotes(id_voo,id_voo2,id_registroaluguelquarto,total_pessoas,valor_original,desconto,valor_promocional)" + " VALUES(?,?,?,?,?,?,?)";
        ResultSet rset;
        int id_pacote = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, pacote.getId_voo());
            pstm.setInt(2, pacote.getId_voo2());
            pstm.setInt(3, pacote.getId_registroaluguelquarto());
            pstm.setInt(4, pacote.getTotal_pessoas());
            pstm.setDouble(5, pacote.getValor_original());
            pstm.setInt(6, pacote.getDesconto());
            pstm.setDouble(7, pacote.getValor_promocional());

            pstm.executeUpdate();

            rset = pstm.getGeneratedKeys();
            if (rset.next()) {
                id_pacote = rset.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
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
        return id_pacote;
    }


    public List<Pacote> getPacotesByIdVoo(int id_voo) {
        String sql = "SELECT * FROM pacotes WHERE id_voo = ? AND id != ?";
        ResultSet rset = null;
        List<Pacote> pacotes = new ArrayList<>();
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_voo);
            pstm.setInt(2, 1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Pacote pacote = new Pacote();
                pacote.setId(rset.getInt("id"));
                pacote.setId_voo(rset.getInt("id_voo"));
                pacote.setId_registroaluguelquarto(rset.getInt("id_registroaluguelquarto"));
                pacote.setTotal_pessoas(rset.getInt("total_pessoas"));
                pacote.setValor_original(rset.getDouble("valor_original"));
                pacote.setDesconto(rset.getInt("desconto"));
                pacote.setValor_promocional(rset.getDouble("valor_promocional"));
                pacotes.add(pacote);
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

        return pacotes;
    }

}
