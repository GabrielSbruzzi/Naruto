package com.naruto.Naruto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naruto.Naruto.entity.Personagem;
import com.naruto.Naruto.entity.Jutsu;
import com.naruto.Naruto.service.PersonagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonagemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonagemService personagemService;

    private ObjectMapper objectMapper;

    private Personagem personagem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        personagem = new Personagem("Naruto", 16, "Aldeia da Folha", 100);
    }

    @Test
    void testarAdicionarPersonagem() throws Exception {
        when(personagemService.adicionarPersonagem(any(Personagem.class))).thenReturn(personagem);

        mockMvc.perform(post("/personagens")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personagem)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Naruto"));

        verify(personagemService, times(1)).adicionarPersonagem(any(Personagem.class));
    }

    @Test
    void testarAdicionarPersonagemErro() throws Exception {
        when(personagemService.adicionarPersonagem(any(Personagem.class))).thenThrow(new RuntimeException("Erro ao salvar personagem"));

        mockMvc.perform(post("/personagens")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personagem)))
                .andExpect(status().isInternalServerError());

        verify(personagemService, times(1)).adicionarPersonagem(any(Personagem.class));
    }

    @Test
    void testarListarPersonagens() throws Exception {
        when(personagemService.listarPersonagens()).thenReturn(Collections.singletonList(personagem));

        mockMvc.perform(get("/personagens"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Naruto"));

        verify(personagemService, times(1)).listarPersonagens();
    }

    @Test
    void testarListarPersonagensVazio() throws Exception {
        when(personagemService.listarPersonagens()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/personagens"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());

        verify(personagemService, times(1)).listarPersonagens();
    }

    @Test
    void testarBuscarPersonagem() throws Exception {
        when(personagemService.buscarPersonagem("Naruto")).thenReturn(personagem);

        mockMvc.perform(get("/personagens/Naruto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Naruto"));

        verify(personagemService, times(1)).buscarPersonagem("Naruto");
    }

    @Test
    void testarBuscarPersonagemNaoEncontrado() throws Exception {
        when(personagemService.buscarPersonagem("Sasuke")).thenReturn(null);

        mockMvc.perform(get("/personagens/Sasuke"))
                .andExpect(status().isNotFound());

        verify(personagemService, times(1)).buscarPersonagem("Sasuke");
    }

    @Test
    void testarAdicionarJutsu() throws Exception {
        Jutsu jutsu = new Jutsu("Rasengan", "Jutsu de chakra em espiral");
        doNothing().when(personagemService).adicionarJutsu(eq("Naruto"), eq("Rasengan"));

        mockMvc.perform(post("/personagens/Naruto/adicionarJutsu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jutsu)))
                .andExpect(status().isOk());

        verify(personagemService, times(1)).adicionarJutsu(eq("Naruto"), eq("Rasengan"));
    }

    @Test
    void testarAdicionarJutsuPersonagemNaoEncontrado() throws Exception {
        Jutsu jutsu = new Jutsu("Chidori", "Jutsu relâmpago");
        doThrow(new RuntimeException("Personagem não encontrado")).when(personagemService).adicionarJutsu(eq("Sasuke"), eq("Chidori"));

        mockMvc.perform(post("/personagens/Sasuke/adicionarJutsu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jutsu)))
                .andExpect(status().isInternalServerError()); // Espera o erro 500

        verify(personagemService, times(1)).adicionarJutsu(eq("Sasuke"), eq("Chidori"));
    }


    @Test
    void testarAumentarChakra() throws Exception {
        doNothing().when(personagemService).aumentarChakra(eq("Naruto"), eq(50));

        mockMvc.perform(post("/personagens/Naruto/aumentarChakra")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("50"))
                .andExpect(status().isOk());

        verify(personagemService, times(1)).aumentarChakra(eq("Naruto"), eq(50));
    }
}
