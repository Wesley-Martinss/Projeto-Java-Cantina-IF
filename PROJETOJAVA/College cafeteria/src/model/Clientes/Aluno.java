package model.Clientes;

public class Aluno {
    private int ra;
    private String nome;
    private double saldo;

    public Aluno(int ra, String nome, double saldo) {
        this.ra = ra;
        this.nome = nome;
        this.saldo = saldo;
    }

    // get retorna
    // set modifica

    public int getRA() {
        return this.ra;
    }

    public void setRA(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\nAluno: " + nome + "\nRA(REGISTRO ALUNO): " + ra  + "\nSaldo Aluno: " + saldo + "$\n";
    }
    

}
