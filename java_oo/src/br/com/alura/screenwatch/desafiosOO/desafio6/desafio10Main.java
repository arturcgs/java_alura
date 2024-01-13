package br.com.alura.screenwatch.desafiosOO.desafio6;

public class desafio10Main {
    public static void main(String[] args) {
        // criando produtos

        Produto coca = new Produto();
        coca.setNome("Coca");
        coca.setPreco(8.50);

        Produto arroz = new Produto();
        arroz.setNome("Arroz");
        arroz.setPreco(18.78);

        System.out.println(coca.calcularPrecoTotal(8));
        System.out.println(coca.calcularPrecoTotal(12));
        System.out.println(coca.calcularPrecoTotal(50));
        System.out.println(coca.calcularPrecoTotal(130));







    }
}
