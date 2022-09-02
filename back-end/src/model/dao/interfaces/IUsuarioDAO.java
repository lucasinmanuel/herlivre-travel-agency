package model.dao.interfaces;

import model.entity.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    void insert(Usuario usuario);
    boolean deleteById(int id);
    void updateById(Usuario usuario);
    List<Usuario> getUsuarios();
}
