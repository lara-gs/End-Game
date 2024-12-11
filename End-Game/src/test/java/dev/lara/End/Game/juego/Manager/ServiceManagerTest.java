/*package dev.lara.End.Game.juego.Manager;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.lara.End.Game.config.LoginRequest;
import dev.lara.End.Game.config.LoginResponse;
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
    private UsuarioController userController;

    @InjectMocks
    private ServiceManager serviceManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLogin() {

        LoginRequest request = new LoginRequest();
        request.setCorreo("user");
        request.setPassword("password");

        UsuarioDTO usuarioMock = new UsuarioDTO();
        LoginResponse response = new LoginResponse("Success", "user@example.com", usuarioMock);

        when(authController.login(request)).thenReturn(response);

        LoginResponse result = serviceManager.login(request);

        assertEquals(response.getMessage(), result.getMessage());
        assertEquals(response.getEmail(), result.getEmail());
        assertEquals(response.getUsuarioDTO(), result.getUsuarioDTO());

        verify(authController).login(request);
    }
}    */