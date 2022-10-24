package com.backendjsp.model.dao;


import com.backendjsp.model.dao.interfaces.IPacoteDAO;
import com.backendjsp.model.entity.Pacote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO implements IPacoteDAO {
    Connection conn = null;
    PreparedStatement pstm = null;
    public int insert(Pacote pacote) {

        String sql;
        if(pacote.getId_voo2() != 0){
            sql = "INSERT INTO pacotes(id_voo,id_voo2,id_registroaluguelquarto,total_pessoas,valor_original,desconto,valor_promocional)" +
                    " VALUES(?,?,?,?,?,?,?)";
        }else{
            sql = "INSERT INTO pacotes(id_voo,id_registroaluguelquarto,total_pessoas,valor_original,desconto,valor_promocional)" +
                    " VALUES(?,?,?,?,?,?)";
        }

        ResultSet rset;
        int id_pacote = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, pacote.getId_voo());
            if(pacote.getId_voo2() != 0){
                pstm.setInt(2, pacote.getId_voo2());
                pstm.setInt(3, pacote.getId_registroaluguelquarto());
                pstm.setInt(4, pacote.getTotal_pessoas());
                pstm.setDouble(5, pacote.getValor_original());
                pstm.setInt(6, pacote.getDesconto());
                pstm.setDouble(7, pacote.getValor_promocional());
            }else{
                pstm.setInt(2, pacote.getId_registroaluguelquarto());
                pstm.setInt(3, pacote.getTotal_pessoas());
                pstm.setDouble(4, pacote.getValor_original());
                pstm.setInt(5, pacote.getDesconto());
                pstm.setDouble(6, pacote.getValor_promocional());
            }

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

    public boolean deleteById(int id) {

        String sql = "DELETE FROM pacotes WHERE id = ?";
        boolean result = false;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
            result = true;

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
        return result;
    }

    public void updateById(Pacote pacote){

        String id_voo2 = "NULL";
        if(pacote.getId_voo2() != 0){
            id_voo2 = "?";
        }
        String sql = "UPDATE pacotes SET id_voo = ?,id_voo2 = "+id_voo2+",id_registroaluguelquarto = ?,total_pessoas = ?,valor_original = ?,desconto = ?,valor_promocional = ? WHERE id = ?";
        int i = 1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(i, pacote.getId_voo());
            if(pacote.getId_voo2() != 0){
                i = i + 1;
                pstm.setInt(i, pacote.getId_voo2());
            }
            i = i + 1;
            pstm.setInt(i, pacote.getId_registroaluguelquarto());
            i = i + 1;
            pstm.setInt(i, pacote.getTotal_pessoas());
            i = i + 1;
            pstm.setDouble(i, pacote.getValor_original());
            i = i + 1;
            pstm.setInt(i, pacote.getDesconto());
            i = i + 1;
            pstm.setDouble(i, pacote.getValor_promocional());
            i = i + 1;
            pstm.setInt(i,pacote.getId());

            // Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha as conexões
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
            i = 1;
        }

    }

    public List<Pacote> getPacotes() {
        String sql = "SELECT * FROM pacotes WHERE id != ?";
        ResultSet rset = null;
        List<Pacote> pacotes = new ArrayList<>();
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Pacote pacote = new Pacote();
                pacote.setId(rset.getInt("id"));
                pacote.setId_voo(rset.getInt("id_voo"));
                pacote.setId_voo2(rset.getInt("id_voo2"));
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
                pacote.setId_voo2(rset.getInt("id_voo2"));
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

    public Pacote getPacotesById(int id_voo) {
        String sql = "SELECT * FROM pacotes WHERE id = ? AND id != ?";
        ResultSet rset = null;
        Pacote pacote = new Pacote();
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_voo);
            pstm.setInt(2, 1);
            rset = pstm.executeQuery();

            if (rset.next()) {
                pacote.setId(rset.getInt("id"));
                pacote.setId_voo(rset.getInt("id_voo"));
                pacote.setId_voo2(rset.getInt("id_voo2"));
                pacote.setId_registroaluguelquarto(rset.getInt("id_registroaluguelquarto"));
                pacote.setTotal_pessoas(rset.getInt("total_pessoas"));
                pacote.setValor_original(rset.getDouble("valor_original"));
                pacote.setDesconto(rset.getInt("desconto"));
                pacote.setValor_promocional(rset.getDouble("valor_promocional"));
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

        return pacote;
    }

}
