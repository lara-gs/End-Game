package dev.lara.End.Game.controllers;

import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.services.HistoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoriaControllerTest {

    private HistoriaController historiaController;

    @BeforeEach
    void setUp() {
        dev.lara.End.Game.services.HistoriaRepositoryInMemory historiaRepositoryInMemory = new dev.lara.End.Game.services.HistoriaRepositoryInMemory();
        Historia historiaMock = new Historia();
        historiaMock.setIdHistoria(1);
        historiaMock.setDescripcion("Historia 1");
        historiaRepositoryInMemory.save(historiaMock);

        HistoriaService historiaService = new HistoriaService(historiaRepositoryInMemory, null, null);
        historiaController = new HistoriaController(historiaService);
    }

    @Test
    void testCargarHistoria() {
        ResponseEntity<List<HistoriaDTO>> response = historiaController.cargarHistoria();

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());

        List<HistoriaDTO> historias = response.getBody();
        assertNotNull(historias);
        assertEquals(1, historias.size());
        assertEquals("Historia 1", historias.get(0).getDescripcion());
    }
}
