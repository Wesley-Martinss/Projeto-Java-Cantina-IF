package model.Clientes;

import model.CadastrarAlunos.CadastroAluno;

public class ViewAluno {
    // Construtor da classe ViewAluno
    public ViewAluno() {
        // Aqui não adiciono nada, só coloquei o construtor
        // os alunos já estão na lista estática CadastroAlunos.
    }

    // Método para exibir todos os alunos cadastrados
    public void exibirAlunos() {
        for (Aluno aluno : CadastroAluno.CadastroAlunos) {
            System.out.println(aluno);
            System.out.println();
        }
    }

}
