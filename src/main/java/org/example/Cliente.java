package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void manifestarInteresse(Livro livro) {
        livro.addObserver(this);
    }

    public void update(Observable livro, Object arg1) {
        this.ultimaNotificacao = "Caro(a) " + this.nome + ", o livro " + livro.toString() + ", está disponível!";
    }
}
