package dev.lara.End.Game.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuariosService() {
    }

    public UsuariosService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public UsuarioDTO registrarUsuario(String nombreUsuario, String correo, String password, Rol rol) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setCorreo(correo);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setRol(rol);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

    
        RolDTO rolDTO = new RolDTO(usuarioGuardado.getRol());
        UsuarioDTO usuarioDTO = new UsuarioDTO(0, usuarioGuardado.getNombreUsuario(), usuarioGuardado.getCorreo(),
                rolDTO, password);
        return usuarioDTO;
    }

    public void borrarUsuario(int usuarioId) {
        if (usuarioRepository.existsById(usuarioId)) {
            usuarioRepository.deleteById(usuarioId);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + usuarioId);
        }
    }

}