package dev.lara.End.Game.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;

@WebMvcTest(ProgresoController.class)
@Import({MockMvcAutoConfiguration.class}) // Asegura que la configuración de MockMvc se importe correctamente
@EnableWebSecurity // Habilita la seguridad en los tests, si es necesario
@WithMockUser(username = "testUser", roles = "USER") // Simula un usuario autenticado con un rol específico
public class ProgresoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Test para cargarPartida (GET)
    @Test
    void testCargarPartida() throws Exception {
        mockMvc.perform(get("/api/progreso/cargar/1"))
                .andExpect(status().isOk()); // Verifica que la respuesta sea 200 OK
    }

    // Test para borrarPartida (DELETE)
    @Test
    void testBorrarPartida() throws Exception {
        mockMvc.perform(delete("/api/progreso/borrar/1"))
                .andExpect(status().isNoContent()); // Verifica que la respuesta sea 204 No Content
    }

    // Test para guardarPartida (POST)
    @Test
    void testGuardarPartida() throws Exception {
        mockMvc.perform(post("/api/progreso/guardar")
                .contentType("application/json")
                .content("{\"idUsuario\": 1, \"idHistoria\": 1}"))
                .andExpect(status().isCreated()); // Verifica que la respuesta sea 201 Created
    }
}
