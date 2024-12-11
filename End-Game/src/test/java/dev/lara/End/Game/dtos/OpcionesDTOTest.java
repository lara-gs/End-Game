package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Opciones;
import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpcionesDTOTest {

    private Opciones opciones;
    private OpcionesDTO opcionesDTO;

    @SuppressWarnings("unused")
    @BeforeEach
    void setUp() {
        Historia historiaOrigen = new Historia(1, "Historia Origen");
        Historia historiaDestino = new Historia(2, "Historia Destino");
        Progreso progreso = new Progreso();
        Usuario usuario = new Usuario(1, null, "UsuarioTest", "password", "correo@example.com");

        opciones = new Opciones(1, usuario, historiaOrigen, historiaDestino, 
                                "Descripción de la opción", true, 2);
        opcionesDTO = new OpcionesDTO(opciones);
    }

    @Test
    void testConstructorYGetters() {
        assertEquals(1, opcionesDTO.getIdOpcion());
        assertEquals(1, opcionesDTO.getIdProgreso());
        assertEquals(0, opcionesDTO.getIdUsuario());
        assertEquals(1, opcionesDTO.getIdHistoriaOrigen());
        assertEquals(2, opcionesDTO.getIdHistoriaDestino());
        assertEquals("Descripción de la opción", opcionesDTO.getDescripcion());
        assertTrue(opcionesDTO.getOpcionEspecial());
        assertEquals(2, opcionesDTO.getIdOpcionDesbloqueada());
    }

    @Test
    void testSetIdOpcion() {
        opcionesDTO.setIdOpcion(3);
        assertEquals(3, opcionesDTO.getIdOpcion());
    }

    @Test
    void testSetDescripcion() {
        opcionesDTO.setDescripcion("Nueva descripción");
        assertEquals("Nueva descripción", opcionesDTO.getDescripcion());
    }

    @Test
    void testSetOpcionEspecial() {
        opcionesDTO.setOpcionEspecial(false);
        assertFalse(opcionesDTO.getOpcionEspecial());
    }

    @Test
    void testSetIdOpcionDesbloqueada() {
        opcionesDTO.setIdOpcionDesbloqueada(3);
        assertEquals(3, opcionesDTO.getIdOpcionDesbloqueada());
    }
    @Test
    void testConstructorDesdeOpciones() {
        OpcionesDTO nuevoOpcionesDTO = new OpcionesDTO(opciones);
        assertEquals(1, nuevoOpcionesDTO.getIdOpcion());
        assertEquals(1, nuevoOpcionesDTO.getIdProgreso());
        assertEquals(0, nuevoOpcionesDTO.getIdUsuario());
        assertEquals(1, nuevoOpcionesDTO.getIdHistoriaOrigen());
        assertEquals(2, nuevoOpcionesDTO.getIdHistoriaDestino());
        assertEquals("Descripción de la opción", nuevoOpcionesDTO.getDescripcion());
        assertTrue(nuevoOpcionesDTO.getOpcionEspecial());
        assertEquals(2, nuevoOpcionesDTO.getIdOpcionDesbloqueada());
    }

    @Test
    void testEquals() {
        OpcionesDTO opcionesDTO1 = new OpcionesDTO(1, 1, 1, 1, 2, "Descripción de la opción", true, 2);
        OpcionesDTO opcionesDTO2 = new OpcionesDTO(1, 1, 1, 1, 2, "Descripción de la opción", true, 2);
        assertFalse(opcionesDTO1.equals(opcionesDTO2));

        opcionesDTO2.setIdOpcion(3);
        assertFalse(opcionesDTO1.equals(opcionesDTO2));
    }
    @Test
    void testSetIdHistoriaOrigen() {
        opcionesDTO.setIdHistoriaOrigen(3);
        assertEquals(3, opcionesDTO.getIdHistoriaOrigen());
    }

    @Test
    void testSetIdHistoriaDestino() {
        opcionesDTO.setIdHistoriaDestino(4);
        assertEquals(4, opcionesDTO.getIdHistoriaDestino());
    }

    @Test
    void testSetDescripcionConCadenaVacia() {
        opcionesDTO.setDescripcion("");
        assertEquals("", opcionesDTO.getDescripcion());
    }
    @Test
    void testSetDescripcionConCadenaNula() {
        opcionesDTO.setDescripcion(null);
        assertNull(opcionesDTO.getDescripcion());
    }

    @Test
    void testConstructorVacio() {
        OpcionesDTO opcionesDTOVacio = new OpcionesDTO();
        assertNotNull(opcionesDTOVacio);
        assertEquals(0, opcionesDTOVacio.getIdOpcion());
        assertEquals(0, opcionesDTOVacio.getIdProgreso());
        assertEquals(0, opcionesDTOVacio.getIdUsuario());
        assertEquals(0, opcionesDTOVacio.getIdHistoriaOrigen());
        assertEquals(0, opcionesDTOVacio.getIdHistoriaDestino());
        assertNull(opcionesDTOVacio.getDescripcion());
        assertFalse(opcionesDTOVacio.getOpcionEspecial());
    
    }

    @Test
    void testGetIdOpcionDesbloqueada() {
        assertEquals(2, opcionesDTO.getIdOpcionDesbloqueada());
    }

    @Test
    void testSetIdUsuario() {
        opcionesDTO.setIdUsuario(4);
        assertEquals(4, opcionesDTO.getIdUsuario());
    }


    @Test
    void testEqualsConObjetoNulo() {
        assertFalse(opcionesDTO.equals(null));
    }
    
    @Test
    void testHashCodeConObjetosDiferentes() {
        OpcionesDTO opcionesDTO1 = new OpcionesDTO(1, 1, 1, 1, 2, "Descripción", true, 2);
        OpcionesDTO opcionesDTO2 = new OpcionesDTO(2, 2, 2, 2, 3, "Otra descripción", false, 3);
        assertNotEquals(opcionesDTO1.hashCode(), opcionesDTO2.hashCode());
    }
    @Test
    void testEqualsConObjetosDistintos() {
        OpcionesDTO opcionesDTO1 = new OpcionesDTO(1, 1, 1, 1, 2, "Descripción de la opción", true, 2);
        OpcionesDTO opcionesDTO2 = new OpcionesDTO(2, 1, 1, 1, 2, "Descripción diferente", true, 2);
        assertFalse(opcionesDTO1.equals(opcionesDTO2));
    }

    @Test
    void testSetIdHistoriaOrigenConValorNegativo() {
        opcionesDTO.setIdHistoriaOrigen(-1);
        assertEquals(-1, opcionesDTO.getIdHistoriaOrigen());
    }

    @Test
    void testSetIdHistoriaDestinoConValorNegativo() {
        opcionesDTO.setIdHistoriaDestino(-1);
        assertEquals(-1, opcionesDTO.getIdHistoriaDestino());
    }

    @Test
    void testSetIdUsuarioConValorNegativo() {
        opcionesDTO.setIdUsuario(-1);
        assertEquals(-1, opcionesDTO.getIdUsuario());
    }

    @Test
    void testSetIdOpcionDesbloqueadaConValorNegativo() {
        opcionesDTO.setIdOpcionDesbloqueada(-1);
        assertEquals(-1, opcionesDTO.getIdOpcionDesbloqueada());
    }

    @Test
    void testSetDescripcionConCaracteresEspeciales() {
        opcionesDTO.setDescripcion("Descripción con caracteres especiales: @#$%^&*()");
        assertEquals("Descripción con caracteres especiales: @#$%^&*()", opcionesDTO.getDescripcion());
    }

    @Test
    void testSetDescripcionConEspaciosEnBlanco() {
        opcionesDTO.setDescripcion("   ");
        assertEquals("   ", opcionesDTO.getDescripcion());
    }

    

    @Test
    void testSetDescripcionConLongitudMaxima() {
        String longDescripcion = "A".repeat(1000); 
        opcionesDTO.setDescripcion(longDescripcion);
        assertEquals(longDescripcion, opcionesDTO.getDescripcion());
    }
}
