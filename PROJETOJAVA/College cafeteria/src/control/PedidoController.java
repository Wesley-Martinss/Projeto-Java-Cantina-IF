package control;

import java.util.List;
import model.Produtos;
import java.util.ArrayList;
import view.EstoqueCardapio;
import model.Clientes.Aluno;
import java.util.Scanner;
import interfaces.ListarVendas;

public class PedidoController implements ListarVendas {
    private List<Aluno> listaAlunos; // Lista de alunos
    private EstoqueCardapio estoqueCardapio;
    private MenuControll menuControll = new MenuControll();
    private Scanner scanner = new Scanner(System.in);

    // Arraylist para armazenar os produtos vendidos
    public static ArrayList<Produtos> produtosVendidos = new ArrayList<>();

    // Método para retornar a lista de produtos vendidos
    public ArrayList<Produtos> getProdutosVendidos() {
        return produtosVendidos;
    }

    // Construtor para receber o estoque e a lista de alunos
    public PedidoController(EstoqueCardapio estoqueCardapio, List<Aluno> listaAlunos) {
        this.estoqueCardapio = estoqueCardapio;
        this.listaAlunos = listaAlunos;
    }

    // Método para fazer o pedido
    public void fazerPedido(int ra, int idProduto) {
        // Verificando se a cantina está aberta antes de permitir fazer o pedido
        if (!menuControll.AberturaCantina) {
            System.out.println("Cantina fechada. Espere abrir para fazer o pedido.");
            return;
        }

        // Busca o produto pelo ID
        Produtos produtoSelecionado = buscarProdutoPorId(idProduto);
        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        // Fazendo compra baseado no aluno cadastrado
        Aluno aluno = buscarAlunoPorMatricula(ra);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Aluno: " + aluno);
        System.out.println("Produto selecionado: " + produtoSelecionado.getDescricao());
        System.out.println("Preço: " + produtoSelecionado.getPreco() + "$");

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();

        // Verificar se a quantidade é suficiente no estoque
        if (quantidade > produtoSelecionado.getEstoque()) {
            System.out.println("Estoque insuficiente.");
            return;
        }

        // Calcular o total a pagar
        double total = quantidade * produtoSelecionado.getPreco();

        // Verificar se o aluno tem saldo suficiente
        if (aluno.getSaldo() < total) {
            System.out.println("Você não tem saldo suficiente para realizar essa compra");
            return;
        }

        // Mostrar o total a pagar
        System.out.printf("Total a pagar: %.2f$\n", total);

        // Perguntar qual a forma de pagamento
        System.out.println("Qual a forma de pagamento? [1] Pix  [2] Dinheiro");
        int formaPagamento = scanner.nextInt();
        scanner.nextLine(); // Consumir \n do buffer

        switch (formaPagamento) {
            case 1: // Pagamento via Pix
                processarPagamentoPix(aluno, total, produtoSelecionado, quantidade);
                break;

            case 2: // Pagamento via Dinheiro
                String precisoDetroco = "sim";
                String troco;
                double valorEmDinheiro;
                System.out.println("Você vai precisar de troco? [Sim] ou [Não]");
                troco = scanner.nextLine(); // Consumir o \n antes da entrada do usuario

                if (troco.equalsIgnoreCase(precisoDetroco)) {
                    System.out.println("Qual valor que você vai dar em dinheiro? ");
                    valorEmDinheiro = scanner.nextDouble();

                    // Verifica se o valor fornecido é suficiente para cobrir o total
                    if (valorEmDinheiro >= total) {
                        double valorTroco = valorEmDinheiro - total;
                        System.out.println("Troco: " + valorTroco + "$");
                        // Realiza a compra e atualiza o saldo e o estoque
                        realizarCompra(aluno, produtoSelecionado, quantidade, total);
                        System.out.println("Pagamento realizado com sucesso!");
                    } else {
                        System.out.println("O valor fornecido é insuficiente para cobrir o total da compra.");
                    }
                } else if (troco.equalsIgnoreCase("não") || troco.equalsIgnoreCase("nao")) {
                    System.out.println("Qual valor que você vai dar em dinheiro? ");
                    valorEmDinheiro = scanner.nextDouble();

                    // Verifica se o valor fornecido é suficiente para cobrir o total
                    if (valorEmDinheiro >= total) {
                        // Se não for necessário troco, faz a compra
                        realizarCompra(aluno, produtoSelecionado, quantidade, total);
                        System.out.println("Pagamento realizado com sucesso!");
                    } else {
                        System.out.println("O valor  é insuficiente para cobrir o total da compra.");
                    }
                } else {
                    System.out.println("Opção inválida. Responda com 'Sim' ou 'Não'.");
                }
                break;
        }
    }

