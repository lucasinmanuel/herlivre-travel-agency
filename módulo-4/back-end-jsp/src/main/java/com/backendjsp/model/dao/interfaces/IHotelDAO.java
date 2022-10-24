package com.backendjsp.model.dao.interfaces;


import com.backendjsp.model.entity.Hotel;

import java.util.List;

public interface IHotelDAO {
    void insert(Hotel hotel);

    boolean deleteById(int id);

    void updateById(Hotel hotel);

    List<Hotel> getHoteis();

    Hotel getHotelById(int id_hotel);

    int getIdByNome(String nome_hotel);

    List<Hotel> getHoteisByIdCidade(int id_cidade);
}
