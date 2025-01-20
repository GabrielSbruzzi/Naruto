package com.naruto.Naruto.entity;

public class Jutsu {

    private String nome;

    public Jutsu(String nome, int dano, int consumoDeChakra, String descricao) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
