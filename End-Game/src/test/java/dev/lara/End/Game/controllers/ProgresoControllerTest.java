package dev.lara.End.Game.controllers;

import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.services.ProgresoService;
import dev.lara.End.Game.services.UsuarioRepositoryInMemory;
import dev.lara.End.Game.services.HistoriaRepositoryInMemory;
import dev.lara.End.Game.services.ProgresoRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class ProgresoControllerTest {

    private ProgresoController progresoController;

     @Autowired
    private HistoriaRepositoryInMemory historiaRepository;
    @Autowired
    private ProgresoRepositoryInMemory progresoRepository;
    @Autowired
    private UsuarioRepositoryInMemory usuarioRepository;

    @InjectMocks
    private ProgresoService progresoService;

    Progreso progresoMock;
    Usuario usuarioMock1;
    Historia historiaMock;

    @BeforeEach
    void setUp() {
        progresoRepository = new ProgresoRepositoryInMemory();
        usuarioRepository = new UsuarioRepositoryInMemory();
        historiaRepository = new HistoriaRepositoryInMemory();

        usuarioMock1 = new Usuario();
        usuarioMock1.setIdUsuario(1);
        usuarioMock1 = usuarioRepository.save(usuarioMock1);
        Usuario usuarioMock2 = new Usuario();
        usuarioMock2.setIdUsuario(2);

        historiaMock = new Historia();
        historiaMock.setIdHistoria(2);
        historiaMock = historiaRepository.save(historiaMock);

        progresoMock = new Progreso();
        progresoMock.setUsuario(usuarioMock1);
        progresoMock.setHistoria(historiaMock);
        progresoMock.setFecha(LocalDate.now());
        progresoMock.setHistoriasDesbloqueadas("1,2,3");
        progresoMock = progresoRepository.save(progresoMock);

        Progreso progresoMock2 = new Progreso();
        progresoMock2.setUsuario(usuarioMock2);
        progresoMock2.setHistoria(historiaMock);
        progresoMock2.setFecha(LocalDate.now());
        progresoMock2.setHistoriasDesbloqueadas("1,2,3");
        progresoMock2 = progresoRepository.save(progresoMock2);

        progresoService = new ProgresoService(usuarioRepository, historiaRepository, progresoRepository);
        progresoController = new ProgresoController(progresoService);
    }

    @Test
    void testCargarPartida() {
        ResponseEntity<ProgresoDTO> response = progresoController.cargarPartida(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        ProgresoDTO progreso = response.getBody();
        assertNotNull(progreso);
        assertEquals(0, progreso.getIdUsuario());
        assertEquals(0, progreso.getIdHistoria());
    }

    @Test
    void testBorrarPartida() {
        progresoController.borrarPartida(progresoMock.getIdProgreso());
        ResponseEntity<ProgresoDTO> response = progresoController.cargarPartida(1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }
}