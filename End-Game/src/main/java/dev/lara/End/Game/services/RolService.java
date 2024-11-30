package dev.lara.End.Game.services;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;

@Service
public class RolService {
    RolRepository repository;
    UsuarioRepository usuarioRepository;

    public RolService(RolRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<RolDTO> cargarRoles(){
        return repository.findAll().stream().map(Rol-> new RolDTO(Rol)).toList();       
    }
}


    

