package model.service;

import java.util.Date;
import java.util.List;

public interface IHerlivreService {

    int login(String email, String password);
    void signUp(String nome,String cpf, String email, String password);
    void getCidades();
    int getHoteisByNomeCidade(String nome_cidade);
    int getQuartosByNomeHotel(String nome_hotel);
    int verificaStatusQuarto(int id_hotel, int numero,String entrada, String saida);
    int realizarRegistroAluguel(int id_quarto,int id_usuario,String entrada,String saida);
    List<Date> converteFormatoData(String entrada, String saida);

}
