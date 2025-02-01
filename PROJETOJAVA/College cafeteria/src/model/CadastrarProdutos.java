package model;

import java.util.Scanner;
import view.EstoqueCardapio;

public class CadastrarProdutos {
    public Produtos produto;

    // Método para cadastrar novos produtos
    public void cadastrarProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.println("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();

        System.out.println("Digite a quantidade disponivel do produto: ");
        int quantidadeProduto = scanner.nextInt();

        // Gerando um ID automaticamente baseado no Tamanho da lista
        int idProduto = EstoqueCardapio.produtos.size() + 1;

        // Logica para quando remover um produto ele não replicar o id
        boolean idExiste = true;
        while (idExiste) {
            idExiste = false;
            for (Produtos produto : EstoqueCardapio.produtos) {
                if (produto.getID() == idProduto) {
                    idProduto++; // Incrementa o ID caso já exista
                    idExiste = true; // Marca como verdadeiro para repetir a verificação
                    break; // Sai do laço for e verifica novamente }
                }
            }
        }
        // Criando o novo produto
        Produtos novoProduto = new Produtos(idProduto, nomeProduto, precoProduto, quantidadeProduto, 0);

        // Adicionando o produto à lista
        EstoqueCardapio.produtos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso!");
    }
}
