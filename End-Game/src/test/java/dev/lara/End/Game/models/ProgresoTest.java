package dev.lara.End.Game.models;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgresoTest {

    private Progreso progreso;
    private Usuario usuario;
    private Historia historia;
    private LocalDate fecha;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Lara");

        historia = new Historia(1, "Historia de prueba");

        fecha = LocalDate.of(2024, 12, 7);

        progreso = new Progreso(usuario, historia, fecha);
    }

    @Test
    void testConstructor() {
        assertNotNull(progreso);
        assertEquals(usuario, progreso.getUsuario());
        assertEquals(historia, progreso.getHistoria());
        assertEquals(fecha, progreso.getFecha());
    }

    @Test
    void testSettersAndGetters() {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setIdUsuario(2);
        nuevoUsuario.setNombreUsuario("Otro Usuario");

        Historia nuevaHistoria = new Historia(2, "Otra historia de prueba");
        LocalDate nuevaFecha = LocalDate.of(2025, 1, 1);

        progreso.setUsuario(nuevoUsuario);
        progreso.setHistoria(nuevaHistoria);
        progreso.setFecha(nuevaFecha);
        progreso.setIdProgreso(10);

        assertEquals(nuevoUsuario, progreso.getUsuario());
        assertEquals(nuevaHistoria, progreso.getHistoria());
        assertEquals(nuevaFecha, progreso.getFecha());
        assertEquals(10, progreso.getIdProgreso());
    }

    @Test
    void testIdProgreso() {
        progreso.setIdProgreso(5);
        assertEquals(5, progreso.getIdProgreso());
    }

    @Test
    void testUsuarioNull() {
        progreso.setUsuario(null);
        assertNull(progreso.getUsuario());
    }

    @Test
    void testHistoriaNull() {
        progreso.setHistoria(null);
        assertNull(progreso.getHistoria());
    }

    @Test
    void testFechaNull() {
        progreso.setFecha(null);
        assertNull(progreso.getFecha());
    }

    @Test
    void testFechaValida() {
        LocalDate nuevaFecha = LocalDate.of(2023, 5, 15);
        progreso.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, progreso.getFecha());
    }

    @Test
void testConstructorWithNullValues() {
    Progreso progresoNulo = new Progreso(null, null, null);

    assertNull(progresoNulo.getUsuario());
    assertNull(progresoNulo.getHistoria());
    assertNull(progresoNulo.getFecha());
}

@Test
void testSetFechaConFechaPasada() {
    LocalDate fechaPasada = LocalDate.of(2000, 1, 1);
    progreso.setFecha(fechaPasada);

    assertEquals(fechaPasada, progreso.getFecha());
}

@Test
void testSetFechaConFechaFutura() {
    LocalDate fechaFutura = LocalDate.of(2050, 1, 1);
    progreso.setFecha(fechaFutura);

    assertEquals(fechaFutura, progreso.getFecha());
}

@Test
void testUsuarioConDatosParciales() {
    Usuario usuarioParcial = new Usuario();
    usuarioParcial.setIdUsuario(99);

    progreso.setUsuario(usuarioParcial);

    assertEquals(99, progreso.getUsuario().getIdUsuario());
    assertNull(progreso.getUsuario().getNombreUsuario());
}

@Test
void testHistoriaConDatosParciales() {
    Historia historiaParcial = new Historia();
    historiaParcial.setIdHistoria(50);

    progreso.setHistoria(historiaParcial);

    assertEquals(50, progreso.getHistoria().getIdHistoria());
    assertNull(progreso.getHistoria().getDescripcion());
}

@Test
void testSetIdProgresoNegativo() {
    progreso.setIdProgreso(-1);

    assertEquals(-1, progreso.getIdProgreso());
}

@Test
void testSetFechaHoy() {
    LocalDate hoy = LocalDate.now();
    progreso.setFecha(hoy);

    assertEquals(hoy, progreso.getFecha());
}


}
