package dev.lara.End.Game.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lara.End.Game.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByCorreo(String correo);
}
