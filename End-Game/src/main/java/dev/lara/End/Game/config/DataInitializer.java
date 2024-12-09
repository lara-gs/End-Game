package dev.lara.End.Game.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    final static Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (rolRepository.count() == 0) {
            Rol adminRole = new Rol("ADMIN");
            Rol playerRole = new Rol("PLAYER");
            rolRepository.save(adminRole);
            rolRepository.save(playerRole);
        }
        if (usuarioRepository.count() == 0) {
            Usuario admin = new Usuario();
            admin.setNombreUsuario("superadmin");
            admin.setCorreo("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            Optional<Rol> optionalRol = rolRepository.findByNombreRol("ADMIN");
            Rol rolAdmin = optionalRol.orElseThrow(() -> new RuntimeException("Rol no encontrado con nombre ADMIN"));

            admin.setRol(rolAdmin);

            Usuario player = new Usuario();
            player.setNombreUsuario("player1");
            player.setCorreo("player1@game.com");
            player.setPassword(passwordEncoder.encode("player123"));
            Optional<Rol> optionalPlayerRol = rolRepository.findByNombreRol("USER");
            Rol rolPlayer = optionalPlayerRol
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado con nombre PLAYER"));

            player.setRol(rolPlayer);

            usuarioRepository.save(admin);
            usuarioRepository.save(player);
        }
    }

}
