package dev.lara.End.Game.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.ProgresoRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;

@SuppressWarnings("unused")
@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuariosService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;

    }

    public UsuarioDTO registrarUsuario(String nombreUsuario, String correo, String password){
        Usuario usuario = new Usuario();
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    public void borrarUsuario(int usuarioId) {
        if (usuarioRepository.existsById(usuarioId)) {
            usuarioRepository.deleteById(usuarioId);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + usuarioId);
        }
    }



}
