package dev.lara.End.Game.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.config.LoginRequest;
import dev.lara.End.Game.config.LoginResponse;
import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = authService.authenticate(loginRequest.getCorreo(), loginRequest.getPassword());
        if (usuario != null) {
            return new LoginResponse("Autenticación exitosa", loginRequest.getCorreo(), new UsuarioDTO(usuario));
        } else {
            return new LoginResponse("Credenciales incorrectas", loginRequest.getCorreo(), null);
        }
    }
}