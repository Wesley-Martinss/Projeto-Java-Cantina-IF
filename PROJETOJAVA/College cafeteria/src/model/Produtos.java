package model;

public class Produtos {
    private int id;
    private String descricao;
    private double preco;
    private int estoque;

    // Construtor para inicializar o produto
    public Produtos(int id, String descricao, double preco, int estoque) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Métodos getters e setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    // Método para exibir as informações do produto
    @Override
    public String toString() {
        return "ID: " + id + "\nDescrição: " + descricao + "\nPreço: " + preco + " $" + "\nEstoque: " + estoque;
    }
}