    // ProcessarPagamento
    private void processarPagamentoPix(Aluno aluno, double total, Produtos produto, int quantidade) {
        System.out.println("Chave pix da cantina: 123456");
        System.out.print("Digite a chave para realizar o pagamento: ");
        String chavePix = scanner.nextLine();
        // Pula linha
        System.out.println();

        // Verificar se a chave Pix está correta
        if (!"123456".equals(chavePix)) {
            System.out.println("Chave Pix inválida.");
            return;
        }

        // Verificar se o saldo é suficiente
        if (aluno.getSaldo() < total) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        // Realizar a compra
        realizarCompra(aluno, produto, quantidade, total);
        System.out.println("Pagamento via Pix realizado com sucesso!");
    }

    private void realizarCompra(Aluno aluno, Produtos produto, int quantidade, double total) {
        // Atualizar o saldo do aluno
        aluno.setSaldo(aluno.getSaldo() - total);

        // Atualizar o estoque do produto
        if (produto != null) {
            produto.setEstoque(produto.getEstoque() - quantidade);
            // Adicionar o produto ao histórico de produtos vendidos
            produtosVendidos.add(produto);
        }
        // Contador para chamar o metodo de incrementar quantidade vendida no produto
        for (int i = 0; i < quantidade; i++) {
            produto.incrementarQuantidadeVendida();
        }
        System.out.printf("Saldo atualizado: %.2f$\n", aluno.getSaldo());
        System.out.println("Pedido realizado com sucesso!");
    }

    // Metodo para buscar aluno por matrícula (RA)
    public Aluno buscarAlunoPorMatricula(int ra) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getRA() == ra) {
                return aluno;
            }
        }
        return null; // Caso não encontre, retorna null
    }

    // Metodo para buscar o produto pelo ID
    public  Produtos  buscarProdutoPorId(int idProduto) {
        for (Produtos produto : estoqueCardapio.getProdutos()) {
            if (produto.getID() == idProduto) {
                return produto;
            }
        }
        return null; // Caso não encontre, retorna null
    }

    // Metodo para exibir produtos vendidos
    @Override
    public void MostrarProdutosVendidos() {
        if (produtosVendidos.isEmpty()) {
            System.out.println("Nenhum produto foi vendido.");
            return;
        }

        System.out.println("Produtos vendidos:");
        System.out.println();

        double valorTotalGeral = 0; // Armazenar o total de vendas

        for (Produtos prodVendas : produtosVendidos) {
            // Exibindo descrição e preço
            double valortotalProduto = prodVendas.getPreco() * prodVendas.getQuantidadeVendida();
            // A cada iteração, o valor total da venda do produto (valorTotalProduto) é
            // somado ao valor total geral das vendas (valorTotalGeral)
            valorTotalGeral += valortotalProduto;
            System.out.println("----------------------------------------------------------------------------");

            System.out.printf("Produto: %s | Preço: %.2f$ | Quantidade: %d | Total: %.2f$\n",
                    prodVendas.getDescricao(),
                    prodVendas.getPreco(),
                    prodVendas.getQuantidadeVendida(),
                    prodVendas.getPreco() * prodVendas.getQuantidadeVendida());

            System.out.println("----------------------------------------------------------------------------");
        }

        System.out.printf("\nValor total de vendas: %.2f$\n", valorTotalGeral);

    }
}
