package dev.lara.End.Game.config;

import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataInitializer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (rolRepository.count() == 0) {
            Rol adminRole = new Rol("ADMIN");
            Rol playerRole = new Rol("PLAYER");
            rolRepository.save(adminRole);
            rolRepository.save(playerRole);

            Usuario admin = new Usuario();
            admin.setNombreUsuario("admin");
            admin.setCorreo("admin@game.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol(adminRole);

            Usuario player = new Usuario();
            player.setNombreUsuario("player1");
            player.setCorreo("player1@game.com");
            player.setPassword(passwordEncoder.encode("player123"));
            player.setRol(playerRole);

            usuarioRepository.save(admin);
            usuarioRepository.save(player);
        }
    }
}
