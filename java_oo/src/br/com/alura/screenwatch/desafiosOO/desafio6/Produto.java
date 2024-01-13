package br.com.alura.screenwatch.desafiosOO.desafio6;

public class Produto implements Vendavel {
    private String nome;
    private double preco;

    // getters and setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public float calcularPrecoTotal(int quantidadeComprada) {
        double desconto = 0;
        if (quantidadeComprada >= 10 && quantidadeComprada <= 30) {
            desconto = 0.1;
        } else if (quantidadeComprada > 30 && quantidadeComprada <= 100) {
            desconto = 0.15;
        } else if (quantidadeComprada > 100) {
            desconto = 0.2;
        }

        return (float) ((this.preco * (1 - desconto)) * quantidadeComprada);
    }
}
