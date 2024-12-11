package dev.lara.End.Game.services;

import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.models.Historia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HistoriaServiceTest {

    private HistoriaRepositoryInMemory historiaRepositoryInMemory;

    @Autowired
    private HistoriaService historiaService;

    @BeforeEach
    void setUp() {
        historiaRepositoryInMemory = new HistoriaRepositoryInMemory();
        historiaService = new HistoriaService(historiaRepositoryInMemory, null, null);

        Historia historiaMock = new Historia();
        historiaMock.setIdHistoria(1);
        historiaMock.setDescripcion("Historia 1");
        historiaRepositoryInMemory.save(historiaMock);
    }

    @Test
    void testCargarHistoria() {

        List<HistoriaDTO> historias = historiaService.cargarHistoria();

        assertNotNull(historias);
        assertEquals(1, historias.size());
        assertEquals("Historia 1", historias.get(0).getDescripcion());
    }
}
