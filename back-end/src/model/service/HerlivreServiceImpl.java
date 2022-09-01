package model.service;

import model.dao.*;
import model.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HerlivreServiceImpl implements IHerlivreService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final CidadeDAO cidadeDAO = new CidadeDAO();
    private final HotelDAO hotelDAO = new HotelDAO();
    private final QuartoDAO quartoDAO = new QuartoDAO();
    private final RegistroAluguelQuartoDAO registroAluguelQuartoDAO = new RegistroAluguelQuartoDAO();
    private final ComprovanteDAO comprovanteDAO = new ComprovanteDAO();
    private final VooDAO vooDAO = new VooDAO();
    private final PacoteDAO pacoteDAO = new PacoteDAO();

    public int login(String email, String password) {
        int id_usuario = -1;
        for (Usuario user : usuarioDAO.getUsuarios()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                id_usuario = user.getId();
            }
        }
        return id_usuario;
    }

    public void signUp(String nome, String cpf, String email, String password) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuarioDAO.insert(usuario);
    }

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
            System.out.println("Diárias a partir de: " + h.getValor_min());
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

    public int verificaStatusQuarto(int id_hotel, int numero, String entrada, String saida) {
        List<Date> datas = this.converteFormatoData(entrada, saida);
        Date data_entrada = datas.get(0);
        Date data_saida = datas.get(1);
        Date data_delimitador = datas.get(2);

        if (data_entrada.after(data_saida)) {
            return -2;
        } else if (data_entrada.before(new Date())) {
            return -3;
        }
        int id_quarto = quartoDAO.getIdByIdHotelAndNumero(id_hotel, numero);
        int idBackup = id_quarto;
        List<RegistroAluguelQuarto> alugueis = registroAluguelQuartoDAO.getRegAlugueisByIdQuarto(id_quarto);
        id_quarto = -1;
        //PERCORRER TODAS AS LINHAS DA TABELA
        for (int rowDB = 0; rowDB < alugueis.size(); rowDB++) {

            //VERIFICA SE A NOVA DATA DE ENTRADA ESTÁ DEPOIS DE ALGUMA DATA DE SAIDA DO DATABASE
            if (data_entrada.after(alugueis.get(rowDB).getSaida())) {

                //CONDICIONAL PARA AUMENTAR O ÍNDICE EM +1
                int rowDBNext = rowDB + 1;

                //UTILIZANDO ÍNDICE +1 PARA PEGAR A PRÓXIMA LINHA DA TABELA
                //VERIFICA SE A NOVA DATA DE SAÍDA ESTÁ ANTES DE ALGUMA DATA DE ENTRADA NO DATABASE
                if (data_saida.before(alugueis.get(rowDBNext).getEntrada())) {
                    id_quarto = idBackup;
                }

            } else if (alugueis.get(rowDB).getSaida().equals(data_delimitador) && alugueis.size() == 1) {
                id_quarto = idBackup;
            }

        }
        return id_quarto;
    }

    public int realizarRegistroAluguel(int id_quarto, int id_usuario, String entrada, String saida) {

        List<Date> datas = this.converteFormatoData(entrada, saida);
        Date data_entrada = datas.get(0);
        Date data_saida = datas.get(1);

        RegistroAluguelQuarto registroAluguelQuarto = new RegistroAluguelQuarto();
        registroAluguelQuarto.setId_quarto(id_quarto);
        registroAluguelQuarto.setEntrada(data_entrada);
        registroAluguelQuarto.setSaida(data_saida);

        int id_registroAluguel = registroAluguelQuartoDAO.insert(registroAluguelQuarto);

        if (id_usuario != 1) {
            Comprovante comprovante = new Comprovante();
            comprovante.setId_registroAluguel(id_registroAluguel);
            comprovante.setId_usuario(id_usuario);
            comprovante.setData_compra(new Date());

            int id_comprovante = comprovanteDAO.insert(comprovante);
            Comprovante comprovanteRegistrado = comprovanteDAO.getComprovanteByid(id_comprovante);
            System.out.println("");
            System.out.println("======== Comprovante =========");
            System.out.println("Id: " + comprovanteRegistrado.getId());
            System.out.println("Id de registro do aluguel: " + comprovanteRegistrado.getId_registroAluguel());
            System.out.println("Id do comprador: " + comprovanteRegistrado.getId_usuario());
            System.out.println("Data da compra: " + comprovanteRegistrado.getData_compra());
            System.out.println("============ FIM =============");
        }

        return id_registroAluguel;

    }

    public void getPacotes() {

        System.out.println("");
        System.out.println("______________ LISTA DE CIDADES ________________");
        for (Cidade c : cidadeDAO.getCidades()) {

            for (Voo v : vooDAO.getVoosByIdCidade(c.getId())) {

                for (Pacote p : pacoteDAO.getPacotesByIdVoo(v.getId())) {
                    RegistroAluguelQuarto registro = registroAluguelQuartoDAO.getIdQuartoByIdRegistro(p.getId_registroaluguelquarto());
                    Quarto quarto = quartoDAO.getQuartoById(registro.getId_quarto());
                    Hotel hotel = hotelDAO.getHotelById(quarto.getId_hotel());

                    System.out.println("");
                    System.out.println("Id: " + p.getId());
                    //HOTEL
                    System.out.println("Nome do hotel: " + hotel.getNome());
                    System.out.println("Estrelas: " + hotel.getQtd_estrelas());
                    System.out.println("Café da manhã: " + hotel.isCafe_manha());
                    System.out.println("Wifi: " + hotel.isWifi());
                    //QUARTO
                    System.out.println("Quantidade de camas: " + quarto.getQtd_camas());
                    System.out.println("Tipo do quarto: " + quarto.getTipo());
                    //REGISTRO DO QUARTO
                    System.out.println("Data de entrada: " + registro.getEntrada());
                    System.out.println("Data de saída: " + registro.getSaida());
                    //CIDADE
                    System.out.println("Nome da cidade: " + c.getNome());
                    System.out.println("Estado: " + c.getUf());
                    System.out.println("País: " + c.getPais());
                    System.out.println("Destino: " + c.getNome().toLowerCase());
                    //PACOTE
                    System.out.println("Desconto: " + p.getDesconto());
                    System.out.println("Valor: " + p.getValor_original());
                    System.out.println("Valor promocional: " + p.getValor_promocional());
                    System.out.println("Total de pessoas: " + p.getTotal_pessoas());
                }

            }

        }
        System.out.println("");
    }

    public void getPacotesByNomeCidadeAndDestino(String nome_destino, String ponto_partida) {

        int id_cidade = cidadeDAO.getIdByNome(nome_destino);

        System.out.println("");
        System.out.println("______________ LISTA DE PACOTES ________________");
        for (Voo v : vooDAO.getVoosByIdCidade(id_cidade)) {
            if (v.getPonto_partida().equals(ponto_partida)) {
                for (Pacote p : pacoteDAO.getPacotesByIdVoo(v.getId())) {
                    System.out.println("");
                    System.out.println("Id: " + p.getId());
                    System.out.println("Destino: " + nome_destino.toLowerCase());
                    System.out.println("Desconto: " + p.getDesconto());
                    System.out.println("Valor: " + p.getValor_original());
                    System.out.println("Valor promocional: " + p.getValor_promocional());
                }
            }
        }
        System.out.println("");
    }

    public List<java.util.Date> converteFormatoData(String entrada, String saida) {
        String[] dataEntradaSplit = entrada.split("/");
        String anoEntrada = dataEntradaSplit[2];
        String mesEntrada = dataEntradaSplit[1];
        String diaEntrada = dataEntradaSplit[0];

        String[] dataSaidaSplit = saida.split("/");
        String anoSaida = dataSaidaSplit[2];
        String mesSaida = dataSaidaSplit[1];
        String diaSaida = dataSaidaSplit[0];

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date data_entrada;
        java.util.Date data_saida;
        java.util.Date data_delimitador;
        try {
            data_entrada = formatter.parse(anoEntrada + "-" + mesEntrada + "-" + diaEntrada);
            data_saida = formatter.parse(anoSaida + "-" + mesSaida + "-" + diaSaida);
            data_delimitador = formatter.parse("9999-12-31");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<java.util.Date> datas = new ArrayList<>();
        datas.add(data_entrada);
        datas.add(data_saida);
        datas.add(data_delimitador);
        return datas;
    }

    public java.util.Date converteFormatoData(String generic_data) {
        String[] dataEntradaSplit = generic_data.split("/");
        String anoEntrada = dataEntradaSplit[2];
        String mesEntrada = dataEntradaSplit[1];
        String diaEntrada = dataEntradaSplit[0];

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date data;
        try {
            data = formatter.parse(anoEntrada + "-" + mesEntrada + "-" + diaEntrada);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
