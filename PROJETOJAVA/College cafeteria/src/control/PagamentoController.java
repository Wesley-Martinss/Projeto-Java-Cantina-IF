package control;

import java.util.List;
import model.Clientes.Aluno;
import model.Produtos;
import view.EstoqueCardapio;

public class PagamentoController {

    private List<Aluno> listaAlunos; 
    private EstoqueCardapio estoqueCardapio;

    public PagamentoController(EstoqueCardapio estoqueCardapio, List<Aluno> listaAlunos) {
        this.estoqueCardapio = estoqueCardapio;
        this.listaAlunos = listaAlunos;
    }

    
    public void realizarCompra(int ra, int idProdut) {
        Aluno aluno = buscarAlunoPorMatricula(ra);
        if (aluno != null) {
            Produtos produto = estoqueCardapio.getProdutoPorId(idProdut);
            if (produto != null) {
                double valorProduto = produto.getPreco();
                if (aluno.getSaldo() >= valorProduto) {
                    aluno.setSaldo(aluno.getSaldo() - valorProduto);
                    System.out.println("Compra realizada com sucesso! Novo saldo: " + aluno.getSaldo());
                    produto.setEstoque(produto.getEstoque() - 1); // atualiza o estoque
                } else {
                    System.out.println("Saldo insuficiente para realizar a compra.");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // busca
    private Aluno buscarAlunoPorMatricula(int matricula) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getRA() == matricula) { 
                return aluno;
            }
        }
        return null;
    }
}
