package view;

//Importando as classes e as interfaces

import control.PedidoController;
import control.MenuControll;
import interfaces.Cardapio;
import interfaces.ListarEstoque;
import interfaces.MostrarMenu;
import model.Administrativo;
import model.Atendente;
import model.Funcionarios;
import java.util.Scanner;
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
       //Instanciando o controle do menu 
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
