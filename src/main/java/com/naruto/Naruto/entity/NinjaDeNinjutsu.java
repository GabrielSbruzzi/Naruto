package com.naruto.Naruto.entity;

import jakarta.persistence.Entity;

@Entity
public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra, 100);
    }

    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Ninjutsu!");
    }

    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Ninjutsu!");
    }
}
