package view;

//Importando as classes e as interfaces
import control.FuncionariosController;
import control.CardapioController;
import control.PagamentoController;
import control.PedidoController;
import interfaces.Cardapio;
import interfaces.ListarEstoque;
import interfaces.MostrarMenu;
import model.Produtos;
import java.util.Scanner;
import view.EstoqueCardapio;


public class Main {
    static final int OPCAO_ABRIR_CANTINA = 1;
    static final int OPCAO_EXIBIR_CARDAPIO = 2;
    static final int OPCAO_FAZER_PEDIDO = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EstoqueCardapio estoqueCardapio = new EstoqueCardapio();
        PedidoController pedidoController = new PedidoController(estoqueCardapio);

        int opcao;

        while (true) {
            System.out.println("Escolha uma opção para continuar:");
            System.out.println("[1] Abrir Cantina");
            System.out.println("[2] Exibir Cardápio");
            System.out.println("[3] Fazer Pedido");

            opcao = scanner.nextInt();

            switch (opcao) {
                case OPCAO_ABRIR_CANTINA:
                String Would = "sim";
                String condicao;
                System.out.println("Você é Atendente ou Administrativo? [sim] ou [não]");
                condicao = scanner.nextLine();
                if (Would.equalsIgnoreCase(condicao)) {
                    System.out.println("Digite seu id Funcionario:");
                } else {
                    System.out.println("Somente Funcionarios podem abrir a cantina");
                }
                    break;

                case OPCAO_EXIBIR_CARDAPIO:
                    estoqueCardapio.MostrarEstoque();
                    break;

                case OPCAO_FAZER_PEDIDO:
                    pedidoController.fazerPedido();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}

