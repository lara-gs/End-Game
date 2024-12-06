package dev.lara.End.Game.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import dev.lara.End.Game.repositories.UsuarioRepository;
import dev.lara.End.Game.services.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

    @SuppressWarnings("unused")
    private final UsuarioRepository usuarioRepository;
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UsuarioRepository usuarioRepository, UserDetailsServiceImpl userDetailsService) {
        this.usuarioRepository = usuarioRepository;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http            
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para pruebas (habilitar en producción)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/api/usuarios/public/registrar").permitAll() // Permitir acceso a todos en /public/registrar
                .requestMatchers("/player/**").permitAll() 
                .anyRequest().authenticated() 
            )
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint((request, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                })
            )
            .httpBasic(withDefaults()); // Usar autenticación básica

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        System.out.println("authenticationManager run method called");
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(userDetailsService)
                   .passwordEncoder(passwordEncoder())
                   .and()
                   .build();
    }
}
