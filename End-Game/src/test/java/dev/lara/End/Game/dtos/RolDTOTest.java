package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RolDTOTest {

    private Rol rol;
    private RolDTO rolDTO;

    @BeforeEach
    void setUp() {
        rol = new Rol(1, "Administrador");
        rolDTO = new RolDTO(rol);
    }

    @Test
    void testRolDTOInitialization() {
        assertNotNull(rolDTO);
        assertEquals(1, rolDTO.getId());
        assertEquals("Administrador", rolDTO.getNombreRol());
    }

    @Test
    void testSetId() {
        rolDTO.setId(2);
        assertEquals(2, rolDTO.getId());
    }

    @Test
    void testSetNombreRol() {
        rolDTO.setNombreRol("Usuario");
        assertEquals("Usuario", rolDTO.getNombreRol());
    }

    @Test
    void testConstructorVacio() {
        RolDTO rolDTOVacio = new RolDTO();
        assertNotNull(rolDTOVacio);
        assertEquals(0, rolDTOVacio.getId());
        assertNull(rolDTOVacio.getNombreRol());
    }

    @Test
    void testConstructorDesdeRol() {
        RolDTO rolDTOFromEntity = new RolDTO(rol);
        assertEquals(1, rolDTOFromEntity.getId());
        assertEquals("Administrador", rolDTOFromEntity.getNombreRol());
    }

    @Test
    void testSetIdRol() {
        rolDTO.setId(3);
        assertEquals(3, rolDTO.getId());
    }

    @Test
    void testConstructorCompleto() {
        RolDTO rolDTOCompletado = new RolDTO(2, "Editor");
        assertEquals(2, rolDTOCompletado.getId());
        assertEquals("Editor", rolDTOCompletado.getNombreRol());
    }
}
