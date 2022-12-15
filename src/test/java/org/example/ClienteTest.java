package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void deveNotificarCliente() {
        Livro livro = new Livro("Orgulho e Preconceito", "Antofágica", "Jane Austen", 2022 );
        Cliente cliente = new Cliente("Lupercio");
        cliente.manifestarInteresse(livro);
        livro.atualizarEstoque();
        assertEquals("Caro(a) Lupercio, o livro Orgulho e Preconceito - Jane Austen, Antofágica, 2022, está disponível!", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Livro livro = new Livro("Orgulho e Preconceito", "Antofágica", "Jane Austen", 2022 );
        Cliente cliente1 = new Cliente("Lupercio");
        cliente1.manifestarInteresse(livro);
        Cliente cliente2 = new Cliente("Graça");
        cliente2.manifestarInteresse(livro);
        livro.atualizarEstoque();
        assertEquals("Caro(a) Lupercio, o livro Orgulho e Preconceito - Jane Austen, Antofágica, 2022, está disponível!", cliente1.getUltimaNotificacao());
        assertEquals("Caro(a) Graça, o livro Orgulho e Preconceito - Jane Austen, Antofágica, 2022, está disponível!", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Livro livro = new Livro("Orgulho e Preconceito", "Antofágica", "Jane Austen", 2022 );
        Cliente cliente = new Cliente("Lupercio");
        livro.atualizarEstoque();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasUmCliente() {
        Livro livro1 = new Livro("Orgulho e Preconceito", "Antofágica", "Jane Austen", 2022 );
        Cliente cliente1 = new Cliente("Lupercio");
        cliente1.manifestarInteresse(livro1);
        Livro livro2 = new Livro("O velho e o mar", "Bertrand Brasil", "\t\n" +
                "Ernest Hemingway", 2013 );
        Cliente cliente2 = new Cliente("Maria Antônia");
        cliente2.manifestarInteresse(livro2);
        livro1.atualizarEstoque();
        assertEquals("Caro(a) Lupercio, o livro Orgulho e Preconceito - Jane Austen, Antofágica, 2022, está disponível!", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}