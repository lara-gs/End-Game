package dev.lara.End.Game.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ProgresoTest {

    private Usuario usuario;
    private Historia historia;
    private Progreso progreso;

    @BeforeEach
    void setUp() {
       
        usuario = new Usuario(1, null, "usuario1", "usuario1@example.com", "password");
        historia = new Historia(1, "Historia inicial");
        progreso = new Progreso(usuario, historia, LocalDate.of(2024, 12, 10), "Historia 1 desbloqueada");
    }

    @Test
    void testConstructor() {
        assertEquals(0, progreso.getIdProgreso());
        assertEquals(usuario, progreso.getUsuario());
        assertEquals(historia, progreso.getHistoria());
        assertEquals(LocalDate.of(2024, 12, 10), progreso.getFecha());
        assertEquals("Historia 1 desbloqueada", progreso.getHistoriasDesbloqueadas());
    }

    @Test
    void testSettersAndGetters() {
        progreso.setIdProgreso(2);
        progreso.setUsuario(new Usuario(2, null, "usuario2", "usuario2@example.com", "newpassword"));
        progreso.setHistoria(new Historia(2, "Historia 2"));
        progreso.setFecha(LocalDate.of(2024, 12, 12));
        progreso.setHistoriasDesbloqueadas("Historia 2 desbloqueada");

        assertEquals(2, progreso.getIdProgreso());
        assertEquals("Historia 2", progreso.getHistoria().getDescripcion());
        assertEquals(LocalDate.of(2024, 12, 12), progreso.getFecha());
        assertEquals("Historia 2 desbloqueada", progreso.getHistoriasDesbloqueadas());
    }

    @Test
    void testSetFechaNull() {
        progreso.setFecha(null);
        assertNull(progreso.getFecha());
    }

    @Test
    void testSetHistoriasDesbloqueadasNull() {
        progreso.setHistoriasDesbloqueadas(null);
        assertNull(progreso.getHistoriasDesbloqueadas());
    }

    @Test
    void testSetHistoriasDesbloqueadasEmpty() {
        progreso.setHistoriasDesbloqueadas("");
        assertEquals("", progreso.getHistoriasDesbloqueadas());
    }

    @Test
    void testModificarProgreso() {
        progreso.setFecha(LocalDate.of(2024, 12, 15));
        progreso.setHistoriasDesbloqueadas("Historia 3 desbloqueada");

        assertEquals(LocalDate.of(2024, 12, 15), progreso.getFecha());
        assertEquals("Historia 3 desbloqueada", progreso.getHistoriasDesbloqueadas());
    }

    @Test
    void testSetUsuarioNull() {
        progreso.setUsuario(null);
        assertNull(progreso.getUsuario());
    }

    @Test
    void testSetHistoriaNull() {
        progreso.setHistoria(null);
        assertNull(progreso.getHistoria());
    }

    @Test
    void testRelacionUsuarioHistoria() {
        assertEquals(usuario, progreso.getUsuario());
        assertEquals(historia, progreso.getHistoria());
    }

    @Test
    void testConstructorDefault() {
        Progreso progresoDefault = new Progreso();
        assertNotNull(progresoDefault);
    }
}
