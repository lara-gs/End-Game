package dev.lara.End.Game.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.services.RolService;

@WebMvcTest(RolController.class)
public class RolControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RolService rolService;

    @Test
    @WithMockUser(roles = "USER")  // Simula un usuario con el rol "USER"
    void testCargarRoles() throws Exception {
        // Preparar datos de prueba
        RolDTO rol1 = new RolDTO(1, "Admin");
        RolDTO rol2 = new RolDTO(2, "User");
        List<RolDTO> roles = List.of(rol1, rol2);

        // Simular el comportamiento del servicio
        given(rolService.cargarRoles()).willReturn(roles);

        // Ejecutar la solicitud GET y verificar la respuesta
        mockMvc.perform(get("/api/roles/lista"))
                .andExpect(status().isOk())  // Verifica que la respuesta sea 200 OK
                .andExpect(jsonPath("$[0].id").value(1))  // Verifica el id del primer rol
                .andExpect(jsonPath("$[0].nombreRol").value("Admin"))  // Verifica el nombre del primer rol
                .andExpect(jsonPath("$[1].id").value(2))  // Verifica el id del segundo rol
                .andExpect(jsonPath("$[1].nombreRol").value("User"));  // Verifica el nombre del segundo rol
    }
}
