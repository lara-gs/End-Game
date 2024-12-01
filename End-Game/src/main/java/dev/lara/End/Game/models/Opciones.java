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

    
    public Opciones() {
    }

    public Opciones(int idOpcion, Usuario usuario, Historia historiaOrigen, Historia historiaDestino) {
        this.idOpcion = idOpcion;
        this.historiaOrigen = historiaOrigen;
        this.historiaDestino = historiaDestino;
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

}
