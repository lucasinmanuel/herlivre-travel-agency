package model.dao;

import model.dao.interfaces.IComprovanteDAO;
import model.entity.Cidade;
import model.entity.Comprovante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComprovanteDAO implements IComprovanteDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public int insert(Comprovante comprovante) {

        String sql = "INSERT INTO comprovantes(id_registroaluguelquarto,id_usuario,data_compra)" + " VALUES(?,?,?)";
        ResultSet rset;
        int id_comprovante = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, comprovante.getId_registroAluguel());
            pstm.setInt(2, comprovante.getId_usuario());
            pstm.setDate(3, new Date(comprovante.getData_compra().getTime()));

            pstm.executeUpdate();

            rset = pstm.getGeneratedKeys();
            if(rset.next()){
                id_comprovante = rset.getInt(1);
            }

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
        }
        return id_comprovante;
    }

    public int insertWithPacote(Comprovante comprovante) {

        String sql = "INSERT INTO comprovantes(id_registroaluguelquarto,id_usuario,id_pacote,data_compra)" + " VALUES(?,?,?,?)";
        ResultSet rset;
        int id_comprovante = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, comprovante.getId_registroAluguel());
            pstm.setInt(2, comprovante.getId_usuario());
            pstm.setInt(3, comprovante.getId_pacote());
            pstm.setDate(4, new Date(comprovante.getData_compra().getTime()));

            pstm.executeUpdate();

            rset = pstm.getGeneratedKeys();
            if(rset.next()){
                id_comprovante = rset.getInt(1);
            }

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
        }
        return id_comprovante;
    }

    public boolean deleteById(int id) {

        String sql = "DELETE FROM comprovantes WHERE id = ?";
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

    public void updateById(Comprovante comprovante){

        String sql = "UPDATE comprovantes SET id_registroaluguelquarto = ?,id_usuario = ?,id_pacote = ?,data_compra = ? WHERE id = ?";

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, comprovante.getId_registroAluguel());
            pstm.setInt(2, comprovante.getId_usuario());
            pstm.setInt(3, comprovante.getId_pacote());
            pstm.setDate(4, new Date(comprovante.getData_compra().getTime()));
            pstm.setInt(5, comprovante.getId());

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
        }

    }

    public List<Comprovante> getComprovantes() {

        String sql = "SELECT * FROM comprovantes WHERE id != ?";
        ResultSet rset = null;
        List<Comprovante> comprovantes = new ArrayList<>();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Comprovante comprovante = new Comprovante();
                comprovante.setId(rset.getInt("id"));
                comprovante.setId_registroAluguel(rset.getInt("id_registroaluguelquarto"));
                comprovante.setId_usuario(rset.getInt("id_usuario"));
                comprovante.setId_pacote(rset.getInt("id_pacote"));
                comprovante.setData_compra(rset.getDate("data_compra"));
                comprovantes.add(comprovante);
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

        return comprovantes;
    }

    public Comprovante getComprovanteByid(int id_comprovante){

        String sql = "SELECT * FROM comprovantes WHERE id = ?";
        ResultSet rset = null;
        Comprovante comprovante = new Comprovante();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_comprovante);
            rset = pstm.executeQuery();

            if(rset.next()) {
                comprovante.setId(rset.getInt("id"));
                comprovante.setId_registroAluguel(rset.getInt("id_registroaluguelquarto"));
                comprovante.setId_usuario(rset.getInt("id_usuario"));
                comprovante.setId_pacote(rset.getInt("id_pacote"));
                comprovante.setData_compra(rset.getDate("data_compra"));
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

        return comprovante;
    }
}
