package com.naruto.Naruto.controller;

import com.naruto.Naruto.entity.Jutsu;
import com.naruto.Naruto.entity.Personagem;
import com.naruto.Naruto.service.PersonagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    public Personagem adicionarPersonagem(Personagem personagem) {
        return personagemService.adicionarPersonagem(personagem);
    }

    public List<Personagem> listarPersonagens() {
        return personagemService.listarPersonagens();
    }

    @GetMapping("/{nome}")
    public Personagem buscarPersonagem(String nome) {
        return personagemService.buscarPersonagem(nome);
    }

    @PostMapping("/{nome}/adicionarJutsu")
    public void adicionarJutsu(String nome, Jutsu jutsu) {
        personagemService.adicionarJutsu(nome, jutsu.getNome(), jutsu);  // Passando o nome e objeto Jutsu
    }

    @PostMapping("/{nome}/aumentarChakra")
    public void aumentarChakra(String nome, int quantidade) {
        personagemService.aumentarChakra(nome, quantidade);
    }
}
