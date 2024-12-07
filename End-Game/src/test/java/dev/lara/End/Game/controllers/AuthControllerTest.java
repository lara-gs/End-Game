package dev.lara.End.Game.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.lara.End.Game.config.LoginRequest;
import dev.lara.End.Game.services.AuthService;

import static org.mockito.Mockito.*;
@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false) // Desactiva los filtros de seguridad
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testLogin() throws Exception {
        // Configuración del test (igual que antes)
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setCorreo("test@example.com");
        loginRequest.setPassword("password123");

        when(authService.authenticate("test@example.com", "password123"))
                .thenReturn("Autenticación exitosa");

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Autenticación exitosa"))
                .andExpect(jsonPath("$.correo").value("test@example.com"));

        verify(authService).authenticate("test@example.com", "password123");
    }
}