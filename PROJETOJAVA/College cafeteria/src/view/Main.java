package view;

import control.PedidoController;
import control.MenuControll;
import interfaces.MostrarMenu;
import model.CadastrarFuncionarios.CadastroFuncionarios;
import model.Clientes.Aluno;
import model.Clientes.ViewAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.CadastrarAlunos.CadastroAluno;
import model.CadastrarProdutos;
import model.Funcionarios;

public class Main implements MostrarMenu {
    static final int OPCAO_ABRIR_CANTINA = 1;
    static final int OPCAO_EXIBIR_CARDAPIO = 2;
    static final int OPCAO_FAZER_PEDIDO = 3;
    static final int OPCAO_EXIBIR_ALUNOS = 4;
    static final int OPCAO_EXIBIR_HISTORICO_VENDAS = 5;
    static final int OPCAO_CADASTRAR_ALUNO = 6;
    static final int OPCAO_CADASTRAR_FUNCIONARIOS = 7;
    static final int OPCAO_CADASTRAR_PRODUTOS = 8;
    static final int OPCAO_EXIBIR_ESTOQUE = 9;
    static final int OPCAO_REMOVER_E_EDITARPRODUTO = 10;
    static final int OPCAO_FECHAR_CANTINA = 11;
    static final int OPCAO_EXIBIR_LISTA_FUNCIONARIOS_ADM_ATENDENTE = 12;
    static final int OPCAO_SAIR = 0;

