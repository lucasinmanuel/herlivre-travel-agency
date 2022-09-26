package com.backendjsp.model.dao.interfaces;

import com.backendjsp.model.entity.RegistroAluguelQuarto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public interface IRegistroAluguelQuartoDAO {
    int insert(RegistroAluguelQuarto registroAluguelQuarto);
    boolean deleteById(int id);
    void updateById(RegistroAluguelQuarto registroAluguelQuarto);
    List<RegistroAluguelQuarto> getRegistroAlugueis();
    RegistroAluguelQuarto getById(int id_registro);
    List<RegistroAluguelQuarto> getRegAlugueisByIdQuarto(int id_quarto);
}
