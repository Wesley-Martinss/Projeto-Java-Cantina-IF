package view;

import java.util.ArrayList;

import interfaces.ListarEstoque;
import model.Produtos;

public class EstoqueCardapio implements ListarEstoque {
    public static ArrayList<Produtos> produtos;

    public EstoqueCardapio() {
        produtos = new ArrayList<>();
        produtos.add(new Produtos(1, "Salgado Hamburguinho", 3.20, 10, 0));
        produtos.add(new Produtos(2, "Coxinha de Frango", 2.50, 20, 0));
        produtos.add(new Produtos(3, "Pão de Queijo", 1.80, 15, 0));
        produtos.add(new Produtos(4, "Bolo de Chocolate", 3.00, 8, 0));
        produtos.add(new Produtos(5, "Suco de Laranja", 2.00, 25, 0));
        produtos.add(new Produtos(6, "Guaravita", 2.30, 30, 0));
        produtos.add(new Produtos(7, "Suco Nativo", 2.50, 12, 0));
        produtos.add(new Produtos(8, "Pastel de Carne", 4.00, 5, 0));
        produtos.add(new Produtos(9, "Refrigerante Lata", 3.50, 18, 0));
        produtos.add(new Produtos(10, "Salgado de Queijo", 2.80, 10, 0));
    }

    @Override
    public void MostrarEstoque() {
        System.out.println("Produtos disponíveis na Cantina:");
        for (Produtos produto : produtos) {
            System.out.println(produto);
        }
    }

    // Método para remover um produto do estoque
    public void removerProduto(int idProduto) {
        Produtos produto = getProdutoPorId(idProduto);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso: " + produto.getDescricao());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Get retornar produtos
    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    // Método pra procurar produto por id
    public Produtos getProdutoPorId(int idProduto) {
        for (Produtos produto : produtos) {
            if (produto.getID() == idProduto) {
                return produto;
            }
        }
        return null;
    }
}
