package com.naruto.Naruto.entity;

import jakarta.persistence.Entity;

@Entity
public class NinjaDeTaijutsu extends Personagem implements Ninja {

    public NinjaDeTaijutsu(String nome, int idade, String aldeia, int chakara) {
        super(nome, idade, aldeia, chakara, 100);
    }

    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Taijutsu!");
    }

    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Taijutsu!");
    }
}
