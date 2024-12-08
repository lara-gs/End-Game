package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Opciones;
import dev.lara.End.Game.models.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class OpcionesDTOTest {

    @Test
    void testConstructorVacio() {
        OpcionesDTO opcionesDTO = new OpcionesDTO();

        assertEquals(0, opcionesDTO.getIdProgreso());
        assertEquals(0, opcionesDTO.getIdUsuario());
        assertEquals(0, opcionesDTO.getIdHistoriaOrigen());
        assertEquals(0, opcionesDTO.getIdHistoriaDestino());
        assertNull(opcionesDTO.getDescripcion());
    }

    @Test
    void testSettersYGetters() {
        OpcionesDTO opcionesDTO = new OpcionesDTO();

        opcionesDTO.setIdProgreso(5);
        opcionesDTO.setIdUsuario(6);
        opcionesDTO.setIdHistoriaOrigen(7);
        opcionesDTO.setIdHistoriaDestino(8);
        opcionesDTO.setDescripcion("Nueva descripción");

        assertEquals(5, opcionesDTO.getIdProgreso());
        assertEquals(6, opcionesDTO.getIdUsuario());
        assertEquals(7, opcionesDTO.getIdHistoriaOrigen());
        assertEquals(8, opcionesDTO.getIdHistoriaDestino());
        assertEquals("Nueva descripción", opcionesDTO.getDescripcion());
    }

    @Test
    void testSetDescripcionNula() {
        OpcionesDTO opcionesDTO = new OpcionesDTO();
        opcionesDTO.setDescripcion(null);

        assertNull(opcionesDTO.getDescripcion());
    }

    @Test
    void testSetIdProgresoNegativo() {
        OpcionesDTO opcionesDTO = new OpcionesDTO();
        opcionesDTO.setIdProgreso(-1);

        assertEquals(-1, opcionesDTO.getIdProgreso());
    }

    
    @Test
    void testConstructorConValoresLimite() {
        OpcionesDTO opcionesDTO = new OpcionesDTO(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                Integer.MAX_VALUE, Integer.MAX_VALUE, "Descripción de opción límite");

        assertEquals(Integer.MAX_VALUE, opcionesDTO.getIdProgreso());
        assertEquals(Integer.MAX_VALUE, opcionesDTO.getIdUsuario());
        assertEquals(Integer.MAX_VALUE, opcionesDTO.getIdHistoriaOrigen());
        assertEquals(Integer.MAX_VALUE, opcionesDTO.getIdHistoriaDestino());
        assertEquals("Descripción de opción límite", opcionesDTO.getDescripcion());
    }

    @Test
    void testConstructorConValoresNegativos() {
        OpcionesDTO opcionesDTO = new OpcionesDTO(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
                Integer.MIN_VALUE, Integer.MIN_VALUE, "Descripción de opción negativa");

        assertEquals(Integer.MIN_VALUE, opcionesDTO.getIdProgreso());
        assertEquals(Integer.MIN_VALUE, opcionesDTO.getIdUsuario());
        assertEquals(Integer.MIN_VALUE, opcionesDTO.getIdHistoriaOrigen());
        assertEquals(Integer.MIN_VALUE, opcionesDTO.getIdHistoriaDestino());
        assertEquals("Descripción de opción negativa", opcionesDTO.getDescripcion());
    }

    @Test
    void testConstructorConValoresNull() {
        Historia historiaOrigen = null;
        Historia historiaDestino = null;
        Usuario usuario = null;

        Opciones opciones = new Opciones(1, usuario, historiaOrigen, historiaDestino, null);
        OpcionesDTO opcionesDTO = new OpcionesDTO(opciones);

        assertEquals(1, opcionesDTO.getIdProgreso()); // El idProgreso debe ser 1 porque lo asignamos en Opciones
        assertEquals(-1, opcionesDTO.getIdHistoriaOrigen()); // Historia origen null, se asigna -1
        assertEquals(-1, opcionesDTO.getIdHistoriaDestino()); // Historia destino null, se asigna -1
        assertNull(opcionesDTO.getDescripcion()); // Descripción también es null
    }

    
}
