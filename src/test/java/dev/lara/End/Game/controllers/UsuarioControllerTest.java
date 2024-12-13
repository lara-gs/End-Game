package dev.lara.End.Game.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.services.RolService;
import dev.lara.End.Game.services.UsuariosService;

class UsuarioControllerTest {

    @Mock
    private RolRepository rolRepository;

    @Mock
    private UsuariosService usuariosService;

    @Mock
    private RolService rolService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBorrarPartida() {
        int idUsuario = 1;
        doNothing().when(usuariosService).borrarUsuario(idUsuario);

        ResponseEntity<Void> response = usuarioController.borrarPartida(idUsuario);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(usuariosService, times(1)).borrarUsuario(idUsuario);
    }

    @SuppressWarnings("null")
    @Test
    void testRegistrarUsuario_RolEncontrado() {

        String rolNombre = "Admin";
        UsuarioDTO usuarioDTO = new UsuarioDTO(1, "Lara", "lara@example.com", null, "password");
        usuarioDTO.setRolNombre(rolNombre);
        Rol rol = new Rol();
        rol.setNombreRol(rolNombre);

        when(rolRepository.findByNombreRol(rolNombre)).thenReturn(Optional.of(rol));
        when(usuariosService.registrarUsuario(
                usuarioDTO.getNombreUsuario(),
                usuarioDTO.getCorreo(),
                usuarioDTO.getPassword(),
                rol)).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> response = usuarioController.registrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(usuarioDTO.getNombreUsuario(), response.getBody().getNombreUsuario());
        assertEquals(usuarioDTO.getCorreo(), response.getBody().getCorreo());
        verify(rolRepository, times(1)).findByNombreRol(rolNombre);
        verify(usuariosService, times(1)).registrarUsuario(
                usuarioDTO.getNombreUsuario(),
                usuarioDTO.getCorreo(),
                usuarioDTO.getPassword(),
                rol);
    }

    @Test
    void testRegistrarUsuario_RolNoEncontrado() {

        String rolNombre = "User";
        UsuarioDTO usuarioDTO = new UsuarioDTO(1, "Lara", "lara@example.com", null, "password");
        usuarioDTO.setRolNombre(rolNombre);

        when(rolRepository.findByNombreRol(rolNombre)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            usuarioController.registrarUsuario(usuarioDTO);
        });

        assertEquals("Rol no encontrado con nombre " + rolNombre, exception.getMessage());
        verify(rolRepository, times(1)).findByNombreRol(rolNombre);
        verifyNoInteractions(usuariosService);
    }
}
