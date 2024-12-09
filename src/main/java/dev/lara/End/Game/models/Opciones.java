package dev.lara.End.Game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "opciones")
public class Opciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOpcion;

    @ManyToOne
    @JoinColumn(name = "id_historia_origen", nullable = false)
    private Historia historiaOrigen;

    @ManyToOne
    @JoinColumn(name = "id_historia_destino", nullable = false)
    private Historia historiaDestino;

    @JoinColumn(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @JoinColumn(name = "opcion_especial", nullable = true)
    private boolean opcion_especial;

    @JoinColumn(name = "id_especial_desbloqueada", nullable = true)
    private Integer id_especial_desbloqueada;

    public Opciones() {
    }

    public Opciones(int idOpcion, Usuario usuario, Historia historiaOrigen,
            Historia historiaDestino, String descripcion, boolean opcion_especial, int id_especial_desbloqueada) {
        this.idOpcion = idOpcion;
        this.historiaOrigen = historiaOrigen;
        this.historiaDestino = historiaDestino;
        this.descripcion = descripcion;
        this.opcion_especial = opcion_especial;
        this.id_especial_desbloqueada = id_especial_desbloqueada;
    }

    public int getId_progreso() {
        return idOpcion;
    }

    public void setId_progreso(int id_progreso) {
        this.idOpcion = id_progreso;
    }

    public Historia getHistoriaOrigen() {
        return historiaOrigen;
    }

    public void setHistoriaOrigen(Historia historiaOrigen) {
        this.historiaOrigen = historiaOrigen;
    }

    public Historia getHistoriaDestino() {
        return historiaDestino;
    }

    public void setHistoriaDestino(Historia historiaDestino) {
        this.historiaDestino = historiaDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public boolean getOpcion_especial() {
        return opcion_especial;
    }

    public void setOpcion_especial(boolean opcion_especial) {
        this.opcion_especial = opcion_especial;
    }

    public int getId_especial_desbloqueada() {
        return id_especial_desbloqueada;
    }

    public void setId_especial_desbloqueada(int id_especial_desbloqueada) {
        this.id_especial_desbloqueada = id_especial_desbloqueada;
    }

}
