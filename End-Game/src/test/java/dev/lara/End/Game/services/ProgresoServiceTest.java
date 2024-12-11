package dev.lara.End.Game.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.models.Usuario;

public class ProgresoServiceTest {
    @Autowired
    private HistoriaRepositoryInMemory historiaRepository;
    @Autowired
    private ProgresoRepositoryInMemory progresoRepository;
    @Autowired
    private UsuarioRepositoryInMemory usuarioRepository;

    @InjectMocks
    private ProgresoService progresoService;


    @BeforeEach
    void setUp() {
        historiaRepository = new HistoriaRepositoryInMemory();
        progresoRepository = new ProgresoRepositoryInMemory();
        usuarioRepository = new UsuarioRepositoryInMemory();


        progresoService = new ProgresoService(usuarioRepository, historiaRepository, progresoRepository);
        
        Historia historiaMock = new Historia();
        historiaMock.setIdHistoria(1);
        historiaMock.setDescripcion("Historia 1");
        historiaRepository.save(historiaMock);
    }

 @Test
    void testCargarPartida() {
        int idUsuario = 0;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        Progreso progreso = new Progreso();
        progreso.setIdProgreso(1);
        progreso.setUsuario(usuario);
        progreso.setFecha(LocalDate.now());
        progresoRepository.save(progreso);

        ProgresoDTO resultado = progresoService.cargarPartida(idUsuario);

        assertNotNull(resultado);
        assertEquals(idUsuario, resultado.getIdUsuario());
    }

    @Test
    void testBorrarPartida() {
        int idProgreso = 1;
        Progreso progreso = new Progreso();
        progreso.setIdProgreso(idProgreso);
        progresoRepository.save(progreso);

        progresoService.borrarPartida(idProgreso);

        Optional<Progreso> deletedProgreso = progresoRepository.findById(idProgreso);
        assertTrue(deletedProgreso.isEmpty());
    }

    @Test
    void testGuardarOActualizarPartida() {
        int idUsuario = 1;
        int idHistoria = 1;
        String historiasDesbloqueadas = "1,2,3";

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        Historia historia = new Historia();
        historia.setIdHistoria(idHistoria);

        usuarioRepository.save(usuario);
        historiaRepository.save(historia);

        ProgresoDTO resultado = progresoService.guardarOActualizarPartida(idUsuario, idHistoria, historiasDesbloqueadas);

        assertNotNull(resultado);
        assertEquals(historiasDesbloqueadas, resultado.getHistoriasDesbloqueadas());
        assertEquals(idUsuario, resultado.getIdUsuario());
        assertEquals(idHistoria, resultado.getIdHistoria());
    }
}
