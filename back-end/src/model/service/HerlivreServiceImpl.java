package model.service;

import model.dao.CidadeDAO;
import model.dao.HotelDAO;
import model.dao.QuartoDAO;
import model.dao.RegistroAluguelDAO;
import model.entity.Cidade;
import model.entity.Hotel;
import model.entity.Quarto;
import model.entity.RegistroAluguel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HerlivreServiceImpl implements IHerlivreService {

    CidadeDAO cidadeDAO = new CidadeDAO();
    HotelDAO hotelDAO = new HotelDAO();
    QuartoDAO quartoDAO = new QuartoDAO();
    RegistroAluguelDAO registroAluguelDAO = new RegistroAluguelDAO();

    public void getCidades() {

        System.out.println("");
        System.out.println("______________ LISTA DE CIDADES ________________");
        for (Cidade c : cidadeDAO.getCidades()) {
            System.out.println("");
            System.out.println("Id: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("UF: " + c.getUf());
        }
        System.out.println("");

    }

    public int getHoteisByNomeCidade(String nome_cidade) {

        int id_cidade = cidadeDAO.getIdByNome(nome_cidade);

        //BUSCAR HOTÉIS COM BASE EM ID_CIDADE
        System.out.println("");
        System.out.printf("____________________ HOTÉIS DE %s ____________________%n", nome_cidade.toUpperCase());

        for (Hotel h : hotelDAO.getHoteisByIdCidade(id_cidade)) {
            System.out.println("");
            System.out.println("Id: " + h.getId());
            System.out.println("Nome: " + h.getNome());
            System.out.println("Estrelas: " + h.getQtd_estrelas());
            System.out.println("Diárias a partir de: " + h.getDiarias_min());
            System.out.println("Wifi: " + h.isWifi());
            System.out.println("Café da Manhã: " + h.isCafe_manha());
            System.out.println("CEP: " + h.getCep());
            System.out.println("Logradouro: " + h.getLogradouro());
            System.out.println("Bairro: " + h.getBairro());

        }
        System.out.println("");

        return id_cidade;

    }

    public int getQuartosByNomeHotel(String nome_hotel) {

        int id_hotel = hotelDAO.getIdByNome(nome_hotel);

        //VER QUARTOS PELO ID DO HOTEL
        System.out.println("");
        System.out.printf("_________________ QUARTOS DO HOTEL %s __________________%n", nome_hotel.toUpperCase());

        for (Quarto q : quartoDAO.getQuartosByIdHotel(id_hotel)) {
            System.out.println("");
            System.out.println("Número: " + q.getNumero());
            System.out.println("Quantidade de camas: " + q.getQtd_camas());
            System.out.println("Preço: " + q.getValor());
            System.out.println("Tipo: " + q.getTipo());
        }
        System.out.println("");

        return id_hotel;
    }

    public boolean verificaStatusQuarto(int id_hotel, int numero,String entrada, String saida) {

        String[] dataEntradaSplit = entrada.split("/");
        String anoEntrada = dataEntradaSplit[2];
        String mesEntrada = dataEntradaSplit[1];
        String diaEntrada = dataEntradaSplit[0];

        String[] dataSaidaSplit = saida.split("/");
        String anoSaida = dataSaidaSplit[2];
        String mesSaida = dataSaidaSplit[1];
        String diaSaida = dataSaidaSplit[0];

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date data_entrada;
        Date data_saida;
        Date data_delimitador;
        try {
            data_entrada = formatter.parse(anoEntrada+"-"+mesEntrada+"-"+diaEntrada);
            data_saida = formatter.parse(anoSaida+"-"+mesSaida+"-"+diaSaida);
            data_delimitador = formatter.parse("9999-12-31");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        boolean status = false;
        if(data_entrada.after(data_saida)){
            System.out.println("");
            System.out.println("==================== ERRO =========================");
            System.out.println("Data de entrada está vindo depois da data de saída");
            System.out.println("==================== ERRO =========================");
            return false;
        }else if (data_entrada.before(new Date())){
            System.out.println("");
            System.out.println("=================== ERRO =====================");
            System.out.println("Data de entrada está vindo antes da data atual");
            System.out.println("=================== ERRO =====================");
            return false;
        }

        int id_quarto = quartoDAO.getIdByIdHotelAndNumero(id_hotel,numero);
        List<RegistroAluguel> alugueis = registroAluguelDAO.getRegAlugueisByIdQuarto(id_quarto);

        //PERCORRER TODAS AS LINHAS DA TABELA
        for (int rowDB = 0; rowDB < alugueis.size(); rowDB++) {

            //VERIFICA SE A NOVA DATA DE ENTRADA ESTÁ DEPOIS DE ALGUMA DATA DE SAIDA DO DATABASE
            if (data_entrada.after(alugueis.get(rowDB).getSaida())) {

                //CONDICIONAL PARA AUMENTAR O ÍNDICE EM +1
                int rowDBNext = rowDB + 1;

                //UTILIZANDO ÍNDICE +1 PARA PEGAR A PRÓXIMA LINHA DA TABELA
                //VERIFICA SE A NOVA DATA DE SAÍDA ESTÁ ANTES DE ALGUMA DATA DE ENTRADA NO DATABASE
                if (data_saida.before(alugueis.get(rowDBNext).getEntrada())) {
                    status = true;
                }

            }else if(alugueis.get(rowDB).getSaida().equals(data_delimitador) && alugueis.size() == 1){
                status = true;
            }

        }
        return status;
    }

}
