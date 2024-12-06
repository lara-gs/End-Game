package dev.lara.End.Game.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.services.OpcionesService;
import dev.lara.End.Game.services.ProgresoService;

@RestController
@RequestMapping(path ="/api/opciones")
public class OpcionesController {
    OpcionesService opcionesService;


    public OpcionesController(OpcionesService opcionesService){
        this.opcionesService = opcionesService;
    }

    @GetMapping("/{historiaId}")
    public ResponseEntity<List<OpcionesDTO>> cargarOpciones(@PathVariable int historiaId){
        return new ResponseEntity<>(opcionesService.cargarOpciones(historiaId), HttpStatus.OK);
    }

}
