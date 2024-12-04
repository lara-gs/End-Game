package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String authenticate(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificamos la contraseña usando BCryptPasswordEncoder
        if (passwordEncoder.matches(password, usuario.getPassword())) {
            // Retornamos un mensaje de éxito si las credenciales son correctas
            return "Autenticación exitosa";
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}
