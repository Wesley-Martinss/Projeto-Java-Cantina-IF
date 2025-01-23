package control;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Funcionarios;

public class MenuControll {
    public static boolean AberturaCantina = false;
    // Separando a lógica de verificação de funcionário

    private boolean verificarFuncionario(int idFuncionario, ArrayList<Funcionarios> funcionarios) {
        for (Funcionarios func : funcionarios) {
            if (idFuncionario == func.getID()) {
                System.out.println("Funcionário encontrado: " + func);
                System.out.println();
                return true; // Retorna verdadeiro se o funcionário for encontrado
            }
        }
        System.out.println("Funcionário não encontrado com o ID informado.");
        return false; // Retorna falso se o funcionário não for encontrado
    }
    public void abrirCantina(Scanner scanner, ArrayList<Funcionarios> funcionarios) {
        if(AberturaCantina == true){
            System.out.println("A cantina já esta aberta");
            return;
        }
        System.out.println("Você é Atendente ou Administrativo? [sim] ou [não]");
        String condicao = scanner.nextLine();
        if ("sim".equalsIgnoreCase(condicao)) {
            System.out.println("Digite seu ID de Funcionário:");
            int IDADM = scanner.nextInt();
            if (verificarFuncionario(IDADM, funcionarios)) {
                //Mostrar data e hora que a cantina foi aberta
                LocalDate hoje = LocalDate.now();
                LocalTime agora = LocalTime.now();
                //formatando Hora
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                String horaFormatada = agora.format(formatoHora);
                System.out.println("Cantina aberta hoje, dia: " + hoje + " Hora: " + horaFormatada);
                AberturaCantina = true; // Abertura da cantina confirmada
            }
        }
    }


}
