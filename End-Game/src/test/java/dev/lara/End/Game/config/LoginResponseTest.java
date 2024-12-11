package dev.lara.End.Game.config;

import dev.lara.End.Game.dtos.UsuarioDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginResponseTest {

    @Test
    public void testLoginResponse() {

        UsuarioDTO usuarioDTO = new UsuarioDTO(1, "user1", "user1@game.com", null, "password123");

        String expectedMessage = "Login successful";
        String expectedEmail = "user1@game.com";
        
        LoginResponse loginResponse = new LoginResponse(expectedMessage, expectedEmail, usuarioDTO);

        String message = loginResponse.getMessage();
        String email = loginResponse.getEmail();
        UsuarioDTO responseUsuarioDTO = loginResponse.getUsuarioDTO();

        assertEquals(expectedMessage, message);
        assertEquals(expectedEmail, email);
        assertEquals(usuarioDTO, responseUsuarioDTO);
    }

    @Test
    public void testSettersAndGetters() {
        UsuarioDTO usuarioDTO = new UsuarioDTO(2, "user2", "user2@game.com", null, "password456");
        LoginResponse loginResponse = new LoginResponse("Message", "user2@game.com", usuarioDTO);

        loginResponse.setMessage("Updated Message");
        loginResponse.setEmail("newuser@game.com");

        assertEquals("Updated Message", loginResponse.getMessage());
        assertEquals("newuser@game.com", loginResponse.getEmail());
        assertEquals(usuarioDTO, loginResponse.getUsuarioDTO());
    }

    @Test
    public void testLoginResponseWithNullValues() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        LoginResponse loginResponse = new LoginResponse(null, null, usuarioDTO);

        String message = loginResponse.getMessage();
        String email = loginResponse.getEmail();
        UsuarioDTO responseUsuarioDTO = loginResponse.getUsuarioDTO();

        assertNull(message);
        assertNull(email);
        assertNotNull(responseUsuarioDTO); 
    }
    @Test
    public void testSetUsuarioDTO() {
        UsuarioDTO oldUsuarioDTO = new UsuarioDTO(1, "user1", "user1@game.com", null, "password123");
        UsuarioDTO newUsuarioDTO = new UsuarioDTO(2, "user2", "user2@game.com", null, "password456");

        LoginResponse loginResponse = new LoginResponse("Login successful", "user1@game.com", oldUsuarioDTO);
        loginResponse.setUsuarioDTO(newUsuarioDTO);
        assertEquals(newUsuarioDTO, loginResponse.getUsuarioDTO());
    }
}