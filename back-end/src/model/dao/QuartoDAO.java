package model.dao;

import model.dao.interfaces.IQuartoDAO;
import model.entity.Cidade;
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

    public int insert(Quarto quarto) {

        String sql = "INSERT INTO quartos(id_hotel,numero,valor,diaria,qtd_camas,tipo)" + " VALUES(?,?,?,?,?,?)";
        ResultSet rset;
        int id_quarto = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, quarto.getId_hotel());
            pstm.setInt(2, quarto.getNumero());
            pstm.setDouble(3, quarto.getValor());
            pstm.setInt(4, quarto.getDiaria());
            pstm.setDouble(5, quarto.getQtd_camas());
            pstm.setString(6, quarto.getTipo());

            pstm.executeUpdate();

            rset = pstm.getGeneratedKeys();
            if (rset.next()) {
                id_quarto = rset.getInt(1);
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
        return id_quarto;
    }

    public boolean deleteById(int id) {

        String sql = "DELETE FROM quartos WHERE id = ?";
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

    public void updateById(Quarto quarto){

        String sql = "UPDATE quartos SET id_hotel = ?,numero = ?,valor = ?,diaria = ?,qtd_camas = ?,tipo = ? WHERE id = ?";

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, quarto.getId_hotel());
            pstm.setInt(2, quarto.getNumero());
            pstm.setDouble(3, quarto.getValor());
            pstm.setInt(4, quarto.getDiaria());
            pstm.setDouble(5, quarto.getQtd_camas());
            pstm.setString(6, quarto.getTipo());
            pstm.setInt(7, quarto.getId());

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

    public List<Quarto> getQuartos() {

        String sql = "SELECT * FROM quartos WHERE id != ?";
        ResultSet rset = null;
        List<Quarto> quartos = new ArrayList<>();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(rset.getInt("id"));
                quarto.setNumero(rset.getInt("numero"));
                quarto.setId_hotel(rset.getInt("id_hotel"));
                quarto.setValor(rset.getDouble("valor"));
                quarto.setDiaria(rset.getInt("diaria"));
                quarto.setQtd_camas(rset.getInt("qtd_camas"));
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
