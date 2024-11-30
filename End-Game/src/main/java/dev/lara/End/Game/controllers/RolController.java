package dev.lara.End.Game.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.services.RolService;

@RestController
@RequestMapping(path ="/api/roles")
public class RolController {

    RolService rolService;

    public RolController(RolService rolService){
        this.rolService = rolService;
    }

     @GetMapping("/lista")
    public ResponseEntity<List<RolDTO>> cargarOpciones(){
        return new ResponseEntity<>(rolService.cargarRoles(), HttpStatus.OK);
    }
}
