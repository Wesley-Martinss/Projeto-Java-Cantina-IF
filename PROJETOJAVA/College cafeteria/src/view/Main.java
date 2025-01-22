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

public class Main implements MostrarMenu, Cardapio, ListarEstoque {
    static final int OPCAO_ABRIR_CANTINA = 1;
    static final int OPCAO_EXIBIR_CARDAPIO = 2;
    static final int OPCAO_FAZER_PEDIDO = 3;
    static final int OPCAO_EMITIR_COMPROVANTE = 4;

    // menu definido na interface
    @Override
    public void menu() {
        System.out.println("Escolha uma opção para continuar");
        System.out.println("[1] Abrir Cantina");
        System.out.println("[2] Exibir Cardapio");
        System.err.println("[3] Fazer pedido");
        System.out.println("[4] Emitir Comprovante");

    }

    public void MostrarEstoque() {

    }

    public void Cardapio() {

    }

    public void MostrarCompras() {

    }

    public static void main(String[] args) {
        // Criando Arraylist do tipo Produtos com nome produtos
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Fazendo instancia de do main para acessar o menu
        Main main = new Main();

        System.out.println("--- Bem vindo a Cantina IFSP ---");
        while (true) {
            main.menu();
            opcao = scanner.nextInt();
            // consumir a linha em branco que fica no buffer
            scanner.nextLine();

            switch (opcao) {
                case OPCAO_ABRIR_CANTINA:
                    // resposta certa Would vai comparar com a condicao
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
                    EstoqueCardapio estoqueCardapio = new EstoqueCardapio();
                    estoqueCardapio.MostrarEstoque(); // Chamando o método para listar os produtos
                    break;
                default:
                    break;
            }

        }

    }

}
