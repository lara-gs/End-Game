package dev.lara.End.Game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lara.End.Game.models.Progreso;

public interface ProgresoRepository extends JpaRepository<Progreso, Integer>{

    Progreso findByUsuarioId(Integer usuarioId);
    
}