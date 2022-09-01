package model.dao;

import model.entity.RegistroAluguelQuarto;
import model.entity.Voo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VooDAO {
    Connection conn = null;
    PreparedStatement pstm = null;

    public int insert(Voo voo) {

        String sql = "INSERT INTO voos(id_cidade,ponto_partida,companhia,num_voo,num_assento,data_partida,data_chegada)" + " VALUES(?,?,?,?,?,?,?)";
        ResultSet rset;
        int id_voo = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, voo.getId_cidade());
            pstm.setString(2, voo.getPonto_partida());
            pstm.setString(3, voo.getCompanhia());
            pstm.setString(4, voo.getNum_voo());
            pstm.setString(5, voo.getNum_assento());
            pstm.setDate(6, new Date(voo.getData_partida().getTime()));
            pstm.setDate(7, new Date(voo.getData_chegada().getTime()));

            pstm.executeUpdate();

            rset = pstm.getGeneratedKeys();
            if (rset.next()) {
                id_voo = rset.getInt(1);
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
        return id_voo;
    }

    public List<Voo> getVoosByData(java.util.Date data_delimitador){
        String sql = "SELECT * FROM voos WHERE data_chegada > ? AND id != ?";
        ResultSet rset = null;
        List<Voo> voos = new ArrayList<>();
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setDate(1,new Date(data_delimitador.getTime()));
            pstm.setInt(2,1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Voo voo = new Voo();
                voo.setId(rset.getInt("id"));
                voo.setId_cidade(rset.getInt("id_cidade"));
                voo.setPonto_partida(rset.getString("ponto_partida"));
                voo.setCompanhia(rset.getString("companhia"));
                voo.setNum_voo(rset.getString("num_voo"));
                voo.setNum_assento(rset.getString("num_assento"));
                voo.setData_partida(rset.getDate("data_chegada"));
                voo.setData_chegada(rset.getDate("data_partida"));
                voos.add(voo);
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

        return voos;
    }

    public List<Voo> getVoosByIdCidade(int id_cidade){
        String sql = "SELECT * FROM voos WHERE id_cidade = ? OR id != ?";
        ResultSet rset = null;
        List<Voo> voos = new ArrayList<>();
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_cidade);
            pstm.setInt(2,1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Voo voo = new Voo();
                voo.setId(rset.getInt("id"));
                voo.setId_cidade(rset.getInt("id_cidade"));
                voo.setPonto_partida(rset.getString("ponto_partida"));
                voo.setCompanhia(rset.getString("companhia"));
                voo.setNum_voo(rset.getString("num_voo"));
                voo.setNum_assento(rset.getString("num_assento"));
                voo.setData_partida(rset.getDate("data_chegada"));
                voo.setData_chegada(rset.getDate("data_partida"));
                voos.add(voo);
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

        return voos;
    }
}
