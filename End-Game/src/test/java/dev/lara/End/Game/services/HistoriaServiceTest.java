package dev.lara.End.Game.services;

import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.repositories.HistoriaRepository;
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

class HistoriaServiceTest {

    @InjectMocks
    private HistoriaService historiaService;

    @Mock
    private HistoriaRepository historiaRepository;

    @Mock
    private OpcionesRepository opcionesRepository;

    @Mock
    private ProgresoRepository progresoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCargarHistoriaSuccess() {

        Historia historia1 = new Historia();
        historia1.setIdHistoria(1);
        historia1.setDescripcion("Historia 1");

        Historia historia2 = new Historia();
        historia2.setIdHistoria(2);
        historia2.setDescripcion("Historia 2");
        when(historiaRepository.findAll()).thenReturn(Arrays.asList(historia1, historia2));
        List<HistoriaDTO> historiaDTOs = historiaService.cargarHistoria();

        assertEquals(2, historiaDTOs.size());
        assertEquals("Historia 1", historiaDTOs.get(0).getDescripcion());
        assertEquals("Historia 2", historiaDTOs.get(1).getDescripcion());

        verify(historiaRepository, times(1)).findAll();
    }

    @Test
    void testCargarHistoriaEmpty() {

        when(historiaRepository.findAll()).thenReturn(List.of());
        List<HistoriaDTO> historiaDTOs = historiaService.cargarHistoria();
        assertTrue(historiaDTOs.isEmpty());
        verify(historiaRepository, times(1)).findAll();
    }
}
