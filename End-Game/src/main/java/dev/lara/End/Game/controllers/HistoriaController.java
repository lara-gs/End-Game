package dev.lara.End.Game.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.services.HistoriaService;

@RestController
@RequestMapping(path = "/api/historia")
public class HistoriaController {

    HistoriaService historiaService;

    public HistoriaController(HistoriaService historiaService) {
        this.historiaService = historiaService;
    }

    @GetMapping(path = "/historias")
    public ResponseEntity<List<HistoriaDTO>> cargarHistoria() {
        return new ResponseEntity<>(historiaService.cargarHistoria(), HttpStatus.OK);
    }

}