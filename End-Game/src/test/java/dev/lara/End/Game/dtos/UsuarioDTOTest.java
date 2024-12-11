package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDTOTest {

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    void setUp() {
        Rol rol = new Rol(1, "Administrador");
        usuario = new Usuario(1, rol, "nombreUsuario", "password123", "correo@dominio.com");
        usuarioDTO = new UsuarioDTO(usuario);
    }

    @Test
    void testUsuarioDTOInitialization() {
        assertNotNull(usuarioDTO);
        assertEquals(1, usuarioDTO.getIdUsuario());
        assertEquals("nombreUsuario", usuarioDTO.getNombreUsuario());
        assertEquals("correo@dominio.com", usuarioDTO.getCorreo());
        assertEquals("Administrador", usuarioDTO.getRol().getNombreRol());
        assertEquals("password123", usuarioDTO.getPassword());
    }

    @Test
    void testSetIdUsuario() {
        usuarioDTO.setIdUsuario(2);
        assertEquals(2, usuarioDTO.getIdUsuario());
    }

    @Test
    void testSetNombreUsuario() {
        usuarioDTO.setNombreUsuario("nuevoNombre");
        assertEquals("nuevoNombre", usuarioDTO.getNombreUsuario());
    }

    @Test
    void testSetCorreo() {
        usuarioDTO.setCorreo("nuevo@dominio.com");
        assertEquals("nuevo@dominio.com", usuarioDTO.getCorreo());
    }
    @Test
    void testSetRol() {
        RolDTO nuevoRolDTO = new RolDTO(2, "Editor");
        usuarioDTO.setRol(nuevoRolDTO);
        assertEquals("Editor", usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testSetPassword() {
        usuarioDTO.setPassword("nuevoPassword123");
        assertEquals("nuevoPassword123", usuarioDTO.getPassword());
    }

    @Test
    void testSetRolNombre() {
        usuarioDTO.setRolNombre("Moderador");
        assertEquals("Moderador", usuarioDTO.getRolNombre());
    }

    @Test
    void testConstructorDesdeUsuario() {
        UsuarioDTO usuarioDTODesdeUsuario = new UsuarioDTO(usuario);
        assertEquals(usuario.getIdUsuario(), usuarioDTODesdeUsuario.getIdUsuario());
        assertEquals(usuario.getNombreUsuario(), usuarioDTODesdeUsuario.getNombreUsuario());
        assertEquals(usuario.getCorreo(), usuarioDTODesdeUsuario.getCorreo());
        assertEquals(usuario.getPassword(), usuarioDTODesdeUsuario.getPassword());
        assertEquals("Administrador", usuarioDTODesdeUsuario.getRol().getNombreRol());
    }

    @Test
    void testConstructorVacio() {
        UsuarioDTO usuarioDTOVacio = new UsuarioDTO();
        assertNotNull(usuarioDTOVacio);
        assertEquals(0, usuarioDTOVacio.getIdUsuario());
        assertNull(usuarioDTOVacio.getNombreUsuario());
        assertNull(usuarioDTOVacio.getCorreo());
        assertNull(usuarioDTOVacio.getRol());
        assertNull(usuarioDTOVacio.getPassword());
    }

    @Test
    void testEqualityBetweenDTOAndModel() {
        assertNotNull(usuarioDTO);
        assertEquals(usuario.getIdUsuario(), usuarioDTO.getIdUsuario());
        assertEquals(usuario.getNombreUsuario(), usuarioDTO.getNombreUsuario());
        assertEquals(usuario.getCorreo(), usuarioDTO.getCorreo());
        assertEquals(usuario.getPassword(), usuarioDTO.getPassword());
        assertEquals(usuario.getRol().getNombreRol(), usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testRolDTOIsNotNull() {
        assertNotNull(usuarioDTO.getRol());
        assertNotNull(usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testSetRolWithNullValue() {
        usuarioDTO.setRol(null);
        assertNull(usuarioDTO.getRol());
    }

    @Test
    void testRolDTOConversionToRol() {
        RolDTO rolDTO = new RolDTO(2, "Editor");
        Rol rol = new Rol(rolDTO.getId(), rolDTO.getNombreRol());
        assertEquals(rolDTO.getId(), rol.getId());
        assertEquals(rolDTO.getNombreRol(), rol.getNombreRol());
    }

    @Test
    void testChangeRol() {
        RolDTO nuevoRolDTO = new RolDTO(3, "Moderador");
        usuarioDTO.setRol(nuevoRolDTO);
        assertEquals("Moderador", usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testPasswordSetter() {
        String nuevoPassword = "nuevoPassword789";
        usuarioDTO.setPassword(nuevoPassword);
        assertEquals(nuevoPassword, usuarioDTO.getPassword());
    }

    @Test
    void testEmptyConstructor() {
        UsuarioDTO usuarioDTOVacio = new UsuarioDTO();
        assertNotNull(usuarioDTOVacio);
        assertEquals(0, usuarioDTOVacio.getIdUsuario());
        assertNull(usuarioDTOVacio.getNombreUsuario());
        assertNull(usuarioDTOVacio.getCorreo());
        assertNull(usuarioDTOVacio.getPassword());
        assertNull(usuarioDTOVacio.getRol());
    }
}
