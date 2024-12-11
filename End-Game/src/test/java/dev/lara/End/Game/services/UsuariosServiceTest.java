package dev.lara.End.Game.services;

import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuariosServiceTest {

    @InjectMocks
    private UsuariosService usuariosService;
    @Autowired
    private UsuarioRepositoryInMemory usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private Rol rol;

    @BeforeEach
    void setUp() {
        usuarioRepository = new UsuarioRepositoryInMemory();
        usuariosService = new UsuariosService(usuarioRepository, passwordEncoder);

        MockitoAnnotations.openMocks(this);
        rol = new Rol();
        rol.setId(1);
        rol.setNombreRol("ADMIN");
    }

    @Test
    void testRegistrarUsuario() {
        String nombreUsuario = "usuarioTest";
        String correo = "test@correo.com";
        String password = "contraseña";

        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");

        UsuarioDTO usuarioDTO = usuariosService.registrarUsuario(nombreUsuario, correo, password, rol);

        assertNotNull(usuarioDTO);
        assertEquals(nombreUsuario, usuarioDTO.getNombreUsuario());
        assertEquals(correo, usuarioDTO.getCorreo());
        assertEquals("contraseña", usuarioDTO.getPassword());
        assertEquals("ADMIN", usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testBorrarUsuarioExistente() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuarioRepository.save(usuario);

        usuariosService.borrarUsuario(1);

        assertFalse(usuarioRepository.existsById(1));
    }

    @Test
    void testBorrarUsuarioNoExistente() {
        assertThrows(RuntimeException.class, () -> usuariosService.borrarUsuario(1));
    }
}
