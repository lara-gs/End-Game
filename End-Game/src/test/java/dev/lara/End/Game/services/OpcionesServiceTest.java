package dev.lara.End.Game.services;

import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.models.Opciones;
import dev.lara.End.Game.repositories.OpcionesRepository;
import dev.lara.End.Game.repositories.ProgresoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OpcionesServiceTest {

    @InjectMocks
    private OpcionesService opcionesService;

    @Mock
    private OpcionesRepository opcionesRepository;

    @Mock
    private ProgresoRepository progresoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCargarOpcionesSuccess() {

        Opciones opcion1 = new Opciones();
        opcion1.setIdOpcion(1);
        opcion1.setDescripcion("Opción 1");

        Opciones opcion2 = new Opciones();
        opcion2.setIdOpcion(2);
        opcion2.setDescripcion("Opción 2");
        when(opcionesRepository.findAll()).thenReturn(Arrays.asList(opcion1, opcion2));

        List<OpcionesDTO> opcionesDTOs = opcionesService.cargarOpciones(8);

        assertEquals(2, opcionesDTOs.size());
        assertEquals("Opción 1", opcionesDTOs.get(0).getDescripcion());
        assertEquals("Opción 2", opcionesDTOs.get(1).getDescripcion());

        verify(opcionesRepository, times(1)).findAll();
    }

    @Test
    void testCargarOpcionesEmpty() {

        when(opcionesRepository.findAll()).thenReturn(List.of());
        List<OpcionesDTO> opcionesDTOs = opcionesService.cargarOpciones(1);
        assertTrue(opcionesDTOs.isEmpty());
        verify(opcionesRepository, times(1)).findAll();
    }
}
