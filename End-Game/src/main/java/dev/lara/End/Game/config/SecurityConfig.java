package dev.lara.End.Game.config;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private final UsuarioRepository usuarioRepository;

    public SecurityConfig(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Configuración de la cadena de filtros de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para pruebas (habilitar en producción)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/admin/**").hasRole("ADMIN") // Rutas protegidas para ADMIN
                                .requestMatchers("/player/**").hasRole("PLAYER") // Rutas protegidas para PLAYER
                                .requestMatchers("/public/**").permitAll() // Rutas públicas
                                .anyRequest().authenticated() // Otras rutas requieren autenticación
                )
                .httpBasic(withDefaults()); // Usar autenticación básica

        return http.build();
    }

    // Codificador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de UserDetailsService para usar la base de datos
@Bean
public UserDetailsService userDetailsService() {
    return username -> {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
            .username(usuario.getNombreUsuario())
            .password(usuario.getPassword())
            .roles(usuario.getRol().getNombreRol())
            .build();
    };
}

}
