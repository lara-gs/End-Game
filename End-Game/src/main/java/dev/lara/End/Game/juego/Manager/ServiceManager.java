package dev.lara.End.Game.juego.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.lara.End.Game.config.LoginRequest;
import dev.lara.End.Game.config.LoginResponse;
import dev.lara.End.Game.controllers.AuthController;
import dev.lara.End.Game.controllers.HistoriaController;
import dev.lara.End.Game.controllers.OpcionesController;
import dev.lara.End.Game.controllers.ProgresoController;
import dev.lara.End.Game.controllers.RolController;
import dev.lara.End.Game.controllers.UsuarioController;
import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.repositories.HistoriaRepository;
import dev.lara.End.Game.repositories.OpcionesRepository;
import dev.lara.End.Game.repositories.ProgresoRepository;
import dev.lara.End.Game.repositories.RolRepository;
import dev.lara.End.Game.repositories.UsuarioRepository;
import dev.lara.End.Game.services.AuthService;
import dev.lara.End.Game.services.HistoriaService;
import dev.lara.End.Game.services.OpcionesService;
import dev.lara.End.Game.services.ProgresoService;
import dev.lara.End.Game.services.RolService;
import dev.lara.End.Game.services.UsuariosService;

public class ServiceManager {

    //#region Controllers
    AuthController authController;
    HistoriaController historiaController;
    OpcionesController opcionesController;
    ProgresoController progresoController;
    RolController rolController;
    UsuarioController userController;
    //#endregion
    
    //#region Services
    AuthService authService;
    HistoriaService historiaService;
    OpcionesService opcionesService;
    ProgresoService progresoService;
    RolService rolService;
    UsuariosService usuariosService;
    //#endregion

    //#region Repositories
    @Autowired
    HistoriaRepository historiaRepository;
    @Autowired
    OpcionesRepository opcionesRepository;
    @Autowired
    ProgresoRepository progresoRepository;
    @Autowired
    RolRepository rolRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    //#endregion
    @Autowired
    PasswordEncoder passwordEncoder;


    public ServiceManager() {
        InitializeServices();
        InitializeControllers();
    }



    private void InitializeServices() {
        authService = new AuthService(usuarioRepository, passwordEncoder);
        historiaService = new HistoriaService(historiaRepository, opcionesRepository, progresoRepository);
        opcionesService = new OpcionesService(opcionesRepository);
        progresoService = new ProgresoService(usuarioRepository, historiaRepository, progresoRepository);   
        rolService = new RolService(rolRepository, usuarioRepository);
        usuariosService = new UsuariosService(passwordEncoder);
    }

    private void InitializeControllers() {
        authController = new AuthController(authService);
        historiaController = new HistoriaController(historiaService);
        opcionesController = new OpcionesController(opcionesService);
        progresoController = new ProgresoController(progresoService);
        rolController = new RolController(rolService);
        userController = new UsuarioController(usuariosService, rolRepository, rolService);
    }

    public LoginResponse login(LoginRequest loginRequest)
    {
        return authController.login(loginRequest);
    }

    public UsuarioDTO registerUser(UsuarioDTO usuario)
    {
        return userController.registrarUsuario(usuario).getBody();
    }

    public void deleteUser(int idUsuario)
    {
        userController.borrarPartida(idUsuario);
    }   

    public List<HistoriaDTO> cargarHistorias()
    {
        return historiaController.cargarHistoria().getBody();
    }
    
    public List<OpcionesDTO> cargarOpciones(int historiaId)
    {
        return opcionesController.cargarOpciones(historiaId).getBody();
    }

    public ProgresoDTO cargarPartida(int idUsuario)
    {
        return progresoController.cargarPartida(idUsuario).getBody();
    }

    public void borrarPartida(int IdPartida)
    {
        progresoController.borrarPartida(IdPartida);
    }

    public ProgresoDTO guardarPartida(ProgresoDTO progreso)
    {
        return progresoController.guardarPartida(progreso).getBody();
    }

    public List<RolDTO> cargarRoles()
    {
        return rolController.cargarRoles().getBody();
    }
}

