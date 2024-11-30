package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Historia;

public class HistoriaDTO {
    private int idHistoria;
    private String descripcion;

    public HistoriaDTO(){

    }

    public HistoriaDTO(int idHistoria, String descripcion) {
        this.idHistoria = idHistoria;
        this.descripcion = descripcion;
    }

    public HistoriaDTO(Historia historia){
        this.idHistoria = historia.getIdHistoria();
        this.descripcion = historia.getDescripcion();
    }

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
