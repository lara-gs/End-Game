package dev.lara.End.Game.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.repositories.OpcionesRepository;
import dev.lara.End.Game.repositories.ProgresoRepository;

@SuppressWarnings("unused")
@Service
public class OpcionesService {

    public OpcionesService(OpcionesRepository opcionesRepository) {
        this.opcionesRepository = opcionesRepository;
    }

    private OpcionesRepository opcionesRepository;

    public List<OpcionesDTO> cargarOpciones(int idHistoria) {
        return opcionesRepository.findAll().stream().filter(o -> o.getHistoriaOrigen().getIdHistoria() == idHistoria)
                .map(opciones -> new OpcionesDTO(opciones)).toList();
    }

}
