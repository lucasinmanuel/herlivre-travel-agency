package com.backendjsp.model.dao.interfaces;


import com.backendjsp.model.entity.Voo;

import java.util.List;

public interface IVooDAO {
    int insert(Voo voo);
    boolean deleteById(int id);
    void updateById(Voo voo);
    List<Voo> getVoos();
    List<Voo> getVoosByData(java.util.Date data_delimitador);
    List<Voo> getVoosByIdCidade(int id_cidade);
    List<Voo> getVoosByIdCidadeAndPontoPartida(int id_cidade,String ponto_partida);
}
