package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Opciones;

public class OpcionesDTO {
    private int idProgreso;
    private int idUsuario;
    private int idHistoriaOrigen;
    private int idHistoriaDestino;

    public OpcionesDTO(){

    }

    public OpcionesDTO(int idProgreso, int idUsuario, int idHistoriaOrigen, int idHistoriaDestino) {
        this.idProgreso = idProgreso;
        this.idUsuario = idUsuario;
        this.idHistoriaOrigen = idHistoriaOrigen;
        this.idHistoriaDestino = idHistoriaDestino;
    }

    public OpcionesDTO(Opciones opciones) {
        this.idProgreso = opciones.getId_progreso();
        this.idHistoriaOrigen = opciones.getHistoriaOrigen().getIdHistoria();
        this.idHistoriaDestino = opciones.getHistoriaDestino().getIdHistoria();
    }

    public int getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(int idProgreso) {
        this.idProgreso = idProgreso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
