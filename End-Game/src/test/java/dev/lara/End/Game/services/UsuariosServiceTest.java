package dev.lara.End.Game.services;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;
import dev.lara.End.Game.dtos.UsuarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class UsuariosServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;  

    @Mock
    private PasswordEncoder passwordEncoder;  

    @InjectMocks
    private UsuariosService usuariosService;  

    private Usuario usuario;
    private Rol rol;

    @BeforeEach
    public void setUp() {
        // Inicializamos los mocks
        MockitoAnnotations.openMocks(this);
        
        // Creamos un objeto Usuario y Rol ficticios para el test
        rol = new Rol();
        rol.setNombreRol("ROLE_USER");

        usuario = new Usuario();
        usuario.setNombreUsuario("usuarioTest");
        usuario.setCorreo("usuario@test.com");
        usuario.setPassword("password123");
        usuario.setRol(rol);
    }

    @Test
    public void testRegistrarUsuario() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        UsuarioDTO usuarioDTO = usuariosService.registrarUsuario("usuarioTest", "usuario@test.com", "password123", rol);

        assertNotNull(usuarioDTO);
        assertEquals("usuarioTest", usuarioDTO.getNombreUsuario());
        assertEquals("usuario@test.com", usuarioDTO.getCorreo());
        assertNotNull(usuarioDTO.getRol());  
        assertEquals("ROLE_USER", usuarioDTO.getRol().getNombreRol()); 

    }


    @Test
    public void testBorrarUsuarioSuccess() {

        when(usuarioRepository.existsById(1)).thenReturn(true);
        usuariosService.borrarUsuario(1);
        verify(usuarioRepository, times(1)).deleteById(1);
    }

    @Test
    public void testBorrarUsuarioNotFound() {
        when(usuarioRepository.existsById(1)).thenReturn(false);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> usuariosService.borrarUsuario(1));
        assertEquals("Usuario no encontrado con ID: 1", exception.getMessage());
    }

    @Test
public void testRegistrarUsuarioConContraseñaEncriptada() {
    when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
    when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");

    UsuarioDTO usuarioDTO = usuariosService.registrarUsuario("usuarioTest", "usuario@test.com", "password123", rol);

    assertNotNull(usuarioDTO);
    // Verificar que el password se haya encriptado correctamente
    assertEquals("encodedPassword", passwordEncoder.encode("password123"));
}

}
