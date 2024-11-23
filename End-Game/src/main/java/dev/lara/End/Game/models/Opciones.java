package dev.lara.End.Game.models;

import jakarta.persistence.Column;
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
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "id_historia_origen", nullable = false)
    private int idHistoriaOrigen;

    @Column(name = "id_historia_destino", nullable = false)
    private int idHistoriaDestino;


    
    public Opciones() {
    }

    public Opciones(int id_progreso, Usuario usuario, int idHistoriaOrigen, int idHistoriaDestino) {
        this.idOpcion = id_progreso;
        this.usuario = usuario;
        this.idHistoriaOrigen = idHistoriaOrigen;
        this.idHistoriaDestino = idHistoriaDestino;
    }

    public int getId_progreso() {
        return idOpcion;
    }

    public void setId_progreso(int id_progreso) {
        this.idOpcion = id_progreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdHistoriaOrigen() {
        return idHistoriaOrigen;
    }

    public void setIdHistoriaOrigen(int idHistoriaOrigen) {
        this.idHistoriaOrigen = idHistoriaOrigen;
    }

    public int getIdHistoriaDestino() {
        return idHistoriaDestino;
    }

    public void setIdHistoriaDestino(int idHistoriaDestino) {
        this.idHistoriaDestino = idHistoriaDestino;
    }

}
