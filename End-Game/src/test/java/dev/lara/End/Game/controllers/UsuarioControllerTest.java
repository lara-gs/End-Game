package dev.lara.End.Game.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.services.UsuariosService;
import dev.lara.End.Game.repositories.RolRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@WebMvcTest(UsuarioController.class)
@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuariosService usuariosService;

    @MockBean
    private RolRepository rolRepository;

    // Test para el método borrarPartida
    @Test
    void testBorrarPartida() throws Exception {
        int idUsuario = 1; // Usuario de prueba

        // Realizar la solicitud DELETE
        mockMvc.perform(delete("/api/usuarios/borrar/{IdUsuario}", idUsuario))
            .andExpect(status().isNoContent()); // Verificar que el código de estado sea 204 No Content

        // Verificar que el servicio de usuarios haya sido llamado para borrar al usuario
        verify(usuariosService).borrarUsuario(idUsuario);
    }

    // Test para el método registrarUsuario
    @Test
    void testRegistrarUsuario() throws Exception {
        // Datos de prueba
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Rol rol = new Rol(1, "USER"); // Simulando un rol con id 1 y nombre USER

        // Simulamos que el rol se encuentra en la base de datos
        when(rolRepository.findByNombreRol("USER")).thenReturn(Optional.of(rol));
        
        // Simulamos la respuesta del servicio de usuarios
        when(usuariosService.registrarUsuario("testUser", "test@user.com", "password", rol))
            .thenReturn(usuarioDTO);

        // Realizamos la solicitud POST y verificamos la respuesta
        mockMvc.perform(post("/api/usuarios/public/registrar")
                .contentType("application/json")
                .content("{\"nombreUsuario\": \"testUser\", \"correo\": \"test@user.com\", \"password\": \"password\", \"rolNombre\": \"USER\"}"))
            .andExpect(status().isOk()) // Verificamos que el estado sea 200 OK
            .andExpect(jsonPath("$.nombreUsuario").value("testUser")) // Verificamos que el nombre de usuario sea el esperado
            .andExpect(jsonPath("$.correo").value("test@user.com")); // Verificamos que el correo sea el esperado
    }
}
