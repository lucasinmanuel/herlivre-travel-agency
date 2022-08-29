package model.dao;

import model.entity.RegistroAluguel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroAluguelDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public List<RegistroAluguel> getRegAlugueisByIdQuarto(int id_quarto){
        String sql = "SELECT * FROM registroAlugueis WHERE id_quarto = ? OR entrada = ? ORDER BY entrada";
        ResultSet rset = null;
        List<RegistroAluguel> alugueis = new ArrayList<>();

        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_quarto);
            pstm.setDate(2, new Date(Date.valueOf("9999-12-31").getTime()));
            rset = pstm.executeQuery();

            while (rset.next()) {
                RegistroAluguel aluguel = new RegistroAluguel();
                aluguel.setId(rset.getInt("id"));
                aluguel.setNumero_quarto(rset.getInt("id_quarto"));
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
