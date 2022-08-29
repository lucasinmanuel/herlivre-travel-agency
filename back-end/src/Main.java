import model.service.HerlivreServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HerlivreServiceImpl herlivreServiceImpl = new HerlivreServiceImpl();

        Scanner lerOpc = new Scanner(System.in);
        Scanner lerSubOpc = new Scanner(System.in);
        Scanner lerDataEntrada = new Scanner(System.in);
        Scanner lerDataSaida = new Scanner(System.in);

        int opc;

        do {

            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("                                 Herlivre                                       ");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println(" 1 - Lista de cidades");
            System.out.println(" 2 - Pesquisar hotéis");
            System.out.println(" * * 1 - Ver os quartos");
            System.out.println(" 0 - Sair");

            System.out.println("___");
            System.out.print("Digite: ");
            opc = lerOpc.nextInt();

            switch (opc) {
                case 1 -> {
                    herlivreServiceImpl.getCidades();
                    System.out.println("_________________ FIM CIDADES __________________");
                }
                case 2 -> {
                    System.out.println("___");
                    System.out.print("Vai para qual cidade? ");
                    String nome_cidade = lerSubOpc.nextLine();
                    int id_cidade = herlivreServiceImpl.getHoteisByNomeCidade(nome_cidade);
                    if (id_cidade != -1) {
                        System.out.println("_________________ FIM HOTÉIS __________________");
                        System.out.println("");
                        System.out.println(" 1 - Ver os quartos");
                        System.out.println(" 0 - Sair");
                        System.out.println("___");
                        System.out.print("Digite: ");
                        if (lerOpc.nextInt() == 1) {
                            System.out.println("");
                            System.out.print("Quarto de qual hotel? ");
                            String nome_hotel = lerSubOpc.nextLine();
                            int id_hotel = herlivreServiceImpl.getQuartosByNomeHotel(nome_hotel);
                            if (id_hotel != -1) {
                                System.out.println("_________________ FIM QUARTOS __________________");
                                System.out.println("");
                                System.out.println(" 1 - Alugar quarto");
                                System.out.println(" 0 - Sair");
                                System.out.println("___");
                                System.out.print("Digite: ");
                                if (lerOpc.nextInt() == 1) {
                                    System.out.println("");
                                    System.out.print("Número de qual quarto? ");
                                    int numero = lerSubOpc.nextInt();
                                    System.out.print("Qual a data de entrada? ");
                                    String data_entrada = lerDataEntrada.next();
                                    System.out.print("Qual a data de saída? ");
                                    String data_saida = lerDataSaida.next();
                                    boolean statusQuarto = herlivreServiceImpl.verificaStatusQuarto(id_hotel, numero, data_entrada, data_saida);
                                    System.out.println("____________________________________________________");
                                    if(statusQuarto){
                                        System.out.println("Status do quarto: disponível!");
                                    }else{
                                        System.out.println("Status do quarto: quarto indisponível para a data fornecida :(");
                                    }
                                }
                            }else{
                                System.out.println("======================= ERRO ==========================");
                                System.out.println("Hotel incorreto ou não existe em nossa base de dados :(");
                                System.out.println("======================= ERRO ==========================");
                            }
                        }
                    } else {
                        System.out.println("======================== ERRO ==========================");
                        System.out.println("Cidade incorreta ou não existe em nossa base de dados :(");
                        System.out.println("======================== ERRO ==========================");
                    }
                }

            }
            System.out.println("");
        } while (opc != 0);

        lerOpc.close();
        lerSubOpc.close();
        lerDataEntrada.close();
        lerDataSaida.close();

    }
}