package org.example;

import java.util.Observable;

public class Livro extends Observable {
    private String nome;
    private String editora;
    private String autor;
    private int ano;

    public Livro(String nome, String editora, String autor, int ano) {
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.ano = ano;
    }

    public void atualizarEstoque() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        String retorno =  nome + " - " + autor + ", " + editora + ", " + ano;
        return retorno;
    }
}
