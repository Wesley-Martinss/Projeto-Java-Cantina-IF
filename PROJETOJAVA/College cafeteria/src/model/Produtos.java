package model;

public class Produtos {
    private int id;
    private String descricao;
    private double preco;

    public Produtos(int id, String descricao, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    // get retorna
    // set modifica

    public int getID(int id) {
        return id;

    }

    public void setID(int id) {
        this.id = id;
    }

    public String getDescricao(String descricao) {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco(double preco) {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
