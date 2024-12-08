package dev.lara.End.Game.services;

import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.HistoriaRepository;
import dev.lara.End.Game.repositories.ProgresoRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProgresoServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    
    @Mock
    private HistoriaRepository historiaRepository;
    
    @Mock
    private ProgresoRepository progresoRepository;

    @InjectMocks
    private ProgresoService progresoService;

    private Usuario usuario;
    private Historia historia;
    private Progreso progreso;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configurar los mocks
        usuario = new Usuario();
        usuario.setIdUsuario(1);

        historia = new Historia();
        historia.setIdHistoria(1);
        historia.setDescripcion("Historia de prueba");

        progreso = new Progreso();
        progreso.setIdProgreso(1);
        progreso.setUsuario(usuario);
        progreso.setHistoria(historia);
        progreso.setFecha(LocalDate.now());
    }

    @Test
    public void testCargarPartida() {
        // Mocking el comportamiento del repositorio
        when(progresoRepository.findByUsuario_IdUsuario(1)).thenReturn(progreso);

        // Ejecutar el servicio
        ProgresoDTO progresoDTO = progresoService.cargarPartida(1);

        // Verificar los resultados
        assertNotNull(progresoDTO);
        assertEquals(1, progresoDTO.getIdProgreso());
        assertEquals(1, progresoDTO.getIdUsuario());
        assertEquals(1, progresoDTO.getIdHistoria());
        assertEquals("Historia de prueba", progreso.getHistoria().getDescripcion());  // Acceso indirecto a la descripción
    }

    @Test
    public void testGuardarPartidaCreandoNuevoProgreso() {
        // Mocking los repositorios
        when(progresoRepository.findByUsuario_IdUsuario(1)).thenReturn(null);
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(historiaRepository.findById(1)).thenReturn(Optional.of(historia));

        // Ejecutar el servicio
        ProgresoDTO progresoDTO = progresoService.guardarPartida(1, 1);

        // Verificar que se crea un nuevo progreso
        assertNotNull(progresoDTO);
        assertEquals(1, progresoDTO.getIdUsuario());
        assertEquals(1, progresoDTO.getIdHistoria());
        assertNotNull(progresoDTO.getFecha());  // Verificar que la fecha no es nula
    }

    @Test
    public void testGuardarPartidaActualizandoProgresoExistente() {
        // Mocking los repositorios
        when(progresoRepository.findByUsuario_IdUsuario(1)).thenReturn(progreso);
        when(historiaRepository.findById(1)).thenReturn(Optional.of(historia));

        // Ejecutar el servicio
        ProgresoDTO progresoDTO = progresoService.guardarPartida(1, 1);

        // Verificar que el progreso fue actualizado
        assertNotNull(progresoDTO);
        assertEquals(1, progresoDTO.getIdUsuario());
        assertEquals(1, progresoDTO.getIdHistoria());
        assertNotNull(progresoDTO.getFecha());  // Verificar que la fecha no es nula
    }

    @Test
    public void testBorrarPartida() {
        // Mocking el repositorio
        when(progresoRepository.findById(1)).thenReturn(Optional.of(progreso));

        // Ejecutar el servicio
        progresoService.borrarPartida(1);

        // Verificar que el repositorio de progreso lo eliminó
        verify(progresoRepository, times(1)).deleteById(1);
    }
}
