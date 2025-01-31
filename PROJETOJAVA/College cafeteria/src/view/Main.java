package view;

// Importando as classes e as interfaces
import control.PedidoController;
import control.MenuControll;
import interfaces.MostrarMenu;
import model.Administrativo;
import model.Atendente;
import model.Funcionarios;
import model.Clientes.ViewAluno;
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements MostrarMenu {
    static final int OPCAO_ABRIR_CANTINA = 1;
    static final int OPCAO_EXIBIR_CARDAPIO = 2;
    static final int OPCAO_FAZER_PEDIDO = 3;
    static final int OPCAO_EXIBIR_ALUNOS = 4;
    static final int OPCAO_EXIBIR_HISTORICO_VENDAS = 5;
    static final int OPCAO_SAIR = 0;

    // menu definido na interface
    @Override
    public void menu() {
        // Título
        System.out.println("\u001B[34mEscolha uma opção para continuar:\u001B[0m"); // Azul para o título
        //Metodo de adicionar cores peguei da internet, achei legal haha
        // Opções coloridas
        System.out.println("\u001B[32m[1] Abrir Cantina\u001B[0m"); // Verde
        System.out.println("\u001B[33m[2] Exibir Cardápio\u001B[0m"); // Amarelo 
        System.out.println("\u001B[36m[3] Fazer pedido\u001B[0m"); // Ciano 
        System.out.println("\u001B[31m[4] Exibir Alunos com conta na cantina\u001B[0m"); // Vermelho 
        System.out.println("\u001B[32m[5] Exibir histórico de vendas / Produtos vendidos\u001B[0m"); // Verde 
        System.out.println("\u001B[33m[0] Sair\u001B[0m"); // Amarelo 
    }
    

    public static void main(String[] args) {
        ArrayList<Funcionarios> funcionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        EstoqueCardapio estoqueCardapio = new EstoqueCardapio();
        ViewAluno viewAluno = new ViewAluno();

        // Passando a lista de alunos para o PedidoController
        PedidoController pedidoController = new PedidoController(estoqueCardapio, viewAluno.getAlunos());

        // Instanciando o controle do menu
        MenuControll menuControll = new MenuControll();

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

        System.out.println("--- Bem vindo a Cantina IFSP ---");
        while (true) {
            main.menu();
            opcao = scanner.nextInt();

            // consumir a linha em branco que fica no buffer
            scanner.nextLine();
            do {
                switch (opcao) {
                    case OPCAO_ABRIR_CANTINA:
                        menuControll.abrirCantina(scanner, funcionarios);
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
                        // Mostrar cardapio antes de fazer o pedido
                        estoqueCardapio.MostrarEstoque();
                        System.out.println("\n---------- Cardapio ----------\n");
                        System.out.println();
                        System.out.println("Digite o ID do produto que deseja comprar: ");
                        // Passa o idProduto como parametro para o PedidoController
                        int idProduto = scanner.nextInt();

                        System.out.println("Digite o RA do aluno: ");
                        // Passa o ra como parametro para o PedidoController
                        int ra = scanner.nextInt();
                        pedidoController.fazerPedido(ra, idProduto);
                        break;
                    case OPCAO_EXIBIR_ALUNOS:
                        viewAluno.exibirAlunos();
                        break;
                    case OPCAO_EXIBIR_HISTORICO_VENDAS:
                        pedidoController.MostrarProdutosVendidos();
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
