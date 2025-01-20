package com.naruto.Naruto.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String aldeia;

    private List<String> jutsus;

    private int chakra;

    public Personagem(String nome, int idade, String aldeia, int chakra, int i) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus = new ArrayList<>();
        this.chakra = chakra;
    }

    public void adicionarJutsu(String jutsu) {
        jutsus.add(jutsu);
    }

    public void aumentarChakra(int quantidade) {
        this.chakra += quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Jutsus: " + jutsus);
        System.out.println("Chakra: " + chakra);
    }

    public String getNome() {
        return this.nome;
    }
}
