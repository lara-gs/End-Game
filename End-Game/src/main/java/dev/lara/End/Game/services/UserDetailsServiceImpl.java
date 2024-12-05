package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByNombreUsuario(username);

        Usuario usuario = optionalUsuario.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        
        // Logs para depuración
        System.out.println("Usuario encontrado: " + usuario.getNombreUsuario());
        System.out.println("Roles: " + usuario.getRol().getNombreRol());

        // Convierte el usuario en un objeto UserDetails
        return org.springframework.security.core.userdetails.User.builder()
            .username(usuario.getNombreUsuario())
            .password(usuario.getPassword()) // Contraseña codificada
            .roles(usuario.getRol().getNombreRol()) // Convierte el rol en formato esperado
            .build();
    }
}
