package model.Clientes;

import java.util.ArrayList;

public class ViewAluno {
    // Criando a lista de alunos
    ArrayList<Alunos> alunos = new ArrayList<>();

    // Adicionando os alunos diretamente na lista

    public ViewAluno() {
        alunos = new ArrayList<>();
        alunos.add(new Alunos(123, "Raul", 100));
        alunos.add(new Alunos(124, "Ana", 85));
        alunos.add(new Alunos(125, "Carlos", 92));
        alunos.add(new Alunos(126, "Fernanda", 78));
        alunos.add(new Alunos(127, "Luana", 89));
        alunos.add(new Alunos(128, "Pedro", 95));
    }
}
