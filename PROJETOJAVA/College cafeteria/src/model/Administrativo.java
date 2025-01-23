package model;

public class Administrativo extends Funcionarios {
    public Administrativo(String nome, double salario, int id, String cargo){
        super(nome, salario, id, cargo);
        
    }

    public double CalcularSalario(){
        return this.getSalario() * 2;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
