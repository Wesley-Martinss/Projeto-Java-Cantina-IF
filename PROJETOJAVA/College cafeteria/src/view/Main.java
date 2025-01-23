package view;

//Importando as classes e as interfaces
import control.FuncionariosController;
import control.PagamentoController;
import control.PedidoController;
import interfaces.Cardapio;
import interfaces.ListarEstoque;
import interfaces.MostrarMenu;
import model.Administrativo;
import model.Atendente;
import model.Funcionarios;
import model.Produtos;
import java.util.Scanner;
import view.EstoqueCardapio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main implements MostrarMenu, Cardapio, ListarEstoque {
    static final int OPCAO_ABRIR_CANTINA = 1;
    static final int OPCAO_EXIBIR_CARDAPIO = 2;
    static final int OPCAO_FAZER_PEDIDO = 3;
    static final int OPCAO_EMITIR_COMPROVANTE = 4;
    static final int OPCAO_SAIR = 0;

    // menu definido na interface
    @Override
    public void menu() {
        System.out.println("Escolha uma opção para continuar");
        System.out.println("[1] Abrir Cantina");
        System.out.println("[2] Exibir Cardapio");
        System.err.println("[3] Fazer pedido");
        System.out.println("[4] Emitir Comprovante");
        System.out.println("[0] Sair");

    }

    public void MostrarEstoque() {

    }

    public void Cardapio() {

    }

    public void MostrarCompras() {

    }

    public static void main(String[] args) {
        ArrayList<Funcionarios> funcionarios = new ArrayList<>();

        // Criando Arraylist do tipo Produtos com nome produtos
        Scanner scanner = new Scanner(System.in);
        EstoqueCardapio estoqueCardapio = new EstoqueCardapio();
        PedidoController pedidoController = new PedidoController(estoqueCardapio);

        // Funcionarios
        Administrativo adm = new Administrativo("Wesley", 6000, 1, "ADM");
        Administrativo adm2 = new Administrativo("Jonas", 6000, 2, "ADM");
        Atendente a1 = new Atendente("Lourdes", 2000, 3, "Atendente");
        Atendente a2 = new Atendente("Maria", 2000, 4, "Atendente");

        // Adicionando funcionarios ao Arraylist
        funcionarios.add(adm);
        funcionarios.add(adm2);
        funcionarios.add(a1);
        funcionarios.add(a2);

        // Fazendo instancia de do main para acessar o menu
        Main main = new Main();

        // Variaveis globais
        int opcao = 0;
        boolean AberturaCantina = false;
        

        System.out.println("--- Bem vindo a Cantina IFSP ---");
        while (true) {
            main.menu();
            opcao = scanner.nextInt();

            // consumir a linha em branco que fica no buffer
            scanner.nextLine();
            do {
                switch (opcao) {            
                    case OPCAO_ABRIR_CANTINA:
                    //verificando se cantina já está aberta
                    if(AberturaCantina == true){
                        System.out.println("Cantina já esta aberta.");
                        break;

                    }
                        String condicao;
                        //ID DO FUNCIONARIO
                        int IDADM = 0;
                        //Confirmando se a pessoa é funcionario
                        System.out.println("Você é Atendente ou Administrativo? [sim] ou [não]");
                        condicao = scanner.nextLine();
                        // Verificar se o ID corresponde a algum funcionário
                        boolean encontrado = false;

                        if ("sim".equalsIgnoreCase(condicao)) {
                            System.out.println("Digite seu ID de Funcionário:");
                            IDADM = scanner.nextInt();

                            // Percorrer a lista de funcionários
                            for (Funcionarios func : funcionarios) {
                                if (IDADM == func.getID()) { // Certifique-se de que o método é getId() ou o método
                                                             // correto
                                    // Funcionário encontrado, exibe informações
                                    System.out.println();
                                    System.out.println("Funcionário encontrado: " + func);
                                    System.out.println();

                                    // Exibindo data e hora formatada
                                    LocalDate hoje = LocalDate.now();
                                    LocalTime agora = LocalTime.now();
                                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                                    String horaFormatada = agora.format(formatoHora);

                                    System.out.println("Cantina aberta hoje, dia: " + hoje + " Hora: " + horaFormatada);
                                    AberturaCantina = true;

                                    // Marca como encontrado e sai do loop
                                    encontrado = true;
                                    break; // Aqui sai do loop imediatamente após encontrar o funcionário
                                }
                                // Se não encontrou o funcionário, exibe a mensagem
                                else if (!encontrado) {
                                    System.out.println("Funcionário não encontrado com o ID informado.");
                                    System.out.println("Somente Funcionários podem abrir a cantina.");
                                    break;
                                }
                            }
                        }
                        break;
                    case OPCAO_EXIBIR_CARDAPIO:
                        estoqueCardapio.MostrarEstoque();
                        break;

                    case OPCAO_FAZER_PEDIDO:
                        pedidoController.fazerPedido();
                        break;
                    case OPCAO_SAIR:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (opcao == 0);
        }
    }

}
