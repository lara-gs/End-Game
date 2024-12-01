package dev.lara.End.Game.config;

import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Crear roles iniciales
        if (rolRepository.count() == 0) {
            Rol adminRole = new Rol("ADMIN");
            Rol userRole = new Rol("USER");
            rolRepository.save(adminRole);
            rolRepository.save(userRole);
        }

        // Crear usuario ADMIN inicial
        Optional<Usuario> adminUser = usuarioRepository.findByCorreo("admin@example.com");
        if (adminUser.isEmpty()) {
            Rol adminRole = rolRepository.findByNombreRol("ADMIN")
                    .orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));

            Usuario admin = new Usuario();
            admin.setNombreUsuario("admin");
            admin.setCorreo("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol(adminRole);
            usuarioRepository.save(admin);
        }

        // Crear usuario USER inicial
        Optional<Usuario> normalUser = usuarioRepository.findByCorreo("user@example.com");
        if (normalUser.isEmpty()) {
            Rol userRole = rolRepository.findByNombreRol("USER")
                    .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));

            Usuario user = new Usuario();
            user.setNombreUsuario("user");
            user.setCorreo("user@example.com");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setRol(userRole);
            usuarioRepository.save(user);
        }
    }
}
