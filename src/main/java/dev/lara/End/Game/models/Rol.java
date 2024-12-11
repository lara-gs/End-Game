package dev.lara.End.Game.models;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    @Column(name = "nombre_rol", nullable = false)
    private String nombreRol;

    public Rol() {

    }

    public Rol(int id, String nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;

    }

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
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
        if (nombreRol == null || nombreRol.isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol no puede ser vacío");
        }
        this.nombreRol = nombreRol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Rol rol = (Rol) obj;
        return id == rol.id;
    }

}