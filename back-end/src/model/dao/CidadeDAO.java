package model.dao;
import model.dao.interfaces.ICidadeDAO;
import model.entity.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO implements ICidadeDAO{

    Connection conn = null;
    PreparedStatement pstm = null;

    public void insert(Cidade cidade) {

        String sql = "INSERT INTO cidades(nome,estado)" + " VALUES(?,?)";

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            // Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, cidade.getNome());
            // Adicionar o valor do segundo parâmetro da sql
            pstm.setString(2, cidade.getUf());

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

    public boolean deleteById(int id) {

        String sql = "DELETE FROM cidades WHERE id = ?";
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

    public void updateById(Cidade cidade){

        String sql = "UPDATE cidades SET nome = ?,estado = ? WHERE id = ?";

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cidade.getNome());
            pstm.setString(2, cidade.getUf());
            pstm.setInt(3,cidade.getId());

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

    public List<Cidade> getCidades() {

        String sql = "SELECT * FROM cidades WHERE id != ?";
        ResultSet rset = null;
        List<Cidade> cidades = new ArrayList<>();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 1);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rset.getInt("id"));
                cidade.setNome(rset.getString("nome"));
                cidade.setUf(rset.getString("uf"));
                cidade.setPais(rset.getString("pais"));
                cidade.setContinente(rset.getString("continente"));
                cidades.add(cidade);
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

        return cidades;
    }

    public int getIdByNome(String nome_cidade) {

        String sql = "SELECT * FROM cidades WHERE nome = ?";
        ResultSet rset = null;
        int id_cidade = -1;
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome_cidade);
            rset = pstm.executeQuery();


            if(rset.next()) {
                id_cidade = rset.getInt("id");
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

        return id_cidade;
    }

    public Cidade getCidadeById(int id_cidade) {

        String sql = "SELECT * FROM cidades WHERE id = ?";
        ResultSet rset = null;
        Cidade cidade = new Cidade();
        try {
            // Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_cidade);
            rset = pstm.executeQuery();


            if(rset.next()) {
                cidade.setId(rset.getInt("id"));
                cidade.setNome(rset.getString("nome"));
                cidade.setUf(rset.getString("uf"));
                cidade.setPais(rset.getString("pais"));
                cidade.setContinente(rset.getString("continente"));
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

        return cidade;
    }


}