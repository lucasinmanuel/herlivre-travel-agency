package model.dao;

import model.entity.RegistroAluguelQuarto;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RegistroAluguelQuartoDAO implements IRegistroAluguelQuartoDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public int insert(RegistroAluguelQuarto registroAluguelQuarto) {

        String sql = "INSERT INTO registroAluguelQuarto(id_quarto,entrada,saida)" + " VALUES(?,?,?)";
        ResultSet rset;
        int id_registroAluguel = -1;
        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, registroAluguelQuarto.getId_quarto());
            pstm.setDate(2, new Date(registroAluguelQuarto.getEntrada().getTime()));
            pstm.setDate(3, new Date(registroAluguelQuarto.getSaida().getTime()));

            pstm.executeUpdate();

            rset = pstm.getGeneratedKeys();
            if (rset.next()) {
                id_registroAluguel = rset.getInt(1);
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
        return id_registroAluguel;
    }

    public boolean deleteById(int id) {

        String sql = "DELETE FROM registroAluguelQuarto WHERE id = ?";
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

    public void updateById(RegistroAluguelQuarto registroAluguelQuarto) {

        String sql = "UPDATE registroAluguelQuarto SET id_quarto = ?,entrada = ?,saida = ? WHERE id = ?";

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, registroAluguelQuarto.getId_quarto());
            pstm.setDate(2, new Date(registroAluguelQuarto.getEntrada().getTime()));
            pstm.setDate(3, new Date(registroAluguelQuarto.getSaida().getTime()));
            pstm.setInt(4, registroAluguelQuarto.getId());

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

    public List<RegistroAluguelQuarto> getRegistroAlugueis() {

        String sql = "SELECT * FROM registroAluguelQuarto where id != ?";
        ResultSet rset = null;
        List<RegistroAluguelQuarto> registroAlugueis = new ArrayList<>();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                RegistroAluguelQuarto registroAluguelQuarto = new RegistroAluguelQuarto();
                registroAluguelQuarto.setId(rset.getInt("id"));
                registroAluguelQuarto.setId_quarto(rset.getInt("id_quarto"));
                registroAluguelQuarto.setEntrada(rset.getDate("entrada"));
                registroAluguelQuarto.setSaida(rset.getDate("saida"));
                registroAlugueis.add(registroAluguelQuarto);
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

        return registroAlugueis;
    }

    public RegistroAluguelQuarto getIdQuartoByIdRegistro(int id_registro) {
        String sql = "SELECT * FROM registroAluguelQuarto WHERE id_registro = ? OR entrada = ? ORDER BY entrada";
        ResultSet rset = null;
        RegistroAluguelQuarto registroAluguelQuarto = new RegistroAluguelQuarto();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_registro);
            pstm.setDate(2, new Date(Date.valueOf("9999-12-31").getTime()));
            rset = pstm.executeQuery();

            if (rset.next()) {
                registroAluguelQuarto.setId(rset.getInt("id"));
                registroAluguelQuarto.setId_quarto(rset.getInt("id_quarto"));
                registroAluguelQuarto.setEntrada(rset.getDate("entrada"));
                registroAluguelQuarto.setSaida(rset.getDate("saida"));
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

        return registroAluguelQuarto;
    }

    public List<RegistroAluguelQuarto> getRegAlugueisByIdQuarto(int id_quarto) {
        String sql = "SELECT * FROM registroAluguelQuarto WHERE id_quarto = ? OR entrada = ? ORDER BY entrada";
        ResultSet rset = null;
        List<RegistroAluguelQuarto> alugueis = new ArrayList<>();

        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_quarto);
            pstm.setDate(2, new Date(Date.valueOf("9999-12-31").getTime()));
            rset = pstm.executeQuery();

            while (rset.next()) {
                RegistroAluguelQuarto aluguel = new RegistroAluguelQuarto();
                aluguel.setId(rset.getInt("id"));
                aluguel.setId_quarto(rset.getInt("id_quarto"));
                aluguel.setEntrada(rset.getDate("entrada"));
                aluguel.setSaida(rset.getDate("saida"));
                alugueis.add(aluguel);
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

        return alugueis;
    }

}
