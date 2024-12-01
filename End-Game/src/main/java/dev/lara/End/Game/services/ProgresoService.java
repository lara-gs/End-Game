package dev.lara.End.Game.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HistoriaRepository historiaRepository;
    @Autowired
    private ProgresoRepository progresoRepository;

    public ProgresoDTO cargarPartida(int idUsuario){
        Progreso progreso = progresoRepository.findByUsuarioId(idUsuario);
        return new ProgresoDTO(progreso);
    }

    public void borrarPartida(int idProgreso){
        @SuppressWarnings("unused")
        Progreso progreso = progresoRepository.findById(idProgreso)
        .orElseThrow(() -> new RuntimeException("Progreso no encontrado con id " + idProgreso));
        progresoRepository.deleteById(idProgreso);
    }

    public ProgresoDTO guardarPartida(int idUsuario, int idHistoria){
         Progreso progreso = progresoRepository.findByUsuarioId(idUsuario);

         Usuario usuario = usuarioRepository.findById(idUsuario)
         .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + idUsuario));

        Historia historia = historiaRepository.findById(idHistoria)
        .orElseThrow(() -> new RuntimeException("Historia no encontrado con id " + idHistoria));

        if (progreso == null) {
            progreso = new Progreso();
            progreso.setUsuario(usuario);
            progreso.setHistoria(historia);
            progreso.setFecha(LocalDate.now());
        } else {
            progreso.setHistoria(historia);
            progreso.setFecha(LocalDate.now());
        }

        return new ProgresoDTO(progresoRepository.save(progreso));
    }

}
