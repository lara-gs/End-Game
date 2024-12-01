package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar usuario en la base de datos por nombre de usuario
        Usuario usuario = usuarioRepository.findByNombreUsuario(username);
        
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        
        // Retornar un objeto User de Spring Security con los detalles del usuario
        return User.builder()
                .username(usuario.getNombreUsuario())
                .password(usuario.getPassword())
                .roles(usuario.getRol().getNombreRol())  // Asignar roles
                .build();
    }
}
