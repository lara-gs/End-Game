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
@Table(name = "historias")
public class Historia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Long idHistoria;

    @OneToMany(mappedBy = "historia")
    private List<Progreso> progresos;

    @OneToMany(mappedBy = "historiaOrigen")
    private List<Opciones> opcionesOrigen;

    @OneToMany(mappedBy = "historiaDestino")
    private List<Opciones> opcionesDestino;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Historia() {
    }

    public Historia(Long idHistoria, String descripcion) {
        this.idHistoria = idHistoria;
        this.descripcion = descripcion;
    }

    public Long getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Long idHistoria) {
        this.idHistoria = idHistoria;
    }

    public List<Opciones> getOpcionesOrigen() {
        return opcionesOrigen;
    }

    public void setOpcionesOrigen(List<Opciones> opcionesOrigen) {
        this.opcionesOrigen = opcionesOrigen;
    }

    public List<Opciones> getOpcionesDestino() {
        return opcionesDestino;
    }

    public void setOpcionesDestino(List<Opciones> opcionesDestino) {
        this.opcionesDestino = opcionesDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}