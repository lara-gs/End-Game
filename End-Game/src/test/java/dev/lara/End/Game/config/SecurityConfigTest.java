package dev.lara.End.Game.config;

import dev.lara.End.Game.repositories.UsuarioRepository;
import dev.lara.End.Game.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@SpringBootTest
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @SuppressWarnings("unused")
@Autowired
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp() {
        // Setup de MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(new SecurityConfig(usuarioRepository, userDetailsService)).build();
    }

    @Test
    void testPublicRoutesShouldBeAccessibleWithoutAuthentication() throws Exception {
        // Verifica que el login y el registro público sean accesibles sin autenticación
        mockMvc.perform(get("/api/auth/login"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/usuarios/public/registrar"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/player/some-endpoint"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void testAuthenticatedRoutesShouldBeAccessibleWithAuthentication() throws Exception {
        // Verifica que las rutas protegidas requieren autenticación
        mockMvc.perform(get("/some/protected/route"))
                .andExpect(status().isOk()); // Debería devolver 200 OK si está autenticado
    }

    @Test
    void testUnauthorizedAccessToProtectedRouteWithoutAuthentication() throws Exception {
        // Verifica que una ruta protegida no sea accesible sin autenticación
        mockMvc.perform(get("/some/protected/route"))
                .andExpect(status().isUnauthorized());
    }

    @SuppressWarnings("unused")
@Test
    void testAuthenticationWithBasicAuth() throws Exception {
        // Verifica que la autenticación básica funcione correctamente
        UserDetails userDetails = User.withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build();

        mockMvc.perform(get("/some/protected/route")
                .with(httpBasic("user", "password"))) // Proporcionar credenciales básicas
                .andExpect(status().isOk());
    }

    @Test
    void testAuthenticationFailureWithWrongCredentials() throws Exception {
        // Verifica que la autenticación falla con credenciales incorrectas
        mockMvc.perform(get("/some/protected/route")
                .with(httpBasic("user", "wrongpassword")))
                .andExpect(status().isUnauthorized());
    }
}
