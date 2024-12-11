package dev.lara.End.Game.config;

import dev.lara.End.Game.dtos.UsuarioDTO;

public class LoginResponse { 

     
    private String message;
    private String email;
    private UsuarioDTO usuarioDTO;

    public LoginResponse(String message, String email, UsuarioDTO usuarioDTO) {
        this.message = message;
        this.email = email;
        this.usuarioDTO = usuarioDTO;
    }
    

    public String getMessage() {
        return message;        
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }


    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
}