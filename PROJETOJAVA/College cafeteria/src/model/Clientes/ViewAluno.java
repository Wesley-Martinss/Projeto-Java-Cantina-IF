package model.Clientes;

import java.util.ArrayList;

public class ViewAluno {
    // Criando a lista de alunos
    private ArrayList<Aluno> alunos = new ArrayList<>();

    // Construtor da classe ViewAluno
    public ViewAluno() {
        // Adicionando alunos diretamente à lista
        Aluno a1 = new Aluno(123, "Raul", 100);
        Aluno a2 = new Aluno(124, "Ana", 85);
        Aluno a3 = new Aluno(125, "Carlos", 92);
        Aluno a4 = new Aluno(126, "Fernanda", 78);
        Aluno a5 = new Aluno(127, "Luana", 89);
        Aluno a6 = new Aluno(128, "Pedro", 95);

        // Adicionando os alunos à lista
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);
        alunos.add(a5);
        alunos.add(a6);
    }

    // Método para exibir todos os alunos
    public void exibirAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
            System.out.println();
        }
    }

    // Método para obter a lista de alunos
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
