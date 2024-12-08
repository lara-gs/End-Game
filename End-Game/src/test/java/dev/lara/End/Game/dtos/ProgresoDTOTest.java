package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProgresoDTOTest {

    @Test
    void testConstructorVacio() {
        ProgresoDTO progresoDTO = new ProgresoDTO();

        assertEquals(0, progresoDTO.getIdProgreso());
        assertEquals(0, progresoDTO.getIdUsuario());
        assertEquals(0, progresoDTO.getIdHistoria());
        assertNull(progresoDTO.getFecha());
    }

    @Test
    void testConstructorConParametros() {
        ProgresoDTO progresoDTO = new ProgresoDTO(1, 2, 3, LocalDate.of(2024, 12, 8));

        assertEquals(1, progresoDTO.getIdProgreso());
        assertEquals(2, progresoDTO.getIdUsuario());
        assertEquals(3, progresoDTO.getIdHistoria());
        assertEquals(LocalDate.of(2024, 12, 8), progresoDTO.getFecha());
    }

    @Test
    void testConstructorConProgreso() {
        Rol rol = new Rol(1, "Admin");
        Usuario usuario = new Usuario(1, rol, "Usuario1", "password", "correo@correo.com");
        Historia historia = new Historia(1, "Historia de ejemplo");
        Progreso progreso = new Progreso(usuario, historia, LocalDate.of(2024, 12, 8));

        ProgresoDTO progresoDTO = new ProgresoDTO(progreso);

        assertEquals(0, progresoDTO.getIdProgreso()); // El idProgreso es 0 porque no se inicializa en ProgresoDTO
        assertEquals(1, progresoDTO.getIdUsuario());
        assertEquals(1, progresoDTO.getIdHistoria());
        assertEquals(LocalDate.of(2024, 12, 8), progresoDTO.getFecha());
    }

    @Test
    void testSettersYGetters() {
        ProgresoDTO progresoDTO = new ProgresoDTO();

        progresoDTO.setIdProgreso(5);
        progresoDTO.setIdUsuario(6);
        progresoDTO.setIdHistoria(7);
        progresoDTO.setFecha(LocalDate.of(2024, 12, 8));

        assertEquals(5, progresoDTO.getIdProgreso());
        assertEquals(6, progresoDTO.getIdUsuario());
        assertEquals(7, progresoDTO.getIdHistoria());
        assertEquals(LocalDate.of(2024, 12, 8), progresoDTO.getFecha());
    }

    @Test
    void testSetFechaNula() {
        ProgresoDTO progresoDTO = new ProgresoDTO();
        progresoDTO.setFecha(null);

        assertNull(progresoDTO.getFecha());
    }

    @Test
    void testSetIdProgresoNegativo() {
        ProgresoDTO progresoDTO = new ProgresoDTO();
        progresoDTO.setIdProgreso(-1);

        assertEquals(-1, progresoDTO.getIdProgreso());
    }


    @Test
    void testActualizarCamposConSetters() {
        ProgresoDTO progresoDTO = new ProgresoDTO(1, 2, 3, LocalDate.of(2024, 12, 8));

        // Actualizamos los valores
        progresoDTO.setIdProgreso(10);
        progresoDTO.setIdUsuario(20);
        progresoDTO.setIdHistoria(30);
        progresoDTO.setFecha(LocalDate.of(2025, 1, 1));

        assertEquals(10, progresoDTO.getIdProgreso());
        assertEquals(20, progresoDTO.getIdUsuario());
        assertEquals(30, progresoDTO.getIdHistoria());
        assertEquals(LocalDate.of(2025, 1, 1), progresoDTO.getFecha());
    }

    @Test
    void testIdProgresoCeroConConstructorVacio() {
        ProgresoDTO progresoDTO = new ProgresoDTO();

        assertEquals(0, progresoDTO.getIdProgreso());
    }

    @Test
    void testSetIdUsuarioYIdHistoriaNull() {
        ProgresoDTO progresoDTO = new ProgresoDTO();

        // Probamos si podemos establecer idUsuario y idHistoria como null (en este caso
        // no debería ser nulo, pero puedes comprobar el comportamiento)
        progresoDTO.setIdUsuario(0);
        progresoDTO.setIdHistoria(0);

        assertEquals(0, progresoDTO.getIdUsuario());
        assertEquals(0, progresoDTO.getIdHistoria());
    }

    @Test
    void testSetFechaNull() {
        ProgresoDTO progresoDTO = new ProgresoDTO();
        progresoDTO.setFecha(null);

        assertNull(progresoDTO.getFecha());
    }

    @Test
    void testIdProgresoLimite() {
        ProgresoDTO progresoDTO = new ProgresoDTO();
        progresoDTO.setIdProgreso(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, progresoDTO.getIdProgreso());

        progresoDTO.setIdProgreso(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, progresoDTO.getIdProgreso());
    }

}
