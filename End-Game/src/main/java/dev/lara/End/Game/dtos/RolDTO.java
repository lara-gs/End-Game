package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Rol;

public class RolDTO {
    private int id;
    private String nombreRol;

    public RolDTO(){

    }

    public RolDTO(int id, String nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;
    }

    public RolDTO(Rol rol) {
        this.id = rol.getId();
        this.nombreRol = rol.getNombreRol();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    
}
