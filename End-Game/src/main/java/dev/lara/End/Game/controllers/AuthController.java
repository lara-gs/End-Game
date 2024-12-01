package dev.lara.End.Game.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lara.End.Game.config.LoginRequest;
import dev.lara.End.Game.config.LoginResponse;
import dev.lara.End.Game.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint para autenticar al usuario y devolver el token JWT
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        // Llamamos al servicio de autenticación y obtenemos el token
        String token = authService.authenticate(loginRequest.getCorreo(), loginRequest.getPassword());

        // Devolvemos la respuesta con el token y el correo
        return new LoginResponse(token, loginRequest.getCorreo());
    }
}
