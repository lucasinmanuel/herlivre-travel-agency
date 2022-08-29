package model.dao;

import model.entity.Cidade;
import model.entity.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public void create(Hotel hotel) {

        String sql = "INSERT INTO cidades(id_cidade,nome,qtd_estrelas,diarias_min,wifi,cafe_manhacep,logradouro,bairro)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, hotel.getId());
            pstm.setString(2, hotel.getNome());
            pstm.setInt(3,hotel.getQtd_estrelas());
            pstm.setDouble(4,hotel.getDiarias_min());
            pstm.setBoolean(5, hotel.isWifi());
            pstm.setBoolean(6, hotel.isCafe_manha());
            pstm.setString(7, hotel.getCep());
            pstm.setString(8, hotel.getLogradouro());
            pstm.setString(9, hotel.getBairro());

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

    public int getIdByNome(String nome_hotel){

        String sql = "SELECT * FROM hoteis WHERE nome = ?";
        ResultSet rset = null;
        int id_hotel = -1;
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome_hotel);
            rset = pstm.executeQuery();

            if(rset.next()) {
                id_hotel = rset.getInt("id");
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

        return id_hotel;
    }

    public List<Hotel> getHoteisByIdCidade(int id_cidade) {

        String sql = "SELECT * FROM hoteis WHERE id_cidade = ?";
        ResultSet rset = null;
        List<Hotel> hoteis = new ArrayList<>();

        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_cidade);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(rset.getInt("id"));
                hotel.setId_cidade(rset.getInt("id_cidade"));
                hotel.setNome(rset.getString("nome"));
                hotel.setDiarias_min(rset.getDouble("diarias_min"));
                hotel.setQtd_estrelas(rset.getInt("qtd_estrelas"));
                hotel.setWifi(rset.getBoolean("wifi"));
                hotel.setCafe_manha(rset.getBoolean("cafe_manha"));
                hotel.setCep(rset.getString("cep"));
                hotel.setLogradouro(rset.getString("logradouro"));
                hotel.setBairro(rset.getString("bairro"));
                hoteis.add(hotel);
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

        return hoteis;

    }

}
