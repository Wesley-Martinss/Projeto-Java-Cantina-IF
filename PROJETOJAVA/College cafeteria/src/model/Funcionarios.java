package model;


public abstract class Funcionarios {
    private String nome;
    private double salario;
    private int id;
    private String cargo;

    public Funcionarios(String nome, double salario, int id, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.id = id;
        this.cargo = cargo;
    }

    // get retorna
    // set modifica

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public abstract double CalcularSalario();

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nome: " + nome + "\nSalario: " + CalcularSalario() + "\nID: " +id+ "\nCargo: " +cargo;
    }

}
