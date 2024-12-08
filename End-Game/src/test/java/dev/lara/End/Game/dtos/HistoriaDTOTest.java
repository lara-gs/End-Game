package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Historia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistoriaDTOTest {

    @Test
    void testConstructorVacio() {
        HistoriaDTO historiaDTO = new HistoriaDTO();

        assertEquals(0, historiaDTO.getIdHistoria());
        assertNull(historiaDTO.getDescripcion());
    }

    @Test
    void testConstructorConParametros() {
        HistoriaDTO historiaDTO = new HistoriaDTO(1, "Historia de ejemplo");

        assertEquals(1, historiaDTO.getIdHistoria());
        assertEquals("Historia de ejemplo", historiaDTO.getDescripcion());
    }

    @Test
    void testConstructorConHistoria() {
        Historia historia = new Historia(2, "Historia de prueba");
        HistoriaDTO historiaDTO = new HistoriaDTO(historia);

        assertEquals(2, historiaDTO.getIdHistoria());
        assertEquals("Historia de prueba", historiaDTO.getDescripcion());
    }

    @Test
    void testSettersYGetters() {
        HistoriaDTO historiaDTO = new HistoriaDTO();
        
        historiaDTO.setIdHistoria(3);
        historiaDTO.setDescripcion("Nueva historia");

        assertEquals(3, historiaDTO.getIdHistoria());
        assertEquals("Nueva historia", historiaDTO.getDescripcion());
    }

    @Test
    void testSetDescripcionNula() {
        HistoriaDTO historiaDTO = new HistoriaDTO();
        historiaDTO.setDescripcion(null);

        assertNull(historiaDTO.getDescripcion());
    }

    @Test
    void testSetIdHistoriaNegativo() {
        HistoriaDTO historiaDTO = new HistoriaDTO();
        historiaDTO.setIdHistoria(-1);

        assertEquals(-1, historiaDTO.getIdHistoria());
    }
}
