package model;

public class Produtos {
    private int id;
    private String descricao;
    private double preco;
    private int estoque;
    private int QuantidadeVendida = 0;

    // Construtor para inicializar o produto
    public Produtos(int id, String descricao, double preco, int estoque, int QuantidadeVendida) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.QuantidadeVendida = QuantidadeVendida;
    }

    // Get e set
    // get retorna
    // set modifica
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

    public int getQuantidadeVendida() {
        return QuantidadeVendida;
    }

    public void setQuantidadeVendida(int QuantidadeVendida) {
        this.QuantidadeVendida = QuantidadeVendida;
    }

    // Metodo para incrementar a quantidadeVendida
    public void incrementarQuantidadeVendida() {
        this.QuantidadeVendida++;
    }

    // Metodo para exibir as informações do produto
    @Override
    public String toString() {
        return "ID: " + id + "\nDescrição: " + descricao + "\nPreço: " + preco + " $" + "\nEstoque: " + estoque;
    }
}
