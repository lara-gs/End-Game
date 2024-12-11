package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario authenticate(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (passwordEncoder.matches(password, usuario.getPassword())) {
            return usuario;
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}