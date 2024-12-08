package dev.lara.End.Game.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testConstructorCompleto() {
        Rol rol = new Rol(1, "Administrador");
        Usuario usuario = new Usuario(1, rol, "laraUser", "securePass123", "lara@example.com");

        assertEquals(1, usuario.getIdUsuario());
        assertEquals(rol, usuario.getRol());
        assertEquals("laraUser", usuario.getNombreUsuario());
        assertEquals("securePass123", usuario.getPassword());
        assertEquals("lara@example.com", usuario.getCorreo());
    }

    @Test
    void testConstructorPorDefecto() {
        Usuario usuario = new Usuario();

        assertNull(usuario.getRol());
        assertNull(usuario.getNombreUsuario());
        assertNull(usuario.getPassword());
        assertNull(usuario.getCorreo());
    }

    @Test
    void testSettersYGetters() {
        Rol rol = new Rol(2, "Usuario");
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(2);
        usuario.setRol(rol);
        usuario.setNombreUsuario("testUser");
        usuario.setPassword("123456");
        usuario.setCorreo("test@example.com");

        assertEquals(2, usuario.getIdUsuario());
        assertEquals(rol, usuario.getRol());
        assertEquals("testUser", usuario.getNombreUsuario());
        assertEquals("123456", usuario.getPassword());
        assertEquals("test@example.com", usuario.getCorreo());
    }

    @Test
    void testSetCorreoNulo() {
        Usuario usuario = new Usuario();
        usuario.setCorreo(null);

        assertNull(usuario.getCorreo());
    }

    @Test
    void testSetPasswordVacio() {
        Usuario usuario = new Usuario();
        usuario.setPassword("");

        assertEquals("", usuario.getPassword());
    }

    @Test
    void testSetNombreUsuarioLargo() {
        Usuario usuario = new Usuario();
        String nombreLargo = "UsuarioNombre".repeat(10); // Nombre extenso
        usuario.setNombreUsuario(nombreLargo);

        assertEquals(nombreLargo, usuario.getNombreUsuario());
    }

    @Test
    void testIgualdadMismoID() {
        Rol rol1 = new Rol(1, "Admin");
        Rol rol2 = new Rol(2, "User");
        Usuario usuario1 = new Usuario(1, rol1, "usuario1", "pass1", "correo1@example.com");
        Usuario usuario2 = new Usuario(1, rol2, "usuario2", "pass2", "correo2@example.com");

        assertEquals(usuario1.getIdUsuario(), usuario2.getIdUsuario());
    }

    @Test
    void testUsuarioConDiferenteID() {
        Usuario usuario1 = new Usuario(1, null, "user1", "pass1", "user1@example.com");
        Usuario usuario2 = new Usuario(2, null, "user2", "pass2", "user2@example.com");

        assertNotEquals(usuario1.getIdUsuario(), usuario2.getIdUsuario());
    }

    @Test
    void testRolNulo() {
        Usuario usuario = new Usuario();
        usuario.setRol(null);

        assertNull(usuario.getRol());
    }

    @Test
    void testCorreoUnico() {
        Usuario usuario1 = new Usuario();
        usuario1.setCorreo("lara@example.com");

        Usuario usuario2 = new Usuario();
        usuario2.setCorreo("lara@example.com");

        assertEquals(usuario1.getCorreo(), usuario2.getCorreo());
    }
}
