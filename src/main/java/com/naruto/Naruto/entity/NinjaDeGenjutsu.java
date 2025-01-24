package com.naruto.Naruto.entity;

import jakarta.persistence.Entity;

@Entity
public class NinjaDeGenjutsu extends Personagem implements Ninja {

    public NinjaDeGenjutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra);
    }

    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Genjutsu!");
    }

    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Genjutsu!");
    }
}
