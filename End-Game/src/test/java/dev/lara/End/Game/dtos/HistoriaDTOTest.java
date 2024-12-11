package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Historia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoriaDTOTest {

    private Historia historia;
    private HistoriaDTO historiaDTO;

    @BeforeEach
    void setUp() {
        historia = new Historia(1, "Descripción de la historia");
        historiaDTO = new HistoriaDTO(historia);
    }
    @Test
    void testIndependenciaDeEntidadHistoria() {
        historia.setDescripcion("Descripción modificada en Historia");
        assertNotEquals(historiaDTO.getDescripcion(), historia.getDescripcion());
    }
    @Test
    void testConstructorYGetters() {
        assertEquals(1, historiaDTO.getIdHistoria());
        assertEquals("Descripción de la historia", historiaDTO.getDescripcion());
    }

    @Test
    void testSetIdHistoria() {
        historiaDTO.setIdHistoria(2);
        assertEquals(2, historiaDTO.getIdHistoria());
    }

    @Test
    void testSetDescripcion() {
        historiaDTO.setDescripcion("Nueva descripción");
        assertEquals("Nueva descripción", historiaDTO.getDescripcion());
    }

    @Test
    void testConstructorDesdeHistoria() {
        HistoriaDTO nuevoHistoriaDTO = new HistoriaDTO(historia);
        assertEquals(1, nuevoHistoriaDTO.getIdHistoria());
        assertEquals("Descripción de la historia", nuevoHistoriaDTO.getDescripcion());
    }

    @Test
    void testActualizacionAtributos() {
        historiaDTO.setIdHistoria(3);
        historiaDTO.setDescripcion("Descripción actualizada");

        assertEquals(3, historiaDTO.getIdHistoria());
        assertEquals("Descripción actualizada", historiaDTO.getDescripcion());
    }


    @Test
    void testConstructorSinParametros() {
        HistoriaDTO historiaDTOVacio = new HistoriaDTO();
        assertEquals(0, historiaDTOVacio.getIdHistoria());
        assertNull(historiaDTOVacio.getDescripcion());
    }

    @Test
    void testSetDescripcionNulo() {
        historiaDTO.setDescripcion(null);
        assertNull(historiaDTO.getDescripcion());
    }

    @Test
    void testSetIdHistoriaValorNegativo() {
        historiaDTO.setIdHistoria(-1);
        assertEquals(-1, historiaDTO.getIdHistoria());
    }

    @Test
    void testEquals() {
        HistoriaDTO historiaDTO1 = new HistoriaDTO(1, "Descripción de la historia");
        HistoriaDTO historiaDTO2 = new HistoriaDTO(1, "Descripción de la historia");
        assertFalse(historiaDTO1.equals(historiaDTO2));

        historiaDTO2.setIdHistoria(2);
        assertFalse(historiaDTO1.equals(historiaDTO2));
    }

}
