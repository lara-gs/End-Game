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
        Progreso progreso = progresoRepository.findByUsuario_IdUsuario(idUsuario);
        return new ProgresoDTO(progreso);
    }

    public void borrarPartida(int idProgreso) {
        @SuppressWarnings("unused")
        Progreso progreso = progresoRepository.findById(idProgreso)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado con id " + idProgreso));
        progresoRepository.deleteById(idProgreso);
    }

    public ProgresoDTO guardarPartida(int idUsuario, int idHistoria) {
        // Intentamos obtener el progreso del usuario
        Progreso progreso = progresoRepository.findByUsuario_IdUsuario(idUsuario);

        // Si no existe un progreso, lo creamos
        if (progreso == null) {
            // Recuperar el usuario y la historia
            Usuario usuario = usuarioRepository.findById(idUsuario)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + idUsuario));

            Historia historia = historiaRepository.findById(idHistoria)
                    .orElseThrow(() -> new RuntimeException("Historia no encontrada con id " + idHistoria));

            // Crear un nuevo progreso
            progreso = new Progreso();
            progreso.setUsuario(usuario);
            progreso.setHistoria(historia);
            progreso.setFecha(LocalDate.now());
        } else {
            // Si ya existe un progreso, simplemente actualizamos la historia y la fecha
            Historia historia = historiaRepository.findById(idHistoria)
                    .orElseThrow(() -> new RuntimeException("Historia no encontrada con id " + idHistoria));

            progreso.setHistoria(historia);
            progreso.setFecha(LocalDate.now());
        }

        // Guardamos el progreso actualizado o nuevo
        Progreso savedProgreso = progresoRepository.save(progreso);

        // Retornamos un DTO con el progreso guardado
        return new ProgresoDTO(savedProgreso); // Debería ser no-null si todo se ha guardado correctamente
    }

}
