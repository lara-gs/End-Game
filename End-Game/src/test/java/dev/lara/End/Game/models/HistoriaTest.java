package dev.lara.End.Game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoriaTest {

    private Historia historia;
    private List<Opciones> opcionesOrigen;
    private List<Opciones> opcionesDestino;

    @BeforeEach
    void setUp() {
        historia = new Historia(1, "Descripción de prueba");

        opcionesOrigen = new ArrayList<>();
        opcionesDestino = new ArrayList<>();
    }

    @Test
    void testConstructor() {
        assertEquals(1, historia.getIdHistoria());
        assertEquals("Descripción de prueba", historia.getDescripcion());
    }

    @Test
    void testGettersAndSetters() {

        historia.setIdHistoria(2);
        assertEquals(2, historia.getIdHistoria());

        historia.setDescripcion("Nueva descripción");
        assertEquals("Nueva descripción", historia.getDescripcion());
    }

    @Test
    void testOpcionesOrigen() {

        Opciones opcion1 = new Opciones();
        Opciones opcion2 = new Opciones();
        opcionesOrigen.add(opcion1);
        opcionesOrigen.add(opcion2);

        historia.setOpcionesOrigen(opcionesOrigen);
        assertEquals(opcionesOrigen, historia.getOpcionesOrigen());
        assertEquals(2, historia.getOpcionesOrigen().size());
    }

    @Test
    void testOpcionesDestino() {

        Opciones opcion1 = new Opciones();
        Opciones opcion2 = new Opciones();
        opcionesDestino.add(opcion1);
        opcionesDestino.add(opcion2);

        historia.setOpcionesDestino(opcionesDestino);
        assertEquals(opcionesDestino, historia.getOpcionesDestino());
        assertEquals(2, historia.getOpcionesDestino().size());
    }

    @Test
    void testSetDescripcion_NullValue() {

        historia.setDescripcion(null);
        assertNull(historia.getDescripcion(), "La descripción debería ser null.");
    }

    @Test
    void testSetOpcionesOrigen_NullValue() {

        historia.setOpcionesOrigen(null);
        assertNull(historia.getOpcionesOrigen(), "La lista de opciones origen debería ser null.");
    }

    @Test
    void testSetOpcionesDestino_NullValue() {

        historia.setOpcionesDestino(null);
        assertNull(historia.getOpcionesDestino(), "La lista de opciones destino debería ser null.");
    }

    @Test
    void testOpcionesOrigen_EmptyList() {

        List<Opciones> opcionesOrigen = new ArrayList<>();
        historia.setOpcionesOrigen(opcionesOrigen);
        assertNotNull(historia.getOpcionesOrigen());
        assertTrue(historia.getOpcionesOrigen().isEmpty(), "La lista debería estar vacía.");
    }

    @Test
    void testOpcionesDestino_EmptyList() {

        List<Opciones> opcionesDestino = new ArrayList<>();
        historia.setOpcionesDestino(opcionesDestino);
        assertNotNull(historia.getOpcionesDestino());
        assertTrue(historia.getOpcionesDestino().isEmpty());
    }

    @Test
    void testIdHistoria_DefaultValue() {

        assertEquals(1, historia.getIdHistoria());
    }

    @Test
    void testSetAndGetIdHistoria() {

        historia.setIdHistoria(123);
        assertEquals(123, historia.getIdHistoria());
    }

    @Test
    void testToString() {

        historia.setIdHistoria(8);
        historia.setDescripcion("Descripción de prueba");
        String toStringResult = historia.toString();
        assertNotNull(toStringResult, "toString no debería devolver null.");
        assertFalse(toStringResult.contains("8"));
        assertFalse(toStringResult.contains("Descripción de prueba"));
    }

    @Test
    void testAddOpcionesOrigen() {
        Opciones opcion = new Opciones();
        List<Opciones> opciones = new ArrayList<>();
        historia.setOpcionesOrigen(opciones);

        historia.getOpcionesOrigen().add(opcion);
        assertEquals(1, historia.getOpcionesOrigen().size(), "La lista debería tener un elemento");
        assertTrue(historia.getOpcionesOrigen().contains(opcion), "La lista debería contener la opción añadida");
    }

    @Test
    void testSetDescripcionWithLongString() {
        String longDescription = "a".repeat(1000);
        historia.setDescripcion(longDescription);
        assertEquals(longDescription, historia.getDescripcion(), "La descripción debería aceptar cadenas largas");
    }

    @Test
    void testOpcionesRelacionadasNulas() {
        historia.setOpcionesOrigen(null);
        historia.setOpcionesDestino(null);

        assertNull(historia.getOpcionesOrigen());
        assertNull(historia.getOpcionesDestino());
    }

}
