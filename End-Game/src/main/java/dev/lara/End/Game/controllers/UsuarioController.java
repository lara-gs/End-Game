package dev.lara.End.Game.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.services.RolService;
import dev.lara.End.Game.services.UsuariosService;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {
    RolRepository rolRepository;
    RolService rolService;
    UsuariosService usuariosService;


    public UsuarioController(UsuariosService usuariosService, RolRepository rolRepository) {
        this.usuariosService = usuariosService;
        this.rolRepository = rolRepository;
    }

    @DeleteMapping("/borrar/{IdUsuario}")
    public ResponseEntity<Void> borrarPartida(@PathVariable int IdUsuario) {
        usuariosService.borrarUsuario(IdUsuario);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/public/registrar")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        // Mapear el nombre del rol a un objeto Rol
        Optional<Rol> optionalRol = rolRepository.findByNombreRol(usuarioDTO.getRolNombre());
            Rol rol = optionalRol.orElseThrow(() -> new RuntimeException("Rol no encontrado con nombre " + usuarioDTO.getRolNombre()));

        // Registrar el usuario usando el servicio
        UsuarioDTO nuevoUsuario = usuariosService.registrarUsuario(
                usuarioDTO.getNombreUsuario(),
                usuarioDTO.getCorreo(),
                usuarioDTO.getPassword(),
                rol);

        return ResponseEntity.ok(nuevoUsuario);
    }
}