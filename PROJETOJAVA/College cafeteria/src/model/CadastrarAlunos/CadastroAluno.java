package model.CadastrarAlunos;

import java.util.Scanner;
import java.util.ArrayList;
import model.Clientes.Aluno;

public class CadastroAluno {
    // Lista static para manter os alunos cadastrados
    public static ArrayList<Aluno> CadastroAlunos = new ArrayList<>();

    // Construtor para adicionar alunos pré-criados
    static {
        // Adicionando alunos pré-criados
        Aluno a1 = new Aluno(123, "Raul", 10);
        Aluno a2 = new Aluno(124, "Ana", 85);
        Aluno a3 = new Aluno(125, "Carlos", 92);
        Aluno a4 = new Aluno(126, "Fernanda", 78);
        Aluno a5 = new Aluno(127, "Luana", 89);
        Aluno a6 = new Aluno(128, "Pedro", 95);

        // Adicionando os alunos a lista
        CadastroAlunos.add(a1);
        CadastroAlunos.add(a2);
        CadastroAlunos.add(a3);
        CadastroAlunos.add(a4);
        CadastroAlunos.add(a5);
        CadastroAlunos.add(a6);
    }

    // Método para cadastrar novos alunos
    public void CadastroAluno(Scanner scanner) {
        System.out.println("Digite o ra(Registro aluno) do aluno: ");
        int raAluno = scanner.nextInt();

        //Verificando duplicidade de RA com o metodo 'VerificarDuplicidadeRA' boolean
        if (VerificarDuplicidadeRA(raAluno)) {
            System.out.println("Erro: O RA " + raAluno + " já está cadastrado.");
            return; // Não continua o cadastro se o RA for duplicado
        }

        scanner.nextLine(); // Consumir o \n após o nextInt()
        System.out.println("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.println("Digite o saldo do aluno: ");
        double saldoAluno = scanner.nextDouble();

        Aluno cadastroNewAlunos = new Aluno(raAluno, nomeAluno, saldoAluno);
        CadastroAlunos.add(cadastroNewAlunos); // Adiciona à lista
        //Mensagem apos adicionar New Aluno
        System.out.println("Aluno " + nomeAluno + " Cadastrado com sucesso");
    }


    public static boolean VerificarDuplicidadeRA(int ra) {
        for (Aluno aluno : CadastroAlunos) {
            // Se getRA que retorna for igual "RA" digitado enquanto itera, retorna True//
            // RA Existe
            if (aluno.getRA() == ra) {
                return true;// Existe RA
            }
            return false;// RA não existe
        }

        return true;
    }

    // Metodo para obter a lista de alunos
    public static ArrayList<Aluno> getAlunos() {
        return CadastroAlunos;
    }
}