    // menu definido na interface
    @Override
    public void menu() {
        // Título
        System.out.println("\u001B[34mEscolha uma opção para continuar:\u001B[0m");

        // Opções coloridas
        System.out.println("\u001B[32m[1] Abrir Cantina\u001B[0m");
        System.out.println("\u001B[33m[2] Exibir Cardápio\u001B[0m");
        System.out.println("\u001B[36m[3] Fazer pedido\u001B[0m");
        System.out.println("\u001B[31m[4] Exibir Alunos com conta na cantina\u001B[0m");
        System.out.println("\u001B[32m[5] Exibir histórico de vendas / Produtos vendidos\u001B[0m");
        System.out.println("\u001B[35m[6] Cadastrar aluno\u001B[0m");
        System.out.println("\u001B[35m[7] Cadastrar Funcionarios\u001B[0m");
        System.out.println("\u001B[35m[8] Cadastrar Produtos\u001B[0m");
        System.out.println("\u001B[36m[9] Exibir estoque\u001B[0m");
        System.out.println("\u001B[36m[10] Editar / Remover produtos\u001B[0m");
        System.out.println("\u001B[35m[11] Fechar Cantina\u001B[0m");
        System.out.println("\u001B[32m[12] Exibir lista de funcionario\u001B[0m");

        System.out.println("\u001B[33m[0] Sair\u001B[0m");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViewAluno viewAluno = new ViewAluno();

        // Criando a instância de EstoqueCardapio
        EstoqueCardapio estoqueCardapio = new EstoqueCardapio(); // Criação da instância aqui

        // Passando a lista de alunos para o PedidoController
        // Passando a instância para os controllers
        PedidoController pedidoController = new PedidoController(estoqueCardapio, CadastroAluno.getAlunos());

        // Instânciando cadastros
        CadastroAluno cadAlunos = new CadastroAluno();
        CadastroFuncionarios cadFuncionarios = new CadastroFuncionarios();
        CadastrarProdutos cadProdutos = new CadastrarProdutos();

        // Instanciando o controle do menu
        MenuControll menuControll = new MenuControll();

        // Instânciando lista

        // Fazendo instancia de do main para acessar o menu
        Main main = new Main();

        // Variaveis globais
        int opcao = 0;

        System.out.println("--- Bem vindo a Cantina IFSP ---");
        while (true) {
            main.menu();
            opcao = scanner.nextInt();

            // consumir a linha em branco que fica no buffer
            scanner.nextLine();
            do {
                switch (opcao) {
                    case OPCAO_ABRIR_CANTINA:
                        menuControll.abrirCantina(scanner, CadastroFuncionarios.Cadastrofuncionario);
                        break;
                    case OPCAO_EXIBIR_CARDAPIO:
                        estoqueCardapio.MostrarEstoque();
                        System.out.println();
                        break;
                    case OPCAO_FAZER_PEDIDO:
                        if (!menuControll.AberturaCantina) {
                            System.out.println("Cantina fechada. Espere abrir para fazer o pedido.");
                            break;
                        }
                        System.out.println("\n---------- Cardapio ----------\n");
                        estoqueCardapio.MostrarEstoque();
                        System.out.println("\n---------- Cardapio ----------\n");
                        System.out.println("Digite o ID do produto que deseja comprar: ");
                        int idProduto = scanner.nextInt();

                        System.out.println("Digite o RA do aluno: ");
                        int ra = scanner.nextInt();
                        pedidoController.fazerPedido(ra, idProduto);
                        break;
                    case OPCAO_EXIBIR_HISTORICO_VENDAS:
                        pedidoController.MostrarProdutosVendidos();
                        break;
                    case OPCAO_EXIBIR_ALUNOS:
                        viewAluno.exibirAlunos();
                        break;
                    case OPCAO_CADASTRAR_ALUNO:
                        cadAlunos.CadastroAluno(scanner);
                        break;
                    case OPCAO_CADASTRAR_FUNCIONARIOS:
                        cadFuncionarios.CadastroFuncionarios(scanner);
                        break;
                    case OPCAO_CADASTRAR_PRODUTOS:
                        cadProdutos.cadastrarProduto(scanner);
                        break;
                    case OPCAO_EXIBIR_ESTOQUE:
                        estoqueCardapio.MostrarEstoque();
                        break;
                    case OPCAO_REMOVER_E_EDITARPRODUTO:
                        String admResposta = "sim";
                        String resposta;
                        System.out.println("Você é Administrador ou funcionario? [Sim] [Nao]");
                        resposta = scanner.nextLine();

                        // Verificação de administrador
                        if (resposta.equalsIgnoreCase(admResposta)) {
                            System.out.println("Digite seu ID de Administrador: ");
                            int idAdministrador = scanner.nextInt(); // Lê o ID do administrador
                            scanner.nextLine(); // Consome a quebra de linha após a leitura do inteiro

                            boolean verificarFuncionario = false; // Flag para verificar se o administrador foi
                                                                  // encontrado

                            // For percorrer sobre a lista e achar funcionario
                            for (Funcionarios func : CadastroFuncionarios.Cadastrofuncionario) { // Usando a lista do
                                                                                                 // CadastroFuncionarios
                                System.out.println("Verificando ID: " + func.getID()); // Debugg Verifica os IDs dos
                                                                                       // funcionários
                                if (idAdministrador == func.getID()) { // Verifica se o ID do administrador corresponde
                                                                       // ao ID de um funcionário
                                    verificarFuncionario = true;
                                    System.out.println("Funcionário encontrado: " + func.getNome());
                                    break; // Break quando encontrar funcionario
                                }
                            }

                            // Se o administrador for encontrado, permite editar ou remover produtos
                            if (verificarFuncionario == true) {
                                System.out.println("O que você gostaria de fazer?");
                                System.out.println("[1] Editar Produto");
                                System.out.println("[2] Remover Produto");
                                System.out.println("[0] Cancelar");
                                System.out.print("Escolha uma opção: ");
                                int opcaoProduto = scanner.nextInt();
                                scanner.nextLine();

                                switch (opcaoProduto) {
                                    case 1:
                                        System.out.println("Digite o ID do produto que deseja editar: ");
                                        int idProdutoEditar = scanner.nextInt();
                                        scanner.nextLine(); // Consome \n
                                        menuControll.editarProduto(scanner, idProdutoEditar, estoqueCardapio);
                                        break;

                                    case 2:
                                        System.out.println("Digite o ID do produto que deseja remover: ");
                                        int idProdutoRemover = scanner.nextInt();
                                        scanner.nextLine(); // Consome \n
                                        menuControll.removerProduto(idProdutoRemover, estoqueCardapio);
                                        break;
                                    case 0:
                                        System.out.println("Operação cancelada");
                                        break;
                                    default:
                                        System.out.println("Opção inválida!");
                                        break;
                                }
                            } else {
                                System.out.println("Administrador não encontrado ou ID inválido.");
                            }
                        }
                        break;

                    case OPCAO_FECHAR_CANTINA:
                        // Tendo acesso a váriavel Abertura cantina porque foi definida como public
                        // static
                        if (menuControll.AberturaCantina == false) {
                            System.out.println("A cantina ja está fechada");
                            break;
                        }
                        System.out.println("Cantina fechada.");
                        menuControll.AberturaCantina = false;
                        break;
                    case OPCAO_EXIBIR_LISTA_FUNCIONARIOS_ADM_ATENDENTE:
                        CadastroFuncionarios.exibirFuncionarios(CadastroFuncionarios.Cadastrofuncionario);
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
