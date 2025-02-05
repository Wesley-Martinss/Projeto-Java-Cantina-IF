package control;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Produtos; // Importa a classe Produtos, que representa os produtos da cantina
import model.Funcionarios;
import view.EstoqueCardapio;

public class MenuControll {
    public static boolean AberturaCantina = false; // Variável que armazena o estado da cantina (aberta ou fechada)
    public EstoqueCardapio estoqueCardapio; // Instância da classe EstoqueCardapio, que controla os produtos da cantina

    // Método para verificar se o funcionário existe com o ID fornecido
    private boolean verificarFuncionario(int idFuncionario, ArrayList<Funcionarios> funcionarios) {
        for (Funcionarios func : funcionarios) {
            if (idFuncionario == func.getID()) { // Compara o ID fornecido com os IDs dos funcionários
                System.out.println("Funcionário encontrado: " + func);
                LocalDate hoje = LocalDate.now();
                LocalTime agora = LocalTime.now();
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                String horaFormatada = agora.format(formatoHora);
                System.out.println(
                        "Cantina aberta hoje, dia: " + hoje + " Hora: " + horaFormatada + " Por: " + func.getNome());
                return true; // Retorna true se o funcionário for encontrado
            }
        }
        System.out.println("Funcionário não encontrado com o ID informado.");
        return false; // Retorna false caso o funcionário não seja encontrado
    }


    // Método para abrir a cantina (só pode abrir se o funcionário for verificado)
    public void abrirCantina(Scanner scanner, ArrayList<Funcionarios> funcionarios) {
        if (AberturaCantina) { // Verifica se a cantina já está aberta
            System.out.println("A cantina já está aberta");
            return; // Retorna se a cantina já estiver aberta
        }
        System.out.println("Você é Atendente ou Administrativo? [sim] ou [não]");
        String condicao = scanner.nextLine(); // Pergunta se a pessoa é atendente ou administrador
        if ("sim".equalsIgnoreCase(condicao)) { // Verifica se a pessoa é atendente ou administrativo
            System.out.println("Digite seu ID de Funcionário:");
            int IDADM = scanner.nextInt(); // Lê o ID do funcionário
            if (verificarFuncionario(IDADM, funcionarios)) { // Verifica se o ID do funcionário existe
                AberturaCantina = true; // Marca a cantina como aberta
            }
        }
    }

    // Método para editar as informações de um produto
    public void editarProduto(Scanner scanner, int idProduto, EstoqueCardapio estoqueCardapio) {
        Produtos produto = estoqueCardapio.getProdutoPorId(idProduto); // Obtém o produto pelo ID
        if (produto != null) { // Se o produto for encontrado
            System.out.println("Produto encontrado: " + produto.getDescricao());
            System.out.println("Informe os novos dados para o produto:");

            // Edita o nome do produto
            System.out.println("Nome atual: " + produto.getDescricao());
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            produto.setDescricao(novoNome); // Atualiza o nome do produto

            // Edita o preço do produto
            System.out.println("Preço atual: " + produto.getPreco());
            System.out.print("Novo preço: ");
            double novoPreco = scanner.nextDouble();
            produto.setPreco(novoPreco); // Atualiza o preço do produto

            // Edita a quantidade do produto
            System.out.println("Quantidade atual: " + produto.getEstoque());
            System.out.print("Nova quantidade: ");
            int novaQuantidade = scanner.nextInt();
            produto.setEstoque(novaQuantidade); // Atualiza a quantidade do produto

            System.out.println("Produto editado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Método para remover um produto pelo ID
    public void removerProduto(int idProduto, EstoqueCardapio estoqueCardapio) {
        Produtos produto = estoqueCardapio.getProdutoPorId(idProduto); // Busca o produto pelo ID
        if (produto != null) { // Se o produto for encontrado
            estoqueCardapio.removerProduto(idProduto); // Remove o produto utilizando o método removerProduto
        } else {
            return; // Retorna sem fazer nada se o produto não for encontrado
        }
    }
}
