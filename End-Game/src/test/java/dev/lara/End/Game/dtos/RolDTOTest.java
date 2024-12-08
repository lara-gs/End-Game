package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Rol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RolDTOTest {

    @Test
    void testConstructorVacio() {
        RolDTO rolDTO = new RolDTO();

        assertEquals(0, rolDTO.getId());
        assertNull(rolDTO.getNombreRol());
    }

    @Test
    void testConstructorConParametros() {
        RolDTO rolDTO = new RolDTO(1, "Admin");

        assertEquals(1, rolDTO.getId());
        assertEquals("Admin", rolDTO.getNombreRol());
    }

    @Test
    void testConstructorConRol() {
        Rol rol = new Rol(1, "Admin");

        RolDTO rolDTO = new RolDTO(rol);

        assertEquals(1, rolDTO.getId());
        assertEquals("Admin", rolDTO.getNombreRol());
    }

    @Test
    void testSettersYGetters() {
        RolDTO rolDTO = new RolDTO();

        rolDTO.setId(2);
        rolDTO.setNombreRol("User");

        assertEquals(2, rolDTO.getId());
        assertEquals("User", rolDTO.getNombreRol());
    }

    @Test
    void testSetNombreRolNulo() {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setNombreRol(null);

        assertNull(rolDTO.getNombreRol());
    }

    @Test
    void testSetIdNegativo() {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(-1);

        assertEquals(-1, rolDTO.getId());
    }
}
