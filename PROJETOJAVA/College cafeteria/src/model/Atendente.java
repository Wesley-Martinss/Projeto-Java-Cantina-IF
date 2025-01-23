package model;

public class Atendente extends Funcionarios {
    public Atendente(String nome, double salario, int id, String cargo){
        super(nome, salario, id, cargo);
    }

    @Override
    public double CalcularSalario(){
        return this.getSalario() * 2;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
