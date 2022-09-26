package com.backendjsp.model.dao.interfaces;

import com.backendjsp.model.entity.Comprovante;

import java.util.List;

public interface IComprovanteDAO {
    int insert(Comprovante comprovante);
    int insertWithPacote(Comprovante comprovante);
    boolean deleteById(int id);
    void updateById(Comprovante comprovante);
    List<Comprovante> getComprovantes();
    Comprovante getComprovanteById(int id_comprovante);
}
