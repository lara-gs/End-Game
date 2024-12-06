package dev.lara.End.Game.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.dtos.ProgresoDTO;

import dev.lara.End.Game.services.ProgresoService;


@RestController
@RequestMapping(path = "/api/progreso")
public class ProgresoController {

    ProgresoService progresoService;

    public ProgresoController(ProgresoService progresoService) {
        this.progresoService = progresoService;
    }

    @GetMapping("/cargar/{idUsuario}")
    public ResponseEntity<ProgresoDTO> cargarPartida(@PathVariable int idUsuario) {
        return new ResponseEntity<>(progresoService.cargarPartida(idUsuario), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{IdPartida}")
    public ResponseEntity<Void> borrarPartida(@PathVariable int IdPartida) {
        progresoService.borrarPartida(IdPartida);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<ProgresoDTO> guardarPartida(@RequestBody ProgresoDTO progreso) {
        return new ResponseEntity<>(progresoService.guardarPartida(progreso.getIdUsuario(), progreso.getIdHistoria()),
                HttpStatus.CREATED);
    }

}
