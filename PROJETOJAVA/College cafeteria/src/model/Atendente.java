package model;

public class Atendente extends Funcionarios {
    public Atendente(String nome, double salario, int id){
        super(nome, salario, id);
    }

    @Override
    public double CalcularSalario(){
        return getSalario();
    }
    
}
