package control;

import java.util.Scanner;
import model.Produtos;
import view.EstoqueCardapio;

public class PedidoController {
    private EstoqueCardapio estoqueCardapio;
    // Fazendo instancia de MenuControll
    MenuControll menuControll = new MenuControll();

    Scanner scanner = new Scanner(System.in);

    // Construtor para receber o estoque
    public PedidoController(EstoqueCardapio estoqueCardapio) {
        this.estoqueCardapio = estoqueCardapio;
    }

    // Método para fazer o pedido
    public void fazerPedido() {
        // Verificando se a cantina está aberta antes de permitir fazer o pedido
        if (!menuControll.AberturaCantina) {
            System.out.println("Cantina fechada. Espere abrir para fazer o pedido.");
            return;
        }
        // fazendo compra baseado no aluno cadastrado

        // Mostra o estoque antes do pedido
        estoqueCardapio.MostrarEstoque();

        System.out.println("Digite o ID do produto que deseja comprar: ");
        int idProduto = scanner.nextInt();

        Produtos produtoSelecionado = null;
        for (Produtos produto : estoqueCardapio.getProdutos()) {
            if (produto.getID() == idProduto) {
                produtoSelecionado = produto;
                break;
            }
        }

        if (produtoSelecionado == null) {
            System.out.println("Produto nao encontrado.");
            return;
        }

        System.out.println("Produto selecionado: " + produtoSelecionado.getDescricao());
        System.out.println("Preço: " + produtoSelecionado.getPreco());
        System.out.println("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();

        if (quantidade > produtoSelecionado.getEstoque()) {
            System.out.println("Estoque insuficiente.");
        } else  {
            produtoSelecionado.setEstoque(produtoSelecionado.getEstoque() - quantidade);
            double total = quantidade * produtoSelecionado.getPreco();
            System.out.println("Pedido realizado com sucesso!");
            System.out.println("Total a pagar: " + total + "$");
        }
    }
}
