package com.backendjsp.model.dao.interfaces;


import com.backendjsp.model.entity.Quarto;

import java.util.List;

public interface IQuartoDAO {
    int insert(Quarto quarto);

    boolean deleteById(int id);

    void updateById(Quarto quarto);

    List<Quarto> getQuartos();

    int getIdByIdHotelAndNumero(int id_hotel, int numero);

    List<Quarto> getQuartosByIdHotel(int id_hotel);

    Quarto getQuartoById(int id_quarto);
}
