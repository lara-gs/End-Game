package dev.lara.End.Game.config;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.config.Customizer.withDefaults;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import dev.lara.End.Game.repositories.UsuarioRepository;
import dev.lara.End.Game.services.UserDetailsServiceImpl;




public class SecurityConfigTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UserDetailsServiceImpl userDetailsService;

    @InjectMocks
    private SecurityConfig securityConfig;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticationManager() throws Exception {
        HttpSecurity http = mock(HttpSecurity.class);
        AuthenticationManager authenticationManager = securityConfig.authenticationManager(http);
        assertNotNull(authenticationManager);
    }

    @Test
    public void testPasswordEncoder() {
        PasswordEncoder passwordEncoder = securityConfig.passwordEncoder();
        assertNotNull(passwordEncoder);
    }

    /*@Test
    public void testSecurityFilterChain() throws Exception {
        HttpSecurity http = mock(HttpSecurity.class);
        when(http.csrf(withDefaults())).thenReturn(http);
        AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry = mock(AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry.class);
        when(http.authorizeHttpRequests()).thenReturn(registry);
        ExceptionHandlingConfigurer<HttpSecurity> exceptionHandlingConfigurer = mock(ExceptionHandlingConfigurer.class);
        when(http.exceptionHandling()).thenReturn(exceptionHandlingConfigurer);
        when(http.httpBasic()).thenReturn(http);

        SecurityFilterChain securityFilterChain = securityConfig.securityFilterChain(http);
        assertNotNull(securityFilterChain);
    }*/
}
