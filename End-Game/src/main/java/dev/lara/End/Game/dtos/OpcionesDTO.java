package dev.lara.End.Game.dtos;

public class OpcionesDTO {
    private int idProgreso;
    private int idUsuario;
    private int idHistoria;
    private String fecha;

    public OpcionesDTO(){

    }

    public OpcionesDTO(int idProgreso, int idUsuario, int idHistoria, String fecha) {
        this.idProgreso = idProgreso;
        this.idUsuario = idUsuario;
        this.idHistoria = idHistoria;
        this.fecha = fecha;
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

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
