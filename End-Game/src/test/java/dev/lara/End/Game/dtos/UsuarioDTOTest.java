package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDTOTest {

    @Test
    void testConstructorVacio() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        assertEquals(0, usuarioDTO.getIdUsuario());
        assertNull(usuarioDTO.getNombreUsuario());
        assertNull(usuarioDTO.getCorreo());
        assertNull(usuarioDTO.getPassword());
        assertNull(usuarioDTO.getRol());
    }

    @Test
    void testConstructorConParametros() {
        RolDTO rolDTO = new RolDTO(1, "Admin");
        UsuarioDTO usuarioDTO = new UsuarioDTO(1, "usuario1", "usuario1@correo.com", rolDTO, "password123");

        assertEquals(1, usuarioDTO.getIdUsuario());
        assertEquals("usuario1", usuarioDTO.getNombreUsuario());
        assertEquals("usuario1@correo.com", usuarioDTO.getCorreo());
        assertEquals("password123", usuarioDTO.getPassword());
        assertNotNull(usuarioDTO.getRol());
        assertEquals(1, usuarioDTO.getRol().getId());
        assertEquals("Admin", usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testConstructorConUsuario() {
        Rol rol = new Rol(1, "Admin");
        Usuario usuario = new Usuario(1, rol, "usuario1", "password123", "usuario1@correo.com");

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

        assertEquals(1, usuarioDTO.getIdUsuario());
        assertEquals("usuario1", usuarioDTO.getNombreUsuario());
        assertEquals("usuario1@correo.com", usuarioDTO.getCorreo());
        assertNotNull(usuarioDTO.getRol());
        assertEquals(1, usuarioDTO.getRol().getId());
        assertEquals("Admin", usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testSettersYGetters() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        
        usuarioDTO.setIdUsuario(2);
        usuarioDTO.setNombreUsuario("usuario2");
        usuarioDTO.setCorreo("usuario2@correo.com");
        usuarioDTO.setPassword("password456");
        
        RolDTO rolDTO = new RolDTO(2, "User");
        usuarioDTO.setRol(rolDTO);

        assertEquals(2, usuarioDTO.getIdUsuario());
        assertEquals("usuario2", usuarioDTO.getNombreUsuario());
        assertEquals("usuario2@correo.com", usuarioDTO.getCorreo());
        assertEquals("password456", usuarioDTO.getPassword());
        assertNotNull(usuarioDTO.getRol());
        assertEquals(2, usuarioDTO.getRol().getId());
        assertEquals("User", usuarioDTO.getRol().getNombreRol());
    }

    @Test
    void testSetRolNull() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        
        usuarioDTO.setRol(null);
        
        assertNull(usuarioDTO.getRol());
    }

    @Test
    void testSetRolNombre() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setRolNombre("Admin");
        
        assertEquals("Admin", usuarioDTO.getRolNombre());
    }
}
