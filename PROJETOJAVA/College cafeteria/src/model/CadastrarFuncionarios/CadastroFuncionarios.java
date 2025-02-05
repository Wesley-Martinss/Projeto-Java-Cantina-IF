package model.CadastrarFuncionarios;

import java.util.Scanner;
import java.util.ArrayList;

import model.Administrativo;
import model.Atendente;
import model.Funcionarios;

public class CadastroFuncionarios {
    // Lista estática para manter os funcionários cadastrados
    public static ArrayList<Funcionarios> Cadastrofuncionario = new ArrayList<>();

    // Construtor para adicionar funcionários pré-criados
    static {
        // Adicionando funcionários
        Administrativo adm1 = new Administrativo("Jonas", 6000, 2, "ADM");
        Administrativo adm2 = new Administrativo("Wesley", 6000, 1, "ADM");

        Atendente a1 = new Atendente("Lourdes", 2000, 3, "Atendente");
        Atendente a2 = new Atendente("Maria", 2000, 4, "Atendente");

        Cadastrofuncionario.add(adm1);
        Cadastrofuncionario.add(adm2);
        Cadastrofuncionario.add(a1);
        Cadastrofuncionario.add(a2);
    }

    // Cadastrar novos funcionários
    public void CadastroFuncionarios(Scanner scanner) {
        System.out.println("Digite o nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();

        System.out.println("Digite o salário do funcionário: ");
        double salarioFuncionario = scanner.nextDouble();

        System.out.println("Digite o ID do funcionário: ");
        int idFuncionario = scanner.nextInt();

        if (VerificarDuplicidadeID(idFuncionario)) {
            System.out.println("Erro: O ID " + idFuncionario + " já está cadastrado.");
            return; // Não continua o cadastro se o ID for duplicado
        }

        // Limpando o buffer
        scanner.nextLine();

        System.out.println("Qual o cargo do funcionário? [1] Administrativo [2] Atendente [0] Cancelar cadastro");
        int opcaoCargo = scanner.nextInt();
        // Limpando o buffer após a escolha do cargo
        scanner.nextLine();

        String cargoFuncionario = null;

        switch (opcaoCargo) {
            case 1:
                cargoFuncionario = "ADM";
                break;
            case 2:
                cargoFuncionario = "Atendente";
                break;
            case 0:
                System.out.println("Cadastro cancelado.");
                return; // Cancelar o cadastro
            default:
                System.out.println("Cargo inválido.");
                return; // Interrompe o cadastro se o cargo for inválido
        }

        // Adicionando o novo funcionário à lista
        if ("ADM".equals(cargoFuncionario)) {
            Administrativo novoAdm = new Administrativo(nomeFuncionario, salarioFuncionario, idFuncionario, cargoFuncionario);
            Cadastrofuncionario.add(novoAdm);
        } else if ("Atendente".equals(cargoFuncionario)) {
            Atendente novoAtendente = new Atendente(nomeFuncionario, salarioFuncionario, idFuncionario, cargoFuncionario);
            Cadastrofuncionario.add(novoAtendente);
        }

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    //Exibir lista de funcionarios
    public static void exibirFuncionarios(ArrayList<Funcionarios> Cadastrofuncionario){
        System.out.println("Lista de funcionarios: ");
        for(Funcionarios funTemp : Cadastrofuncionario){
            System.out.println();
            System.out.println(funTemp);
        }
    }
    // Método para verificar duplicidade de ID
    public static boolean VerificarDuplicidadeID(int idFuncionario) {
        for (Funcionarios funcionario : Cadastrofuncionario) {
            if (funcionario.getID() == idFuncionario) {
                return true; // Funcionário já existe
            }
        }
        return false; // ID do funcionário não existe
    }
}
