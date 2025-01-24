package com.naruto.Naruto.entity;

public class Jutsu {

    private String nome;
    private String descricao;

    // Construtor padrão
    public Jutsu() {
    }

    // Construtor com argumentos
    public Jutsu(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Jutsu(String rasengan, int i, int i1, String s) {
    }

    public String getNome() {
        return nome;
    }
}
