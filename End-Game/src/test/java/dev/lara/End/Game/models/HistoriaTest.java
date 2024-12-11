package dev.lara.End.Game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class HistoriaTest {

    private Historia historia;

    @BeforeEach
    void setUp() {
        historia = new Historia(1, "Historia de prueba");
    }

    @Test
    void testConstructor() {
        assertEquals(1, historia.getIdHistoria());
        assertEquals("Historia de prueba", historia.getDescripcion());
    }

    @Test
    void testSettersAndGetters() {
        historia.setIdHistoria(2);
        historia.setDescripcion("Nueva historia");
        assertEquals(2, historia.getIdHistoria());
        assertEquals("Nueva historia", historia.getDescripcion());
    }

    @Test
    void testOpcionesOrigen() {
        List<Opciones> opcionesOrigen = new ArrayList<>();
        historia.setOpcionesOrigen(opcionesOrigen);
        assertNotNull(historia.getOpcionesOrigen());
        assertTrue(historia.getOpcionesOrigen().isEmpty());
    }

    @Test
    void testOpcionesDestino() {
        List<Opciones> opcionesDestino = new ArrayList<>();
        historia.setOpcionesDestino(opcionesDestino);
        assertNotNull(historia.getOpcionesDestino());
        assertTrue(historia.getOpcionesDestino().isEmpty());
    }

    @Test
    void testSetOpcionesOrigenWithMultipleValues() {
        List<Opciones> opcionesOrigen = new ArrayList<>();
        Opciones opcion1 = new Opciones(); 
        Opciones opcion2 = new Opciones();
        opcionesOrigen.add(opcion1);
        opcionesOrigen.add(opcion2);
        historia.setOpcionesOrigen(opcionesOrigen);

        assertEquals(2, historia.getOpcionesOrigen().size());
    }

    @Test
    void testSetOpcionesDestinoWithMultipleValues() {
        List<Opciones> opcionesDestino = new ArrayList<>();
        Opciones opcion1 = new Opciones();
        Opciones opcion2 = new Opciones();
        opcionesDestino.add(opcion1);
        opcionesDestino.add(opcion2);
        historia.setOpcionesDestino(opcionesDestino);

        assertEquals(2, historia.getOpcionesDestino().size());
    }

    @Test
    void testDescripcionNull() {
        Historia historiaNull = new Historia();
        historiaNull.setDescripcion(null);
        assertNull(historiaNull.getDescripcion());
    }

    @Test
    void testHistoriaWithEmptyDescription() {
        Historia historiaEmpty = new Historia();
        historiaEmpty.setDescripcion("");
        assertEquals("", historiaEmpty.getDescripcion());
    }

    @Test
    void testHistoriaWithoutSettingDescription() {

        Historia historiaWithoutDesc = new Historia();
        assertNull(historiaWithoutDesc.getDescripcion());
    }
}
