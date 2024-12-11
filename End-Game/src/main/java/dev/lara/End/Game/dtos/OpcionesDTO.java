package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Opciones;

public class OpcionesDTO {
    private int idOpcion;
    private int idProgreso;
    private int idUsuario;
    private int idHistoriaOrigen;
    private int idHistoriaDestino;
    private String descripcion;
    private boolean opcionEspecial;
    private Integer idOpcionDesbloqueada;

    public OpcionesDTO() {

    }

    public OpcionesDTO(int idOpcion, int idProgreso, int idUsuario, int idHistoriaOrigen,
            int idHistoriaDestino, String descripcion, boolean opcionEspecial, int idOpcionDesbloqueada) {
        this.idOpcion = idOpcion;
        this.idProgreso = idProgreso;
        this.idUsuario = idUsuario;
        this.idHistoriaOrigen = idHistoriaOrigen;
        this.idHistoriaDestino = idHistoriaDestino;
        this.descripcion = descripcion;
        this.opcionEspecial = opcionEspecial;
        this.idOpcionDesbloqueada = idOpcionDesbloqueada;
    }

    public OpcionesDTO(Opciones opciones) {
        this.idProgreso = opciones.getId_progreso();
        this.idHistoriaOrigen = opciones.getHistoriaOrigen().getIdHistoria();
        this.idHistoriaDestino = opciones.getHistoriaDestino().getIdHistoria();
        this.descripcion = opciones.getDescripcion();
        this.opcionEspecial = opciones.getOpcion_especial();
        this.idOpcionDesbloqueada = opciones.getId_especial_desbloqueada();
        this.idOpcion = opciones.getIdOpcion();

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

    public boolean getOpcionEspecial() {
        return opcionEspecial;
    }

    public void setOpcionEspecial(boolean opcionEspecial) {
        this.opcionEspecial = opcionEspecial;
    }

    public int getIdOpcionDesbloqueada() {
        return idOpcionDesbloqueada;
    }

    public void setIdOpcionDesbloqueada(int idOpcionDesbloqueada) {
        this.idOpcionDesbloqueada = idOpcionDesbloqueada;
    }

    public int getIdOpcion() {
        return idOpcion;
    }
 
    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }
}
