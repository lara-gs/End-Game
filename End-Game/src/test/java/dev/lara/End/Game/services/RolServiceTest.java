package dev.lara.End.Game.services;

import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RolServiceTest {

    @Mock
    private RolRepository rolRepository;
    
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private RolService rolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCargarRolesConDatos() {
        Rol rol1 = new Rol(1, "Admin");
        Rol rol2 = new Rol(2, "Usuario");
        when(rolRepository.findAll()).thenReturn(Arrays.asList(rol1, rol2));
        List<RolDTO> rolesDTO = rolService.cargarRoles();

        assertNotNull(rolesDTO);
        assertEquals(2, rolesDTO.size());
        assertEquals("Admin", rolesDTO.get(0).getNombreRol());
        assertEquals("Usuario", rolesDTO.get(1).getNombreRol());
        verify(rolRepository, times(1)).findAll();
    }
}
