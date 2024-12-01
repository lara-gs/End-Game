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
@Table(name = "usuarios")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @ManyToOne 
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String correo;
    


    public Usuario(int idUsuario, Rol rol, String nombreUsuario, String password, String correo) {
        this.idUsuario = idUsuario;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
    }



    public Usuario(){

    }



    public int getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }



    public Rol getRol() {
        return rol;
    }



    public void setRol(Rol rol) {
        this.rol = rol;
    }



    public String getNombreUsuario() {
        return nombreUsuario;
    }



    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getCorreo() {
        return correo;
    }



    public void setCorreo(String correo) {
        this.correo = correo;
    }
}