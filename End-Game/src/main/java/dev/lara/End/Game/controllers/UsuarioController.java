package dev.lara.End.Game.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.services.UsuariosService;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {

 UsuariosService usuariosService;

    public UsuarioController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

     @DeleteMapping("/borrar/{IdUsuario}")
    public ResponseEntity<Void> borrarPartida(@PathVariable int IdUsuario) {
        usuariosService.borrarUsuario(IdUsuario);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.registrarUsuario(
            usuarioDTO.getNombreUsuario(), usuarioDTO.getCorreo(), usuarioDTO.getPassword()), HttpStatus.CREATED);
    }

}
