package dev.lara.End.Game.dtos;

import dev.lara.End.Game.models.Usuario;

public class UsuarioDTO {
    private String nombreUsuario;
    private String correo;
    private String password;
    private String rolNombre;
    private int idUsuario;
    private RolDTO rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int idUsuario, String nombreUsuario, String correo, RolDTO rol, String password) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.rol = rol;
        this.password = password;
    }

    public UsuarioDTO(Usuario user) {
        this.idUsuario = user.getIdUsuario();
        this.nombreUsuario = user.getNombreUsuario();
        this.correo = user.getCorreo();
        this.rol = new RolDTO(user.getRol());
        this.password = user.getPassword();
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

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

}