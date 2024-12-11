package dev.lara.End.Game.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lara.End.Game.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNombreRol(String nombreRol);

}