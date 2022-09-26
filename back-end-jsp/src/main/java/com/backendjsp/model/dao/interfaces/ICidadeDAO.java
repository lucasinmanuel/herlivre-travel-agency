package com.backendjsp.model.dao.interfaces;

import com.backendjsp.model.entity.Cidade;

import java.util.List;

public interface ICidadeDAO {
    void insert(Cidade cidade);
    boolean deleteById(int id);
    void updateById(Cidade cidade);
    List<Cidade> getCidades();
    int getIdByNome(String nome_cidade);

    Cidade getCidadeById(int id_cidade);
}
