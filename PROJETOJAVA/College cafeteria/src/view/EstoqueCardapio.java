package view;

import java.util.ArrayList;
import interfaces.ListarEstoque;
import model.Produtos;

public class EstoqueCardapio implements ListarEstoque {
    // Implementação do método MostrarEstoque para listar os produtos
    @Override
    public void MostrarEstoque() {
        // Criando a ArrayList para armazenar os produtos
        ArrayList<Produtos> produtos = new ArrayList<>();

        // Adicionando produtos à ArrayList
        produtos.add(new Produtos(1, "Salgado Hamburguinho", 3.20, 10));
        produtos.add(new Produtos(2, "Coxinha de Frango", 2.50, 20));
        produtos.add(new Produtos(3, "Pão de Queijo", 1.80, 15));
        produtos.add(new Produtos(4, "Bolo de Chocolate", 3.00, 8));
        produtos.add(new Produtos(5, "Suco de Laranja", 2.00, 25));
        produtos.add(new Produtos(6, "Guaravita", 2.30, 30));
        produtos.add(new Produtos(7, "Suco Nativo", 2.50, 12));
        produtos.add(new Produtos(8, "Pastel de Carne", 4.00, 5));
        produtos.add(new Produtos(9, "Refrigerante Lata", 3.50, 18));
        produtos.add(new Produtos(10, "Salgado de Queijo", 2.80, 10));

        // Exibindo todos os produtos armazenados na ArrayList
        System.out.println("Produtos disponíveis na Cantina:");
        for (Produtos produto : produtos) {
            System.out.println();
            System.out.println(produto); // Chama o toString() para exibir os dados
        }
    }
}
