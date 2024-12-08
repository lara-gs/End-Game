package dev.lara.End.Game.controllers;

import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.services.ProgresoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProgresoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProgresoService progresoService;

    @InjectMocks
    private ProgresoController progresoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(progresoController).build();
    }

    @Test
    void testCargarPartida() throws Exception {
     
        ProgresoDTO progresoDTO = new ProgresoDTO(1, 1, 1, null);

        when(progresoService.cargarPartida(1)).thenReturn(progresoDTO);

        mockMvc.perform(get("/api/progreso/cargar/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idProgreso").value(1))
                .andExpect(jsonPath("$.idUsuario").value(1));

        verify(progresoService, times(1)).cargarPartida(1);
    }

    @Test
    void testBorrarPartida() throws Exception {
       
        doNothing().when(progresoService).borrarPartida(1);

        mockMvc.perform(delete("/api/progreso/borrar/1"))
                .andExpect(status().isNoContent());
        verify(progresoService, times(1)).borrarPartida(1);
    }

    @Test
    void testGuardarPartida() throws Exception {
        
        ProgresoDTO progresoDTO = new ProgresoDTO(1, 1, 1, null);

      
        when(progresoService.guardarPartida(1, 1)).thenReturn(progresoDTO);

        
        mockMvc.perform(post("/api/progreso/guardar")
                        .contentType("application/json")
                        .content("{ \"idUsuario\": 1, \"idHistoria\": 1 }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idProgreso").value(1))
                .andExpect(jsonPath("$.idUsuario").value(1));

        verify(progresoService, times(1)).guardarPartida(1, 1);
    }
}
