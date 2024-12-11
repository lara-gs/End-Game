package dev.lara.End.Game.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.models.Historia;
import dev.lara.End.Game.models.Progreso;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.HistoriaRepository;
import dev.lara.End.Game.repositories.ProgresoRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;

@Service
public class ProgresoService {

    private UsuarioRepository usuarioRepository;
    private HistoriaRepository historiaRepository;
    private ProgresoRepository progresoRepository;

    public ProgresoService(UsuarioRepository usuarioRepository, HistoriaRepository historiaRepository,
            ProgresoRepository progresoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.historiaRepository = historiaRepository;
        this.progresoRepository = progresoRepository;
    }

    public ProgresoDTO cargarPartida(int idUsuario) {
        try {
            Progreso progreso = progresoRepository.findByUsuario_IdUsuario(idUsuario);

            return new ProgresoDTO(progreso);
        } catch (Exception e) {
            return new ProgresoDTO();

        }
    }

    public void borrarPartida(int idProgreso) {
        @SuppressWarnings("unused")
        Progreso progreso = progresoRepository.findById(idProgreso)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado con id " + idProgreso));
        progresoRepository.deleteById(idProgreso);
    }

    public ProgresoDTO guardarOActualizarPartida(int idUsuario, int idHistoria, String historiasDesbloqueadas) {
        Progreso progreso = progresoRepository.findByUsuario_IdUsuario(idUsuario);

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + idUsuario));

        Historia historia = historiaRepository.findById(idHistoria)
                .orElseThrow(() -> new RuntimeException("Historia no encontrado con id " + idHistoria));

        if (progreso == null) {
            progreso = new Progreso();
            progreso.setUsuario(usuario);
        }
        progreso.setHistoriasDesbloqueadas(historiasDesbloqueadas);
        progreso.setHistoria(historia);
        progreso.setFecha(LocalDate.now());

        return new ProgresoDTO(progresoRepository.save(progreso));
    }

}