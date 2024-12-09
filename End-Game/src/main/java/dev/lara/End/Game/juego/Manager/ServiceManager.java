package dev.lara.End.Game.juego.Manager;

import java.util.List;

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

public class ServiceManager {

    // #region Controllers
    AuthController authController;
    HistoriaController historiaController;
    OpcionesController opcionesController;
    ProgresoController progresoController;
    RolController rolController;
    UsuarioController userController;
    // #endregion

    public ServiceManager(AuthController authController, HistoriaController historiaController,
            OpcionesController opcionesController,
            ProgresoController progresoController, RolController rolController, UsuarioController userController) {
        this.authController = authController;
        this.historiaController = historiaController;
        this.opcionesController = opcionesController;
        this.progresoController = progresoController;
        this.rolController = rolController;
        this.userController = userController;

    }

    public LoginResponse login(LoginRequest loginRequest) {
        return authController.login(loginRequest);
    }

    public UsuarioDTO registerUser(UsuarioDTO usuario) {
        return userController.registrarUsuario(usuario).getBody();
    }

    public void deleteUser(int idUsuario) {
        userController.borrarPartida(idUsuario);
    }

    public List<HistoriaDTO> cargarHistorias() {
        return historiaController.cargarHistoria().getBody();
    }

    public List<OpcionesDTO> cargarOpciones(int historiaId) {
        return opcionesController.cargarOpciones(historiaId).getBody();
    }

    public ProgresoDTO cargarPartida(int idUsuario) {
        return progresoController.cargarPartida(idUsuario).getBody();
    }

    public void borrarPartida(int IdPartida) {
        progresoController.borrarPartida(IdPartida);
    }

    public ProgresoDTO guardarPartida(ProgresoDTO progreso) {
        return progresoController.guardarPartida(progreso).getBody();
    }

    public List<RolDTO> cargarRoles() {
        return rolController.cargarRoles().getBody();
    }
}
