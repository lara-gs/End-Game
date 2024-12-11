package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProgresoDTOTest {

    private Progreso progreso;
    private ProgresoDTO progresoDTO;

    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario(1, null, "UsuarioTest", "password", "correo@example.com");
        Historia historia = new Historia(1, "Historia 1");
        progreso = new Progreso(usuario, historia, LocalDate.now(), "Historia 2");
        progresoDTO = new ProgresoDTO(progreso);
    }

    @Test
    void testProgresoDTOInitialization() {
        assertNotNull(progresoDTO);
        assertEquals(0, progresoDTO.getIdProgreso());
        assertEquals(1, progresoDTO.getIdUsuario());
        assertEquals(1, progresoDTO.getIdHistoria());
        assertEquals("Historia 2", progresoDTO.getHistoriasDesbloqueadas());
    }

    @Test
    void testSetIdProgreso() {
        progresoDTO.setIdProgreso(2);
        assertEquals(2, progresoDTO.getIdProgreso());
    }

    @Test
    void testSetIdUsuario() {
        progresoDTO.setIdUsuario(3);
        assertEquals(3, progresoDTO.getIdUsuario());
    }

    @Test
    void testSetIdHistoria() {
        progresoDTO.setIdHistoria(4);
        assertEquals(4, progresoDTO.getIdHistoria());
    }

    @Test
    void testSetFecha() {
        LocalDate newDate = LocalDate.of(2024, 12, 10);
        progresoDTO.setFecha(newDate);
        assertEquals(newDate, progresoDTO.getFecha());
    }

    @Test
    void testSetHistoriasDesbloqueadas() {
        progresoDTO.setHistoriasDesbloqueadas("Historia 3");
        assertEquals("Historia 3", progresoDTO.getHistoriasDesbloqueadas());
    }

    @Test
    void testConstructorVacio() {
        ProgresoDTO progresoDTOVacio = new ProgresoDTO();
        assertNotNull(progresoDTOVacio);
        assertEquals(0, progresoDTOVacio.getIdProgreso());
        assertEquals(0, progresoDTOVacio.getIdUsuario());
        assertEquals(0, progresoDTOVacio.getIdHistoria());
        assertNull(progresoDTOVacio.getFecha());
        assertNull(progresoDTOVacio.getHistoriasDesbloqueadas());
    }

    @Test
    void testConstructorDesdeProgreso() {
        ProgresoDTO progresoDTOFromEntity = new ProgresoDTO(progreso);
        assertEquals(0, progresoDTOFromEntity.getIdProgreso());
        assertEquals(1, progresoDTOFromEntity.getIdUsuario());
        assertEquals(1, progresoDTOFromEntity.getIdHistoria());
        assertEquals("Historia 2", progresoDTOFromEntity.getHistoriasDesbloqueadas());
        assertEquals(LocalDate.now(), progresoDTOFromEntity.getFecha());
    }

    @Test
    void testSetHistoriasDesbloqueadasConNull() {
        progresoDTO.setHistoriasDesbloqueadas(null);
        assertNull(progresoDTO.getHistoriasDesbloqueadas());
    }

    @Test
    void testGetFecha() {
        LocalDate currentDate = LocalDate.now();
        assertEquals(currentDate, progresoDTO.getFecha());
    }

    @Test
    void testConstructorCompleto() {
        ProgresoDTO progresoDTOCompletado = new ProgresoDTO(1, 2, 3, LocalDate.of(2024, 12, 1), "Historia 4");
        assertEquals(1, progresoDTOCompletado.getIdProgreso());
        assertEquals(2, progresoDTOCompletado.getIdUsuario());
        assertEquals(3, progresoDTOCompletado.getIdHistoria());
        assertEquals(LocalDate.of(2024, 12, 1), progresoDTOCompletado.getFecha());
        assertEquals("Historia 4", progresoDTOCompletado.getHistoriasDesbloqueadas());
    }



    @Test
    void testProgresoDTOInequality() {
        ProgresoDTO progresoDTO1 = new ProgresoDTO(1, 2, 3, LocalDate.of(2024, 12, 10), "Historia 5");
        ProgresoDTO progresoDTO2 = new ProgresoDTO(1, 2, 3, LocalDate.of(2024, 12, 11), "Historia 5");

        assertNotEquals(progresoDTO1, progresoDTO2);
    }



    @Test
    void testSetFechaMinima() {
        LocalDate minDate = LocalDate.of(1900, 1, 1);
        progresoDTO.setFecha(minDate);
        assertEquals(minDate, progresoDTO.getFecha());
    }

    @Test
    void testSetFechaMaxima() {
        LocalDate maxDate = LocalDate.of(9999, 12, 31);
        progresoDTO.setFecha(maxDate);
        assertEquals(maxDate, progresoDTO.getFecha());
    }

    @Test
    void testSetHistoriasDesbloqueadasEmptyString() {
        progresoDTO.setHistoriasDesbloqueadas("");
        assertEquals("", progresoDTO.getHistoriasDesbloqueadas());
    }

    @Test
    void testSetHistoriasDesbloqueadasLongString() {
        String longString = "A".repeat(1000); 
        progresoDTO.setHistoriasDesbloqueadas(longString);
        assertEquals(longString, progresoDTO.getHistoriasDesbloqueadas());
    }

    @Test
    void testChangeIdProgreso() {
        int newId = 10;
        progresoDTO.setIdProgreso(newId);
        assertEquals(newId, progresoDTO.getIdProgreso());
    }

    @Test
    void testChangeIdUsuario() {
        int newId = 20;
        progresoDTO.setIdUsuario(newId);
        assertEquals(newId, progresoDTO.getIdUsuario());
    }

    @Test
    void testChangeIdHistoria() {
        int newId = 30;
        progresoDTO.setIdHistoria(newId);
        assertEquals(newId, progresoDTO.getIdHistoria());
    }

    @Test
    void testSetFechaFutura() {
        LocalDate futureDate = LocalDate.of(2100, 1, 1);
        progresoDTO.setFecha(futureDate);
        assertEquals(futureDate, progresoDTO.getFecha());
    }
    
    @Test
    void testGetterAndSetterIntegrity() {
        ProgresoDTO progresoDTO = new ProgresoDTO();
        progresoDTO.setIdProgreso(100);
        progresoDTO.setIdUsuario(200);
        progresoDTO.setIdHistoria(300);
        progresoDTO.setFecha(LocalDate.of(2024, 12, 25));
        progresoDTO.setHistoriasDesbloqueadas("Historia Finalizada");

        assertEquals(100, progresoDTO.getIdProgreso());
        assertEquals(200, progresoDTO.getIdUsuario());
        assertEquals(300, progresoDTO.getIdHistoria());
        assertEquals(LocalDate.of(2024, 12, 25), progresoDTO.getFecha());
        assertEquals("Historia Finalizada", progresoDTO.getHistoriasDesbloqueadas());
    }
}


