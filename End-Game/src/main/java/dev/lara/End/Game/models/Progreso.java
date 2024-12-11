package dev.lara.End.Game.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "progresos")
public class Progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progreso")
    private int idProgreso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private Historia historia;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "historias_desbloqueadas", nullable = false)
    private String historiasDesbloqueadas;

    public Progreso() {
    }

    public Progreso(Usuario usuario, Historia historia, LocalDate fecha, String historiasDesbloqueadas) {
        this.usuario = usuario;
        this.historia = historia;
        this.fecha = fecha;
        this.historiasDesbloqueadas = historiasDesbloqueadas;
    }

    public int getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(int idProgreso) {
        this.idProgreso = idProgreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
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