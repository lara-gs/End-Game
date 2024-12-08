package dev.lara.End.Game.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;

import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.services.OpcionesService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

@WebMvcTest(OpcionesController.class)
@ExtendWith(MockitoExtension.class)
public class OpcionesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpcionesService opcionesService;

    @Test
    @WithMockUser(username = "testUser", roles = "USER") // Simula un usuario autenticado
    void testCargarOpciones() throws Exception {
        // Crear datos de prueba
        List<OpcionesDTO> opciones = Arrays.asList(
            new OpcionesDTO(1, 1, 1, 2, 0, "Opción 1"),
            new OpcionesDTO(2, 1, 2, 3, 0, "Opción 2")
        );

        // Configurar el servicio mockeado
        when(opcionesService.cargarOpciones(1)).thenReturn(opciones);

        // Realizar la solicitud GET y verificar la respuesta
        mockMvc.perform(get("/api/opciones/1"))
            .andExpect(status().isOk()) // Esperar código de estado 200 OK
            .andExpect(jsonPath("$.size()").value(2)) // Verificar el tamaño de la lista
            .andExpect(jsonPath("$[0].idProgreso").value(1)) // Verificar el primer elemento
            .andExpect(jsonPath("$[0].descripcion").value("Opción 1"))
            .andExpect(jsonPath("$[1].idProgreso").value(2)) // Verificar el segundo elemento
            .andExpect(jsonPath("$[1].descripcion").value("Opción 2"));
    }
}
