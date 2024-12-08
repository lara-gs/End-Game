package dev.lara.End.Game.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RolTest {

    private Rol rol;

    @BeforeEach
    void setUp() {
        rol = new Rol(1, "Administrador");
    }

    @Test
    void testConstructorConIdYNombreRol() {
        assertEquals(1, rol.getId());
        assertEquals("Administrador", rol.getNombreRol());
    }

    @Test
    void testConstructorConNombreRol() {
        Rol rolSinId = new Rol("Usuario");
        assertEquals("Usuario", rolSinId.getNombreRol());
        assertEquals(0, rolSinId.getId());
    }

    @Test
    void testSetId() {
        rol.setId(5);
        assertEquals(5, rol.getId());
    }

    @Test
    void testSetNombreRolValido() {
        rol.setNombreRol("Editor");
        assertEquals("Editor", rol.getNombreRol());
    }

    @Test
    void testSetNombreRolNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> rol.setNombreRol(null));
        assertEquals("El nombre del rol no puede ser vacío", exception.getMessage());
    }

    @Test
    void testSetNombreRolVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> rol.setNombreRol(""));
        assertEquals("El nombre del rol no puede ser vacío", exception.getMessage());
    }

    @Test
    void testGetUsuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(1);
        usuario1.setNombreUsuario("Lara");

        Usuario usuario2 = new Usuario();
        usuario2.setIdUsuario(2);
        usuario2.setNombreUsuario("Taylor");

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);
        rol.setUsuarios(usuarios);

        assertNotNull(rol.getUsuarios());
        assertEquals(2, rol.getUsuarios().size());
        assertEquals("Lara", rol.getUsuarios().get(0).getNombreUsuario());
        assertEquals("Taylor", rol.getUsuarios().get(1).getNombreUsuario());
    }

    @Test
    void testSetUsuariosNulo() {
        rol.setUsuarios(null);
        assertNull(rol.getUsuarios());
    }

    @Test
    void testEqualsMismoObjeto() {
        assertTrue(rol.equals(rol));
    }

    @Test
    void testEqualsOtroObjetoConMismoId() {
        Rol otroRol = new Rol(1, "Cualquier Nombre");
        assertTrue(rol.equals(otroRol));
    }

    @Test
    void testEqualsOtroObjetoConDiferenteId() {
        Rol otroRol = new Rol(2, "Cualquier Nombre");
        assertFalse(rol.equals(otroRol));
    }

    @Test
    void testEqualsObjetoNulo() {
        assertFalse(rol.equals(null));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    void testEqualsDiferenteClase() {
        assertFalse(rol.equals("String"));
    }

    @Test
    void testConstructorConUsuariosVacios() {
        Rol rolSinUsuarios = new Rol(1, "Invitado");
        assertNull(rolSinUsuarios.getUsuarios());
    }

    @Test
    void testSetUsuariosListaVacia() {
        rol.setUsuarios(List.of());
        assertTrue(rol.getUsuarios().isEmpty());
    }

    @Test
    void testEqualsMismoIdUsuariosDiferentes() {
        Rol otroRol = new Rol(1, "Diferente Nombre");
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(3);
        otroRol.setUsuarios(List.of(usuario));

        assertTrue(rol.equals(otroRol));
    }

    @Test
    void testSetNombreRolLargo() {
        String nombreLargo = "Administrador".repeat(100);
        rol.setNombreRol(nombreLargo);
        assertEquals(nombreLargo, rol.getNombreRol());
    }

    @Test
    void testSetUsuariosMismaLista() {
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(1);

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario1);
        rol.setUsuarios(usuarios);

        assertEquals(usuarios, rol.getUsuarios());
    }

    @Test
    void testEqualsUsuariosNoInicializados() {
        Rol otroRol = new Rol(1, "Administrador");
        assertTrue(rol.equals(otroRol));
    }

   
}
