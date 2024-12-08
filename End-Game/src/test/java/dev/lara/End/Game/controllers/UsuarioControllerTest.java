package dev.lara.End.Game.controllers;

import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.services.UsuariosService;
import dev.lara.End.Game.repositories.RolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UsuarioControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UsuariosService usuariosService;

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
    }

    @Test
    void testRegistrarUsuario() throws Exception {
    
        Rol rol = new Rol(1, "ADMIN");
        when(rolRepository.findByNombreRol("ADMIN")).thenReturn(Optional.of(rol));

        UsuarioDTO usuarioDTO = new UsuarioDTO(0, "juan", "juan@mail.com", new RolDTO(1, "ADMIN"), "password");

        UsuarioDTO usuarioRegistrado = new UsuarioDTO(1, "juan", "juan@mail.com", new RolDTO(1, "ADMIN"), "password");
        when(usuariosService.registrarUsuario(usuarioDTO.getNombreUsuario(), usuarioDTO.getCorreo(), usuarioDTO.getPassword(), rol))
                .thenReturn(usuarioRegistrado);

        mockMvc.perform(post("/api/usuarios/public/registrar")
                        .contentType("application/json")
                        .content("{ \"nombreUsuario\": \"juan\", \"correo\": \"juan@mail.com\", \"password\": \"password\", \"rolNombre\": \"ADMIN\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreUsuario").value("juan"))
                .andExpect(jsonPath("$.correo").value("juan@mail.com"))
                .andExpect(jsonPath("$.rol.nombreRol").value("ADMIN"));

        verify(rolRepository, times(1)).findByNombreRol("ADMIN");
        verify(usuariosService, times(1)).registrarUsuario("juan", "juan@mail.com", "password", rol);
    }

    @Test
    void testBorrarUsuario() throws Exception {
       
        doNothing().when(usuariosService).borrarUsuario(1);

        mockMvc.perform(delete("/api/usuarios/borrar/1"))
                .andExpect(status().isNoContent());

        verify(usuariosService, times(1)).borrarUsuario(1);
    }
}
