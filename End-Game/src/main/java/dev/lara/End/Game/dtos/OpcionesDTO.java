package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Opciones;

public class OpcionesDTO {
    private int idOpcion;
    private int idProgreso;
    private int idUsuario;
    private int idHistoriaOrigen;
    private int idHistoriaDestino;
    private String descripcion;

    public OpcionesDTO(){

    }

    public OpcionesDTO(int idOpcion, int idProgreso, int idUsuario, int idHistoriaOrigen, int idHistoriaDestino, String descripcion) {
        this.idOpcion = idOpcion;
        this.idProgreso = idProgreso;
        this.idUsuario = idUsuario;
        this.idHistoriaOrigen = idHistoriaOrigen;
        this.idHistoriaDestino = idHistoriaDestino;
        this.descripcion = descripcion;
    }

    public OpcionesDTO(Opciones opciones) {
        this.idOpcion = opciones.getIdOpcion();
        this.idProgreso = opciones.getId_progreso();
        this.idHistoriaOrigen = (opciones.getHistoriaOrigen() != null) ? opciones.getHistoriaOrigen().getIdHistoria() : -1; 
        this.idHistoriaDestino = (opciones.getHistoriaDestino() != null) ? opciones.getHistoriaDestino().getIdHistoria() : -1;   
        this.descripcion = opciones.getDescripcion();
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
}
