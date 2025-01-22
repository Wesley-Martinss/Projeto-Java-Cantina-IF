package view;

//Importando as classes e as interfaces
import control.FuncionariosController;
import control.CardapioController;
import control.PagamentoController;
import control.PedidoController;
import interfaces.Cardapio;
import interfaces.ListarEstoque;
import interfaces.MostrarMenu;
import java.util.Scanner;

public class Main {
    static final int OPCAO_ABRIR_CANTINA = 1;
    static final int OPCAO_EXIBIR_CARDAPIO = 2;
    static final int OPCAO_FAZER_PEDIDO = 3;
    static final int OPCAO_EMITIR_COMPROVANTE = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("--- Bem vindo a Cantina IFSP ---");
        System.out.println("Escolha uma opção para continuar");

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Abrir Cantina");
            System.out.println("[2] Exibir Cardapio");
            System.err.println("[3] Fazer pedido");
            System.out.println("[4] Emitir Comprovante");
            opcao = scanner.nextInt();
            //consumir a linha em branco que fica no buffer
            scanner.nextLine();

            switch (opcao) {
                case OPCAO_ABRIR_CANTINA:
                //resposta certa Would vai comparar com a condicao
                    String Would = "sim";
                    String condicao;
                    System.out.println("Você é Atendente ou Administrativo?");
                    condicao = scanner.nextLine();
                    if(Would.equalsIgnoreCase(condicao)){
                        System.out.println("Digite seu id Funcionario:");
                    }

                    break;

                default:
                    break;
            }

        }

    }

}
