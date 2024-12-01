package dev.lara.End.Game.services;

import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${jwt.secret:#{environment.JWT_SECRET}}") // Esta es la clave para la propiedad jwt.secret
    private String jwtSecret;

    public AuthService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Método para autenticar al usuario y generar el token JWT
    public String authenticate(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        // Verificamos la contraseña usando BCryptPasswordEncoder
        if (passwordEncoder.matches(password, usuario.getPassword())) {
            // Generamos el token JWT si las credenciales son correctas
            return generateJwtToken(usuario);
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }

    // Generar el token JWT
    private String generateJwtToken(Usuario usuario) {
        // Convertimos la clave secreta en un objeto Key
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .setSubject(String.valueOf(usuario.getIdUsuario())) // El id del usuario como "subject" del token
                .setIssuedAt(new Date()) // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Expiración en 1 hora
                .signWith(key, SignatureAlgorithm.HS512) // Firma con la clave secreta convertida a Key
                .compact();
    }
}
