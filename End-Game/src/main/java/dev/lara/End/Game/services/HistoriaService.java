package dev.lara.End.Game.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.repositories.HistoriaRepository;
import dev.lara.End.Game.repositories.OpcionesRepository;
import dev.lara.End.Game.repositories.ProgresoRepository;


@Service
public class HistoriaService {
    private HistoriaRepository historiaRepository;
    @SuppressWarnings("unused")
    private OpcionesRepository opcionesRepository;
    @SuppressWarnings("unused")
    private ProgresoRepository progresoRepository;


    public HistoriaService(HistoriaRepository repository, OpcionesRepository opcionesRepository,
            ProgresoRepository progresoRepository) {
        this.historiaRepository = repository;
        this.opcionesRepository = opcionesRepository;
        this.progresoRepository = progresoRepository;
    }

    public List<HistoriaDTO> cargarHistoria(){
       return historiaRepository.findAll().stream().map(historia -> 
       new HistoriaDTO(historia)).toList();    
    }

}
