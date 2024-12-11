package dev.lara.End.Game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;
    private Rol rol;

    @BeforeEach
    void setUp() {

        rol = new Rol("Admin");
        usuario = new Usuario(1, rol, "usuario1", "password123", "usuario1@example.com");
    }

    @Test
    void testConstructorYGetters() {
        assertEquals(1, usuario.getIdUsuario());
        assertEquals("Admin", usuario.getRol().getNombreRol());
        assertEquals("usuario1", usuario.getNombreUsuario());
        assertEquals("password123", usuario.getPassword());
        assertEquals("usuario1@example.com", usuario.getCorreo());
    }

    @Test
    void testSetRol() {
        Rol nuevoRol = new Rol("User");
        usuario.setRol(nuevoRol);
        assertEquals("User", usuario.getRol().getNombreRol());
    }

    @Test
    void testSetNombreUsuario() {
        usuario.setNombreUsuario("usuarioNuevo");
        assertEquals("usuarioNuevo", usuario.getNombreUsuario());
    }

    @Test
    void testSetPassword() {
        usuario.setPassword("nuevoPassword");
        assertEquals("nuevoPassword", usuario.getPassword());
    }

    @Test
    void testSetCorreo() {
        usuario.setCorreo("nuevoCorreo@example.com");
        assertEquals("nuevoCorreo@example.com", usuario.getCorreo());
    }
    @Test
    void testActualizacionAtributos() {
        usuario.setNombreUsuario("usuarioActualizado");
        usuario.setPassword("passwordActualizado");
        usuario.setCorreo("usuarioActualizado@example.com");

        assertEquals("usuarioActualizado", usuario.getNombreUsuario());
        assertEquals("passwordActualizado", usuario.getPassword());
        assertEquals("usuarioActualizado@example.com", usuario.getCorreo());
    }

    @Test
    void testEqualsIgual() {
        Usuario usuario2 = new Usuario(1, rol, "usuario1", "password123", "usuario1@example.com");
        assertFalse(usuario.equals(usuario2));
    }

    @Test
    void testEqualsDiferente() {
        Usuario usuario2 = new Usuario(2, rol, "usuario2", "password456", "usuario2@example.com");
        assertFalse(usuario.equals(usuario2));
    }

}
