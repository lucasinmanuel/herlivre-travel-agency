package model.service;

import java.util.Scanner;

public class ConsoleOptions {

    private AdmServiceImpl admServiceImpl = new AdmServiceImpl();
    private HerlivreServiceImpl herlivreServiceImpl = new HerlivreServiceImpl();
    private Scanner lerOpc = new Scanner(System.in);
    private Scanner lerSubOpc = new Scanner(System.in);

    public int areaLogin(){
        int id_usuario = -1;
        int opc;
        do {
            System.out.println(" 1 - Login");
            System.out.println(" 2 - Sign up");
            System.out.println(" 0 - Continuar");
            System.out.println("___");
            System.out.print("Digite: ");
            opc = lerOpc.nextInt();
            switch (opc) {
                case 1 -> {
                    System.out.println("___");
                    System.out.print("Email:  ");
                    String email = lerSubOpc.next();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Senha: ");
                    String password = lerSubOpc.next();
                    if (email.contains("@")) {
                        id_usuario = herlivreServiceImpl.login(email, password);
                        System.out.println("");
                        if (id_usuario != -1) {
                            System.out.println("==== SUCESSO ====");
                            System.out.println(" Login realizado!");
                            System.out.println("==== SUCESSO ====");
                        } else {
                            System.out.println("========== ERRO ==========");
                            System.out.println("Email ou senha incorretos ");
                            System.out.println("========== ERRO ==========");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("========= ERRO =========");
                        System.out.println("Email ou senha inválido ");
                        System.out.println("========= ERRO =========");
                    }
                }
                case 2 -> {
                    System.out.println("___");
                    System.out.print("Nome: ");
                    String nome = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("CPF: ");
                    String cpf = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Email: ");
                    String email = lerSubOpc.next();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Senha: ");
                    String password = lerSubOpc.next();
                    herlivreServiceImpl.signUp(nome, cpf, email, password);
                    System.out.println("");
                    System.out.println("===== SUCESSO =====");
                    System.out.println("Cadastro realizado!");
                    System.out.println("===== SUCESSO =====");
                }
            }
            System.out.println("");
        } while (opc != 0);
        return id_usuario;
    }

    public void areaClient(int id_usuario){
        int opc;
        do {
            System.out.println(" 1 - Lista de cidades");
            System.out.println(" 2 - Pesquisar hotéis");
            System.out.println(" 3 - Lista de pacotes");
            System.out.println(" 4 - Pesquisar pacotes");
            System.out.println(" 0 - Sair");

            System.out.println("___");
            System.out.print("Digite: ");
            opc = lerOpc.nextInt();

            lerSubOpc = new Scanner(System.in);
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
                            lerSubOpc = new Scanner(System.in);
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
                                if (lerOpc.nextInt() == 1 && id_usuario != -1) {
                                    System.out.println("");
                                    lerSubOpc = new Scanner(System.in);
                                    System.out.print("Número de qual quarto? ");
                                    int numero = lerSubOpc.nextInt();
                                    lerSubOpc = new Scanner(System.in);
                                    System.out.println("Exemplo de data: dd/mm/yyyy");
                                    System.out.print("Qual a data de entrada? ");
                                    String data_entrada = lerSubOpc.next();
                                    lerSubOpc = new Scanner(System.in);
                                    System.out.print("Qual a data de saída? ");
                                    String data_saida = lerSubOpc.next();
                                    int id_quarto = herlivreServiceImpl.verificaStatusQuarto(id_hotel, numero, data_entrada, data_saida);
                                    System.out.println("_________________________");
                                    System.out.println("");
                                    if (id_quarto != -1 && id_quarto != -2 && id_quarto != -3) {
                                        System.out.println("Status do quarto: disponível!");
                                        System.out.println("");
                                        System.out.println(" 1 - Efetuar compra");
                                        System.out.println(" 0 - Cancelar compra");
                                        System.out.println("___");
                                        System.out.print("Digite: ");
                                        if (lerSubOpc.nextInt() == 1) {
                                            herlivreServiceImpl.realizarRegistroAluguel(id_quarto, id_usuario, data_entrada, data_saida);
                                        }
                                    } else if (id_quarto == -1) {
                                        System.out.println("Status do quarto: quarto indisponível para a data fornecida :(");
                                    } else if (id_quarto == -2) {
                                        System.out.println("==================== ERRO =========================");
                                        System.out.println("Data de entrada está vindo depois da data de saída");
                                        System.out.println("==================== ERRO =========================");
                                    } else if (id_quarto == -3) {
                                        System.out.println("=================== ERRO =====================");
                                        System.out.println("Data de entrada está vindo antes da data atual");
                                        System.out.println("=================== ERRO =====================");
                                    }
                                } else {
                                    if (id_usuario == -1) {
                                        System.out.println("======================== ERRO ==========================");
                                        System.out.println("Faça login ou crie uma conta para poder alugar um quarto");
                                        System.out.println("======================== ERRO ==========================");
                                    }
                                }
                            } else {
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
                case 3 -> {
                    herlivreServiceImpl.getPacotes();
                    System.out.println("_________________ FIM PACOTES __________________");
                }
                case 4 -> {
                    System.out.println("___");
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Qual o seu ponto de partida? ");
                    String destino = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Vai para qual cidade? ");
                    String nome_cidade = lerSubOpc.nextLine();
                    herlivreServiceImpl.getPacotesByNomeCidadeAndDestino(nome_cidade, destino);
                    System.out.println("_________________ FIM PACOTES __________________");
                }

            }
            System.out.println("");
        } while (opc != 0);
    }

