package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
    
        usuario = new Usuario();
        usuario.setNombreUsuario("testuser");
        usuario.setPassword("testpassword");
        usuario.setRol(new Rol("USER")); 
    }

    @Test
    public void testLoadUserByUsernameSuccess() {

        when(usuarioRepository.findByNombreUsuario("testuser")).thenReturn(java.util.Optional.of(usuario));
        UserDetails userDetails = userDetailsService.loadUserByUsername("testuser");
        assertNotNull(userDetails);
        assertEquals("testuser", userDetails.getUsername());
        assertEquals("testpassword", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream()
            .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER"))); // Spring añadirá ROLE_ automáticamente
    }

    @Test
    public void testLoadUserByUsernameUserNotFound() {

        when(usuarioRepository.findByNombreUsuario("testuser")).thenReturn(java.util.Optional.empty());
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("testuser");
        });

        assertEquals("Usuario no encontrado: testuser", exception.getMessage());
    }
}
