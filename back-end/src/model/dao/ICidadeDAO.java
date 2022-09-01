package model.dao;

import model.entity.Cidade;

import java.util.List;

public interface ICidadeDAO {
    void insert(Cidade cidade);
    boolean deleteById(int id);
    void updateById(Cidade cidade);
    List<Cidade> getCidades();
    int getIdByNome(String nome_cidade);
}
