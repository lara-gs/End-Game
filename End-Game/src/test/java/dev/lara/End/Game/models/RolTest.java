package dev.lara.End.Game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RolTest {

    private Rol rol;
    private List<Usuario> usuarios;

    @BeforeEach
    void setUp() {

        usuarios = new ArrayList<>();
        rol = new Rol("Admin");
    }

    @Test
    void testConstructorConNombreRol() {
        assertEquals("Admin", rol.getNombreRol());
    }

    @Test
    void testConstructorConIdYNombreRol() {
        rol.setId(1);
        rol.setNombreRol("User");
        assertEquals(1, rol.getId());
        assertEquals("User", rol.getNombreRol());
    }

    @Test
    void testSetNombreRolValido() {
        rol.setNombreRol("Moderador");
        assertEquals("Moderador", rol.getNombreRol());
    }

    @Test
    void testSetNombreRolNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            rol.setNombreRol(null);
        });
    }

    @Test
    void testSetNombreRolVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            rol.setNombreRol("");
        });
    }

    @Test
    void testSetUsuarios() {
        Usuario usuario = new Usuario(1, rol, "user1", "user1@example.com", "password");
        usuarios.add(usuario);
        rol.setUsuarios(usuarios);
        assertEquals(1, rol.getUsuarios().size());
        assertEquals(usuario, rol.getUsuarios().get(0));
    }

    @Test
    void testEquals() {
        Rol rol2 = new Rol("Admin");
        rol2.setId(rol.getId());
        assertTrue(rol.equals(rol2));

        Rol rol3 = new Rol("User");
        rol3.setId(2);
        assertFalse(rol.equals(rol3));
    }

    @Test
    void testEqualsSameId() {
        Rol rol2 = new Rol("Admin");
        rol2.setId(rol.getId());
        assertTrue(rol.equals(rol2));
    }

    @Test
    void testUsuariosPorDefecto() {
        assertNull(rol.getUsuarios());
    }

    @Test
    void testSetGetId() {
        rol.setId(2);
        assertEquals(2, rol.getId());
    }

    @Test
    void testConstructorPorDefecto() {
        Rol rolDefault = new Rol();
        assertNotNull(rolDefault);
    }
    @Test
    void testSetNombreRolNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            rol.setNombreRol(null);
        });
    }

    @Test
    void testSetNombreRolEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            rol.setNombreRol("");
        });
    }

    @Test
    void testSetUsuariosCorrectamente() {
        Usuario usuario = new Usuario(1, rol, "user1", "user1@example.com", "password");
        usuarios.add(usuario);
        rol.setUsuarios(usuarios);
        assertEquals(1, rol.getUsuarios().size());
        assertEquals(usuario, rol.getUsuarios().get(0));
    }

    @Test
    void testSetGetNombreRol() {
        rol.setNombreRol("User");
        assertEquals("User", rol.getNombreRol());
    }

    @Test
    void testUsuariosVaciosPorDefecto() {
        assertNull(rol.getUsuarios());
    }

    @Test
    void testEqualsDiferenteObjeto() {
        Rol rol2 = new Rol("Guest");
        rol2.setId(2);
        assertFalse(rol.equals(rol2));
    }


    @Test
    void testRolSinUsuarios() {
        Rol rolSinUsuarios = new Rol("ADMIN");
        assertEquals("ADMIN", rolSinUsuarios.getNombreRol());
        assertNull(rolSinUsuarios.getUsuarios());
    }

    @Test
    void testRolConNombreYSinUsuarios() {
        Rol rolConNombre = new Rol("Admin");
        assertEquals("Admin", rolConNombre.getNombreRol());
        assertNull(rolConNombre.getUsuarios());
    }
    @Test
    void testSetIdConValorNegativo() {
        rol.setId(-1);
        assertEquals(-1, rol.getId());
    }

    @Test
    void testSetUsuariosConListaVacia() {
        rol.setUsuarios(new ArrayList<>());
        assertEquals(0, rol.getUsuarios().size());
    }

    @Test
    void testEqualsConObjetoNulo() {
        assertFalse(rol.equals(null));

    }
    @Test
    void testSetUsuariosConVariosUsuarios() {
        Usuario usuario1 = new Usuario(1, rol, "user1", "user1@example.com", "password");
        Usuario usuario2 = new Usuario(2, rol, "user2", "user2@example.com", "password");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        rol.setUsuarios(usuarios);
        assertEquals(2, rol.getUsuarios().size());
        assertTrue(rol.getUsuarios().contains(usuario1));
        assertTrue(rol.getUsuarios().contains(usuario2));
    }
 
    @Test
    void testSetIdConCero() {
        rol.setId(0);
        assertEquals(0, rol.getId());
    }

}