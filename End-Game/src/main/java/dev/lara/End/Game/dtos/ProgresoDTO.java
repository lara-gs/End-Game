package dev.lara.End.Game.dtos;

import java.time.LocalDate;

import dev.lara.End.Game.models.Progreso;

public class ProgresoDTO {
    private int idProgreso;
    private int idUsuario;
    private int idHistoria;
    private LocalDate fecha;
    private String historiasDesbloqueadas;

    public ProgresoDTO() {

    }

    public ProgresoDTO(int idProgreso, int idUsuario, int idHistoria, LocalDate fecha, String historiasDesbloqueadas) {
        this.idProgreso = idProgreso;
        this.idUsuario = idUsuario;
        this.idHistoria = idHistoria;
        this.fecha = fecha;
        this.historiasDesbloqueadas = historiasDesbloqueadas;
    }

    public ProgresoDTO(Progreso progreso) {
        this.idProgreso = progreso.getIdProgreso();
        this.idUsuario = progreso.getUsuario().getIdUsuario();
        this.idHistoria = progreso.getHistoria().getIdHistoria();
        this.fecha = progreso.getFecha();
        this.historiasDesbloqueadas = progreso.getHistoriasDesbloqueadas();
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHistoriasDesbloqueadas() {
        return historiasDesbloqueadas;
    }

    public void setHistoriasDesbloqueadas(String historiasDesbloqueadas) {
        this.historiasDesbloqueadas = historiasDesbloqueadas;
    }

}
