package model.dao.interfaces;

import model.entity.Comprovante;
import model.entity.Quarto;

import java.util.List;

public interface IComprovanteDAO {
    int insert(Comprovante comprovante);
    int insertWithPacote(Comprovante comprovante);
    boolean deleteById(int id);
    void updateById(Comprovante comprovante);
    List<Comprovante> getComprovantes();
    Comprovante getComprovanteByid(int id_comprovante);
}
