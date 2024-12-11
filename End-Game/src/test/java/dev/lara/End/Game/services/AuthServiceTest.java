package dev.lara.End.Game.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.lara.End.Game.models.Usuario;

public class AuthServiceTest {
    private AuthService authService;
    private UsuarioRepositoryInMemory usuarioRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        usuarioRepository = new UsuarioRepositoryInMemory();
        passwordEncoder = new BCryptPasswordEncoder();
        authService = new AuthService(usuarioRepository, passwordEncoder);
    }

    @Test
    void testAuthenticateSuccess() {
      
        String correo = "test@example.com";
        String rawPassword = "password123";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setCorreo(correo);
        usuario.setPassword(encodedPassword);

        usuarioRepository.save(usuario);

        Usuario authenticatedUser = authService.authenticate(correo, rawPassword);

        assertNotNull(authenticatedUser);
        assertEquals(correo, authenticatedUser.getCorreo());
    }

    @Test
    void testAuthenticateUserNotFound() {

        String correo = "nonexistent@example.com";
        String password = "password123";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            authService.authenticate(correo, password);
        });

        assertEquals("Usuario no encontrado", exception.getMessage());
    }

    @Test
    void testAuthenticateIncorrectPassword() {

        String correo = "test@example.com";
        String rawPassword = "password123";
        String wrongPassword = "wrongpassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setCorreo(correo);
        usuario.setPassword(encodedPassword);

        usuarioRepository.save(usuario);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            authService.authenticate(correo, wrongPassword);
        });

        assertEquals("Credenciales incorrectas", exception.getMessage());
    }
}