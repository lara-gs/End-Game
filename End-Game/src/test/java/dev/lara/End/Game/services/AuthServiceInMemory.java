package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;

import java.util.HashMap;
import java.util.Map;

public class AuthServiceInMemory extends AuthService {

    private Map<String, Usuario> usuarios = new HashMap<>();

    public AuthServiceInMemory() {
        super(null, null); 
    }

    public void save(Usuario usuario) {
        usuarios.put(usuario.getCorreo(), usuario);
    }

    @Override
    public Usuario authenticate(String correo, String password) {
        Usuario usuario = usuarios.get(correo);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        if (usuario.getPassword().equals(password)) {
            return usuario;
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}
