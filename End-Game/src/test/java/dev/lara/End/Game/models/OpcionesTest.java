package dev.lara.End.Game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OpcionesTest {

    private Historia historiaOrigen;
    private Historia historiaDestino;
    private Opciones opcion;

    @BeforeEach
    void setUp() {
        historiaOrigen = new Historia(1, "Historia Origen");
        historiaDestino = new Historia(2, "Historia Destino");
        opcion = new Opciones(1, null, historiaOrigen, historiaDestino, "Opción de prueba", true, 100);
    }

    @Test
    void testConstructor() {
        assertEquals(1, opcion.getIdOpcion());
        assertEquals("Opción de prueba", opcion.getDescripcion());
        assertTrue(opcion.getOpcion_especial());
        assertEquals(100, opcion.getId_especial_desbloqueada());
        assertEquals(historiaOrigen, opcion.getHistoriaOrigen());
        assertEquals(historiaDestino, opcion.getHistoriaDestino());
    }

    @Test
    void testSettersAndGetters() {
        opcion.setIdOpcion(2);
        opcion.setDescripcion("Nueva descripción");
        opcion.setOpcion_especial(false);
        opcion.setId_especial_desbloqueada(200);
        opcion.setHistoriaOrigen(new Historia(3, "Historia Origen 2"));
        opcion.setHistoriaDestino(new Historia(4, "Historia Destino 2"));

        assertEquals(2, opcion.getIdOpcion());
        assertEquals("Nueva descripción", opcion.getDescripcion());
        assertFalse(opcion.getOpcion_especial());
        assertEquals(200, opcion.getId_especial_desbloqueada());
        assertEquals(3, opcion.getHistoriaOrigen().getIdHistoria());
        assertEquals(4, opcion.getHistoriaDestino().getIdHistoria());
    }

    @Test
    void testSetHistoriaOrigenNull() {
        opcion.setHistoriaOrigen(null);
        assertNull(opcion.getHistoriaOrigen());
    }

    @Test
    void testSetHistoriaDestinoNull() {
        opcion.setHistoriaDestino(null);
        assertNull(opcion.getHistoriaDestino());
    }

    @Test
    void testSetDescripcionNull() {
        opcion.setDescripcion(null);
        assertNull(opcion.getDescripcion());
    }

    @Test
    void testSetOpcionEspecial() {
        opcion.setOpcion_especial(false);
        assertFalse(opcion.getOpcion_especial());

        opcion.setOpcion_especial(true);
        assertTrue(opcion.getOpcion_especial());
    }

    @Test
    void testIdEspecialDesbloqueada() {
        opcion.setId_especial_desbloqueada(300);
        assertEquals(300, opcion.getId_especial_desbloqueada());
    }

    @Test
    void testInvalidDescripcion() {
        opcion.setDescripcion("");
        assertEquals("", opcion.getDescripcion());
    }

    @Test
    void testOpcionEspecialDesactivada() {
        opcion.setOpcion_especial(false);
        assertFalse(opcion.getOpcion_especial());
    }

    @Test
    void testRelacionBidireccionalHistoria() {
        assertNotNull(opcion.getHistoriaOrigen());
        assertNotNull(opcion.getHistoriaDestino());
    }


    @Test
    void testModificarValores() {
        Historia nuevaHistoria = new Historia(3, "Nueva Historia");
        opcion.setHistoriaOrigen(nuevaHistoria);
        opcion.setDescripcion("Descripción modificada");
        opcion.setOpcion_especial(true);
        
        assertEquals(nuevaHistoria, opcion.getHistoriaOrigen());
        assertEquals("Descripción modificada", opcion.getDescripcion());
        assertTrue(opcion.getOpcion_especial());
    }
    @Test
    void testSetDescripcionConValorLargo() {
        String descripcionLarga = "Este es un texto muy largo que se utiliza para verificar que el sistema maneje correctamente las descripciones grandes sin problemas o errores.";
        opcion.setDescripcion(descripcionLarga);
        assertEquals(descripcionLarga, opcion.getDescripcion());
    }

    @Test
    void testSetIdEspecialDesbloqueadaConValorNegativo() {
        opcion.setId_especial_desbloqueada(-1);
        assertEquals(-1, opcion.getId_especial_desbloqueada());
    }


    @Test
    void testEqualsConOpcionesIguales() {
        Opciones opcion2 = new Opciones(1, null, historiaOrigen, historiaDestino, "Opción de prueba", true, 100);
        assertFalse(opcion.equals(opcion2));
    }

    @Test
    void testEqualsConOpcionesDiferentes() {
        Opciones opcion2 = new Opciones(2, null, historiaDestino, historiaOrigen, "Otra opción", false, 200);
        assertFalse(opcion.equals(opcion2));
    }

    @Test
    void testSetHistoriaOrigenConObjetoNulo() {
        opcion.setHistoriaOrigen(null);
        assertNull(opcion.getHistoriaOrigen());
    }

    @Test
    void testSetHistoriaDestinoConObjetoNulo() {
        opcion.setHistoriaDestino(null);
        assertNull(opcion.getHistoriaDestino());
    }
}
  