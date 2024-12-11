package dev.lara.End.Game.config;

public class LoginRequest {  
    private String correo;
    private String password;


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getEmail(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }
}