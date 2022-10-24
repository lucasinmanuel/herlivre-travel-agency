package model.dao.interfaces;

import model.entity.Pacote;

import java.util.List;

public interface IPacoteDAO {
    int insert(Pacote pacote);
    int insertIdsVoo(Pacote pacote);
    boolean deleteById(int id);
    void updateById(Pacote pacote);
    List<Pacote> getPacotes();
    List<Pacote> getPacotesByIdVoo(int id_voo);
}
