package dev.lara.End.Game.dtos;

public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String correo;
    private String rol;

    
    public UsuarioDTO() {
    }


    public UsuarioDTO(int idUsuario, String nombreUsuario, String correo, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.rol = rol;
    }


    public int getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getRol() {
        return rol;
    }


    public void setRol(String rol) {
        this.rol = rol;
    }


    
}
