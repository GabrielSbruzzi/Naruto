package com.naruto.Naruto.service;

import com.naruto.Naruto.entity.Personagem;
import com.naruto.Naruto.entity.Jutsu;
import com.naruto.Naruto.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public Personagem adicionarPersonagem(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public List<Personagem> listarPersonagens() {
        return personagemRepository.findAll();
    }

    public Personagem buscarPersonagem(String nome) {
        return personagemRepository.findByNome(nome);
    }

    public void adicionarJutsu(String nomePersonagem, String nomeJutsu, Jutsu jutsu) {
        Personagem personagem = personagemRepository.findByNome(nomePersonagem);
        if (personagem != null) {
            personagem.adicionarJutsu(nomeJutsu);
            personagemRepository.save(personagem);
        }
    }

    public void aumentarChakra(String nomePersonagem, int quantidade) {
        Personagem personagem = personagemRepository.findByNome(nomePersonagem);
        if (personagem != null) {
            personagem.aumentarChakra(quantidade);
            personagemRepository.save(personagem);
        }
    }
}
