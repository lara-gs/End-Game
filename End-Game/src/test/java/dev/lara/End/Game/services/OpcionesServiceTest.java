package dev.lara.End.Game.services;

import static org.junit.jupiter.api.Assertions.*;

import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Opciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OpcionesServiceTest {

    private OpcionesService opcionesService;
    private OpcionesRepositoryInMemory opcionesRepository;

    @BeforeEach
    void setUp() {
        opcionesRepository = new OpcionesRepositoryInMemory();
        opcionesService = new OpcionesService(opcionesRepository);
    }

    @Test
    void testCargarOpciones() {
  
        int idHistoria = 1;

        Historia historia1 = new Historia();
        historia1.setIdHistoria(idHistoria);

        Historia historia2 = new Historia();
        historia2.setIdHistoria(2);

        Opciones opcion1 = new Opciones();
        opcion1.setIdOpcion(1);
        opcion1.setHistoriaOrigen(historia1);
        opcion1.setHistoriaDestino(historia2);
        opcion1.setId_especial_desbloqueada(0);
        opcion1.setOpcion_especial(false);

        Opciones opcion2 = new Opciones();
        opcion2.setIdOpcion(2);
        opcion2.setHistoriaOrigen(historia1);
        opcion2.setHistoriaDestino(historia2);
        opcion2.setId_especial_desbloqueada(0);
        opcion2.setOpcion_especial(false);

        Opciones opcion3 = new Opciones();
        opcion3.setIdOpcion(3);
        opcion3.setHistoriaOrigen(historia2);
        opcion3.setHistoriaDestino(historia2);
        opcion3.setId_especial_desbloqueada(0);
        opcion3.setOpcion_especial(false);

        opcionesRepository.save(opcion1);
        opcionesRepository.save(opcion2);
        opcionesRepository.save(opcion3);

        List<OpcionesDTO> opciones = opcionesService.cargarOpciones(idHistoria);

        assertNotNull(opciones);
        assertEquals(2, opciones.size());
        assertTrue(opciones.stream().allMatch(op -> op.getIdHistoriaOrigen() == idHistoria));
    }

    @Test
    void testCargarOpcionesSinResultados() {
        int idHistoria = 999; 

        List<OpcionesDTO> opciones = opcionesService.cargarOpciones(idHistoria);

        assertNotNull(opciones);
        assertTrue(opciones.isEmpty());
    }
}
