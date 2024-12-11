/*package dev.lara.End.Game.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.services.RolService;
import dev.lara.End.Game.services.UsuariosService;
import dev.lara.End.Game.repositories.RolRepository;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UsuariosService usuariosService;

    @Mock
    private RolRepository rolRepository;

    @Mock
    private RolService rolService;

    @InjectMocks
    private UsuarioController usuarioController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    void testRegistrarUsuario() throws Exception {
       
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Rol rol = new Rol();
        rol.setNombreRol("USER");

        when(rolRepository.findByNombreRol("USER")).thenReturn(Optional.of(rol));
        when(usuariosService.registrarUsuario("testUser", "test@mail.com", "password", rol))
                .thenReturn(usuarioDTO);

        mockMvc.perform(post("/api/usuarios/public/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuarioDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreUsuario").value("testUser"))
                .andExpect(jsonPath("$.correo").value("test@mail.com"))
                .andExpect(jsonPath("$.rolNombre").value("USER"));

        verify(rolRepository, times(1)).findByNombreRol("USER");
        verify(usuariosService, times(1)).registrarUsuario("testUser", "test@mail.com", "password", rol);
    }

    @Test
    void testBorrarPartida() throws Exception {

        int idUsuario = 1;

        doNothing().when(usuariosService).borrarUsuario(idUsuario);

        mockMvc.perform(delete("/api/usuarios/borrar/" + idUsuario))
                .andExpect(status().isNoContent());

        verify(usuariosService, times(1)).borrarUsuario(idUsuario);
    }
}*/