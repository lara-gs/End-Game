package dev.lara.End.Game.juego.Manager;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import dev.lara.End.Game.controllers.*;
import dev.lara.End.Game.dtos.*;

class ServiceManagerTest {

    @Mock
    private AuthController authController;

    @Mock
    private HistoriaController historiaController;

    @Mock
    private OpcionesController opcionesController;

    @Mock
    private ProgresoController progresoController;

    @Mock
    private RolController rolController;

    @Mock
    private UsuarioController usuarioController;

    @InjectMocks
    private ServiceManager serviceManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testRegisterUser() {
        UsuarioDTO usuario = new UsuarioDTO(1, "Lara", "lara@example.com", null, "password");

        when(usuarioController.registrarUsuario(usuario)).thenReturn(ResponseEntity.ok(usuario));

        UsuarioDTO actualUsuario = serviceManager.registerUser(usuario);

        assertEquals(usuario, actualUsuario);
        verify(usuarioController, times(1)).registrarUsuario(usuario);
    }



    @Test
    void testCargarHistorias() {
        List<HistoriaDTO> expectedHistorias = Arrays.asList(new HistoriaDTO(1, "Historia 1"));

        when(historiaController.cargarHistoria()).thenReturn(ResponseEntity.ok(expectedHistorias));

        List<HistoriaDTO> actualHistorias = serviceManager.cargarHistorias();

        assertEquals(expectedHistorias, actualHistorias);
        verify(historiaController, times(1)).cargarHistoria();
    }

    @Test
    void testGuardarPartida() {

        ProgresoDTO progreso = new ProgresoDTO(1, 1, 1, LocalDate.now(), "Historia 1");

        when(progresoController.guardarPartida(progreso)).thenReturn(ResponseEntity.ok(progreso));

        ProgresoDTO actualProgreso = serviceManager.guardarPartida(progreso);

        assertEquals(progreso, actualProgreso);
        verify(progresoController, times(1)).guardarPartida(progreso);
    }

    @Test
    void testCargarRoles() {

        List<RolDTO> expectedRoles = Arrays.asList(new RolDTO(1, "Admin"));

        when(rolController.cargarRoles()).thenReturn(ResponseEntity.ok(expectedRoles));

        List<RolDTO> actualRoles = serviceManager.cargarRoles();

        assertEquals(expectedRoles, actualRoles);
        verify(rolController, times(1)).cargarRoles();
    }
}
