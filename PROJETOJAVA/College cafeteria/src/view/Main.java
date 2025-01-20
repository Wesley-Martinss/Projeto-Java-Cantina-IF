package view;

import model.Cliente;

public class Main {
    public static void main(String[] args) {
        

        Cliente cliente1 = new Cliente("Higor", "(99) 99999-9999", "higor901@gmail.com","Araraquara");
        Cliente cliente2 = new Cliente("Yasmin", "(99) 99999-9999", "Yasmin201@gmail.com", "Araraquara");
        Cliente cliente3 = new Cliente("Taynara", "(99) 99999-9999", "ivone09832@gmail.com", "Araraquara");


        
        System.out.println("CLIENTE: " + cliente1.getNome() + " TELEFONE: " + cliente1.getTelefone() + " EMAIL: " + cliente1.getEmail() + " ENDERECO: " + cliente1.getEndereco());
        System.out.println("CLIENTE: " + cliente2.getNome() + " TELEFONE: " + cliente2.getTelefone() + " EMAIL: " + cliente2.getEmail() + " ENDERECO: " + cliente2.getEndereco());
        System.out.println("CLIENTE: " + cliente3.getNome() + " TELEFONE: " + cliente3.getTelefone() + " EMAIL: " + cliente3.getEmail() + " ENDERECO: " + cliente3.getEndereco());
        














    }
}
