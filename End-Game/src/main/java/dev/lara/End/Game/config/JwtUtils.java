package dev.lara.End.Game.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    private int jwtExpirationMs = 86400000;  // 1 día de expiración por defecto

    // Extraer JWT del encabezado de la solicitud
    public String getJwtFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        logger.debug("Authorization Header: {}", bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);  // Quita el prefijo "Bearer " del token
        }
        return null;
    }

    // Generar token JWT a partir de UserDetails
    public String generateTokenFromUsername(UserDetails userDetails) {
        String username = userDetails.getUsername();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) // Establecer expiración
                .signWith(key()) // Firmar con la clave secreta
                .compact();
    }

    // Extraer el nombre de usuario desde el token JWT
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder()  // Usamos parserBuilder() para el parseo actualizado
                .setSigningKey(key())   // Usamos la clave secreta
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();  // Extraer el sujeto (nombre de usuario)
    }

    // Obtener la clave secreta (convertir el jwtSecret en una clave de HMAC)
    private Key key() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // Validar el JWT
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()  // Usamos parserBuilder() en vez de los métodos obsoletos
                    .setSigningKey(key())  // Establecemos la clave de firma
                    .build()
                    .parseClaimsJws(authToken);  // Intentamos parsear el token
            return true;
        } catch (MalformedJwtException e) {
            logger.error(" JWT token invalido: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token esta expirado: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token no es soportado: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT esta vacio {}", e.getMessage());
        }
        return false;
    }
}
