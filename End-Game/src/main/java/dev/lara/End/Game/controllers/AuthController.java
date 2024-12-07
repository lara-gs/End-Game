package dev.lara.End.Game.controllers;

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

    
    private AuthService authService;
    


    public AuthController(AuthService authService) {
        this.authService = authService;
    }



    // Endpoint para autenticar al usuario
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        System.out.println("login run method called");
        // Llamamos al servicio de autenticación
        String message = authService.authenticate(loginRequest.getCorreo(), loginRequest.getPassword());
        System.out.println("login run message: " + message);
        return new LoginResponse(message, loginRequest.getCorreo());
    }
}
