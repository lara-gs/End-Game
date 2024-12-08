package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAuthenticateSuccess() {
        Usuario usuario = new Usuario();
        usuario.setCorreo("juan@mail.com");
        usuario.setPassword("$2a$10$E6vU.nVs6WzZ1eD42G0pO.bTxocqzfe9aqQd4EdtuwH6sF4PekjBe"); 

        when(usuarioRepository.findByCorreo("juan@mail.com")).thenReturn(Optional.of(usuario));

        when(passwordEncoder.matches("password123", usuario.getPassword())).thenReturn(true);

        String resultado = authService.authenticate("juan@mail.com", "password123");
        assertEquals("Autenticación exitosa", resultado);

        verify(usuarioRepository, times(1)).findByCorreo("juan@mail.com");
        verify(passwordEncoder, times(1)).matches("password123", usuario.getPassword());
    }

    @Test
    void testAuthenticateUserNotFound() {
 
        when(usuarioRepository.findByCorreo("juan@mail.com")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.authenticate("juan@mail.com", "password123");
        });

        assertEquals("Usuario no encontrado", exception.getMessage());
        verify(usuarioRepository, times(1)).findByCorreo("juan@mail.com");
    }

    @Test
    void testAuthenticateIncorrectPassword() {
        // Simulamos un usuario con correo "juan@mail.com" y contraseña "password123"
        Usuario usuario = new Usuario();
        usuario.setCorreo("juan@mail.com");
        usuario.setPassword("$2a$10$E6vU.nVs6WzZ1eD42G0pO.bTxocqzfe9aqQd4EdtuwH6sF4PekjBe"); 

        when(usuarioRepository.findByCorreo("juan@mail.com")).thenReturn(Optional.of(usuario));

        when(passwordEncoder.matches("wrongpassword", usuario.getPassword())).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.authenticate("juan@mail.com", "wrongpassword");
        });

        assertEquals("Credenciales incorrectas", exception.getMessage());

        verify(usuarioRepository, times(1)).findByCorreo("juan@mail.com");
        verify(passwordEncoder, times(1)).matches("wrongpassword", usuario.getPassword());
    }
}
