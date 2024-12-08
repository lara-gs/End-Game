package dev.lara.End.Game.config;

import dev.lara.End.Game.models.Rol;
import dev.lara.End.Game.models.Usuario;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DataInitializerTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private DataInitializer dataInitializer;

    @SuppressWarnings("unused")
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    void testRun_method_shouldInitializeRolesAndUsers_whenCalled() {
        // Mock the repository responses
        when(rolRepository.count()).thenReturn(0L); // Simulate that there are no roles in the DB
        when(usuarioRepository.count()).thenReturn(0L); // Simulate that there are no users in the DB
        when(rolRepository.findByNombreRol("ADMIN")).thenReturn(java.util.Optional.of(new Rol("ADMIN")));
        when(rolRepository.findByNombreRol("PLAYER")).thenReturn(java.util.Optional.of(new Rol("PLAYER")));

        // Call the run method
        try {
            dataInitializer.run();
        } catch (Exception e) {
            fail("Run method threw an exception");
        }

        // Verify that the repository methods were called
        verify(rolRepository, times(1)).save(any(Rol.class)); // Verify save method called on rolRepository
        verify(usuarioRepository, times(1)).save(any(Usuario.class)); // Verify save method called on usuarioRepository
    }

    @Test
    void testRun_method_shouldNotInitialize_whenDataExists() throws Exception {
        // Simulate that roles and users already exist in the DB
        when(rolRepository.count()).thenReturn(2L);
        when(usuarioRepository.count()).thenReturn(2L);

        // Call the run method
        dataInitializer.run();

        // Verify that save methods were not called since data already exists
        verify(rolRepository, times(0)).save(any(Rol.class));
        verify(usuarioRepository, times(0)).save(any(Usuario.class));
    }
}
