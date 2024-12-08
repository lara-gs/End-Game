package dev.lara.End.Game.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpcionesTest {

    private Opciones opciones;
    private Historia historiaOrigen;
    private Historia historiaDestino;

    @BeforeEach
    void setUp() {
        historiaOrigen = new Historia(1, "Historia de origen");
        historiaDestino = new Historia(2, "Historia de destino");
        opciones = new Opciones(1, null, historiaOrigen, historiaDestino, "Descripción de la opción");
    }

    @Test
    void testConstructor() {
        assertNotNull(opciones);
        assertEquals(1, opciones.getId_progreso());
        assertEquals(historiaOrigen, opciones.getHistoriaOrigen());
        assertEquals(historiaDestino, opciones.getHistoriaDestino());
        assertEquals("Descripción de la opción", opciones.getDescripcion());
    }

    @Test
    void testSettersAndGetters() {
        Historia nuevaHistoriaOrigen = new Historia(3, "Nueva historia de origen");
        Historia nuevaHistoriaDestino = new Historia(4, "Nueva historia de destino");

        opciones.setHistoriaOrigen(nuevaHistoriaOrigen);
        opciones.setHistoriaDestino(nuevaHistoriaDestino);
        opciones.setDescripcion("Nueva descripción");

        assertEquals(nuevaHistoriaOrigen, opciones.getHistoriaOrigen());
        assertEquals(nuevaHistoriaDestino, opciones.getHistoriaDestino());
        assertEquals("Nueva descripción", opciones.getDescripcion());
    }

    @Test
    void testIdProgreso() {
        opciones.setId_progreso(5);
        assertEquals(5, opciones.getId_progreso());
    }

    @Test
    void testHistoriaOrigenNull() {
        opciones.setHistoriaOrigen(null);
        assertNull(opciones.getHistoriaOrigen());
    }

    @Test
    void testHistoriaDestinoNull() {
        opciones.setHistoriaDestino(null);
        assertNull(opciones.getHistoriaDestino());
    }

    @Test
    void testDescripcionNull() {
        opciones.setDescripcion(null);
        assertNull(opciones.getDescripcion());
    }
}