    public void areaAdmin(){
        int opc;
        do {
            System.out.println(" 1 - Ver lista de voos");
            System.out.println(" 2 - Ver lista de cidades");
            System.out.println(" 3 - Criar pacotes");
            System.out.println(" 0 - Sair");

            System.out.println("___");
            System.out.print("Digite: ");
            opc = lerOpc.nextInt();
            switch (opc) {
                case 1 -> {
                    System.out.println("");
                    System.out.print("Filtrar por data_chegada > dd/mm/yyyy: ");
                    admServiceImpl.getVoosByData(lerSubOpc.next());
                    System.out.println("_________________ FIM VOOS __________________");
                }
                case 2 -> {
                    herlivreServiceImpl.getCidades();
                    System.out.println("_________________ FIM CIDADES __________________");
                }
                case 3 -> {
                    System.out.println("");
                    lerSubOpc = new Scanner(System.in);
                    System.out.println("Máximo de 2 pessoas");
                    System.out.print("Total de pessoas para o pacote: ");
                    int total_pessoas = 1;
                    do{
                        if(total_pessoas < 1 || total_pessoas > 2){
                            System.out.println("Total de pessoas precisa ser 1 ou 2: ");
                        }
                        total_pessoas = lerSubOpc.nextInt();
                    }while(total_pessoas < 1 || total_pessoas > 2);
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Valor do pacote sem desconto : ");
                    double valor_original = lerSubOpc.nextDouble();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Desconto do pacote: ");
                    int desconto = lerSubOpc.nextInt();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Valor do pacote com desconto: ");
                    double valor_promocional = lerSubOpc.nextDouble();
                    System.out.println("");
                    System.out.println("COMPRAR VOO PARA O PACOTE");
                    System.out.println("_______________");
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Nome da cidade de partida: ");
                    String cidadePartida = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Nome da cidade de destino: ");
                    String cidadeDestino = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Nome da companhia aérea: ");
                    String companhia = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Número do voo: ");
                    String num_voo = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Número do assento: ");
                    String num_assento = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Data de partida: ");
                    String data_partida = lerSubOpc.nextLine();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Data de chegada: ");
                    String data_chegada = lerSubOpc.nextLine();
                    System.out.println("Passagem 01 foi comprada!");
                    int id_voo = admServiceImpl.insertVoo(cidadeDestino, cidadePartida, companhia, num_voo, num_assento, data_partida, data_chegada);
                    int id_voo2 = -1;
                    if(total_pessoas >= 2){
                        System.out.println("Adicionar mais um assento por ser um pacote de 2 pessoas");
                        lerSubOpc = new Scanner(System.in);
                        System.out.print("Número do assento: ");
                        String num_assento2 = lerSubOpc.nextLine();
                        id_voo2 = admServiceImpl.insertVoo(cidadeDestino, cidadePartida, companhia, num_voo, num_assento2, data_partida, data_chegada);
                    }
                    System.out.println("");
                    System.out.println("ESCOLHA O QUARTO DO HOTEL PARA A CIDADE DE DESTINO - " + cidadeDestino.toUpperCase());

                    herlivreServiceImpl.getHoteisByNomeCidade(cidadeDestino);
                    System.out.println("_________________ FIM HOTÉIS __________________");
                    System.out.println("");
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Nome do hotel: ");
                    String nomeHotel = lerSubOpc.nextLine();
                    int id_hotel = herlivreServiceImpl.getQuartosByNomeHotel(nomeHotel);
                    System.out.println("_________________ FIM QUARTOS __________________");
                    System.out.println("");
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Número do quarto: ");
                    int num_quarto = lerSubOpc.nextInt();
                    lerSubOpc = new Scanner(System.in);
                    System.out.println("Exemplo de data: dd/mm/yyyy");
                    System.out.print("Qual a data de entrada? ");
                    String data_entrada = lerSubOpc.next();
                    lerSubOpc = new Scanner(System.in);
                    System.out.print("Qual a data de saída? ");
                    String data_saida = lerSubOpc.next();
                    int id_quarto = herlivreServiceImpl.verificaStatusQuarto(id_hotel, num_quarto, data_entrada, data_saida);
                    System.out.println("_________________________");
                    System.out.println("");
                    if (id_quarto != -1 && id_quarto != -2 && id_quarto != -3) {
                        System.out.println("Status do quarto: disponível!");
                        System.out.println("");
                        System.out.println(" 1 - Efetuar compra");
                        System.out.println(" 0 - Cancelar compra");
                        System.out.println("___");
                        System.out.print("Digite: ");
                        if (lerSubOpc.nextInt() == 1) {
                            int id_registroaluguel = herlivreServiceImpl.realizarRegistroAluguel(id_quarto, 1, data_entrada, data_saida);
                            int id_pacote = admServiceImpl.insertPacote(id_voo,id_voo2,id_registroaluguel,total_pessoas,valor_original,desconto,valor_promocional);
                            System.out.print("Pacote criado!");
                        }
                    } else if (id_quarto == -1) {
                        System.out.println("Status do quarto: quarto indisponível para a data fornecida :(");
                    } else if (id_quarto == -2) {
                        System.out.println("==================== ERRO =========================");
                        System.out.println("Data de entrada está vindo depois da data de saída");
                        System.out.println("==================== ERRO =========================");
                    } else if (id_quarto == -3) {
                        System.out.println("=================== ERRO =====================");
                        System.out.println("Data de entrada está vindo antes da data atual");
                        System.out.println("=================== ERRO =====================");
                    }
                }
            }
            System.out.println("");
        } while (opc != 0);
        lerOpc.close();
        lerSubOpc.close();
    }

}
