package dev.lara.End.Game.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;


import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.services.HistoriaService;


@WebMvcTest(HistoriaController.class)
class HistoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoriaService historiaService;

    @Test
    @WithMockUser(username = "testUser", roles = "USER") // Simula un usuario autenticado
    void testCargarHistoria() throws Exception {
        List<HistoriaDTO> historiasMock = Arrays.asList(
            new HistoriaDTO(1, "Primera historia"),
            new HistoriaDTO(2, "Segunda historia")
        );
    
        when(historiaService.cargarHistoria()).thenReturn(historiasMock);
    
        mockMvc.perform(get("/api/historia/historias")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].idHistoria").value(1))
                .andExpect(jsonPath("$[0].descripcion").value("Primera historia"))
                .andExpect(jsonPath("$[1].idHistoria").value(2))
                .andExpect(jsonPath("$[1].descripcion").value("Segunda historia"));
    }
    
}