package dev.lara.End.Game.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

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
import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.juego.Manager.ServiceManager;
import dev.lara.End.Game.juego.Utils.Constants;

@Component
public class Juego {

    UsuarioDTO currentUser = new UsuarioDTO();
    List<HistoriaDTO> historias = new ArrayList<>();
    List<OpcionesDTO> opciones = new ArrayList<>();
    ProgresoDTO progreso = new ProgresoDTO();
    ServiceManager serviceManager;

    public Juego(AuthController authController, HistoriaController historiaController,
            OpcionesController opcionesController,
            ProgresoController progresoController, RolController rolController, UsuarioController userController) {
        serviceManager = new ServiceManager(authController, historiaController, opcionesController, progresoController,
                rolController, userController);
    }

    public void iniciarJuego() {
        System.out.println(Constants.MENSAJE_BIENVENIDA);

        loginORegistro();
    }

    public void loginORegistro() {
        try {
            System.out.println(Constants.MENSAJE_LOGIN_REGISTER);
            System.out.println(Constants.MENSAJE_LOGIN);
            System.out.println(Constants.MENSAJE_REGISTER);
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                iniciarSesion();
            } else if (opcion == 2) {
                registrarUsuario();
            } else {
                loginORegistro();
            }
        } catch (Exception e) {
            System.out.println("Error al leer la entrada del usuario");
            loginORegistro();
        }
    }

    public void iniciarSesion() {

        try {
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            System.out.println(Constants.MENSAJE_INTRODUCIR_USUARIO);
            String correo = scanner.nextLine();
            System.out.println(Constants.MENSAJE_INTRODUCIR_CONTRASENA);
            String password = scanner.nextLine();
            //
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setCorreo(correo);
            loginRequest.setPassword(password);
            LoginResponse loginResponse = serviceManager.login(loginRequest);

            if (loginResponse != null && loginResponse.getMessage().equals(Constants.MENSAJE_EXITO_LOGIN)) {
                System.out.println(Constants.MENSAJE_LOGIN_EXITOSO);
                currentUser = loginResponse.getUsuarioDTO();
                System.out.println(Constants.MENSAJE_LOGIN_INICIAR_O_BORRAR);
                System.out.println(Constants.MENSAJE_LOGIN_INICIAR);
                System.out.println(Constants.MENSAJE_LOGIN_BORRAR);
                int opcion = scanner.nextInt();
                if (opcion == 2) {
                    serviceManager.borrarPartida(progreso.getIdProgreso());
                    progreso = new ProgresoDTO();
                }
                inicializarJuego();

            } else {
                System.out.println(Constants.MENSAJE_ERROR_LOGIN);
                loginORegistro();
            }

        } catch (Exception e) {
            System.out.println("Error al leer la entrada del usuario");
            loginORegistro();
        }
    }

    public void registrarUsuario() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Constants.MENSAJE_INTRODUCIR_NOMBRE);
            String nombre = scanner.nextLine();
            System.out.println(Constants.MENSAJE_INTRODUCIR_CORREO);
            String correo = scanner.nextLine();
            System.out.println(Constants.MENSAJE_INTRODUCIR_CONTRASENA_REGISTRO);
            String password = scanner.nextLine();
            UsuarioDTO usuario = new UsuarioDTO(0, nombre, correo, null, password);
            usuario.setRolNombre(Constants.ROL_USER);
            currentUser = serviceManager.registerUser(usuario);
            scanner.close();

            if (currentUser != null) {
                System.out.println(Constants.MENSAJE_REGISTRO_EXITOSO);
                inicializarJuego();
            }

        } catch (Exception e) {
            System.out.println(Constants.MENSAJE_ERROR_REGISTRO);
            loginORegistro();
        }
    }

    public void inicializarJuego() {
        cargarHistorias();
        cargarProgreso();
        cargarOpciones();

        iniciarPartida();
    }

    public void cargarProgreso() {
        progreso = serviceManager.cargarPartida(currentUser.getIdUsuario());

        if (progreso.getHistoriasDesbloqueadas() == null) {
            progreso.setHistoriasDesbloqueadas("");
        }
    }

    public void cargarOpciones() {
        opciones = serviceManager.cargarOpciones(progreso.getIdHistoria());
    }

    public void cargarHistorias() {
        historias = serviceManager.cargarHistorias();
        System.out.println(Constants.MENSAJE_HISTORIAS_CARGADAS);
    }

    public void iniciarPartida() {
        boolean partidaIniciada = false;

        if (progreso != null && progreso.getIdHistoria() != 0) {
            partidaIniciada = true;
        }

        do {
            HistoriaDTO historia = null;
            if (!partidaIniciada) {
                historia = historias.stream().findFirst().orElse(null);

            } else {
                motrarMensajeBienvenida();
                historia = historias.stream().filter(h -> h.getIdHistoria() == progreso.getIdHistoria()).findFirst()
                        .orElse(null);
            }
            partidaIniciada = true;

            opciones = serviceManager.cargarOpciones(historia.getIdHistoria());

            System.out.println(historia.getDescripcion());

            if (opciones.size() > 0) {
                elegirOpcion();
            }

        } while (opciones.size() > 0);

        gestionarFinPartida();
    }

    private void motrarMensajeBienvenida() {
        System.out.println(Constants.MENSAJE_BIENVENIDA_PARTIDA);
    }

    @SuppressWarnings("resource")
    public void gestionarFinPartida() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Constants.MENSAJE_FIN_HISTORIA);
            System.out.println(Constants.MENSAJE_BORRAR_PARTIDA);
            String respuesta = scanner.nextLine();
            if (respuesta == Constants.MENSAJE_SI) {
                serviceManager.borrarPartida(progreso.getIdProgreso());
            } else {
                System.out.println(Constants.MENSAJE_VOLVER_INICIO);
                loginORegistro();
            }
        } catch (Exception e) {
            System.out.println(Constants.MENSAJE_ERROR_FIN_HISTORIA);
            gestionarFinPartida();
        }
    }

    @SuppressWarnings("resource")
    private void elegirOpcion() {

        try {
            int opcionElegida = 1;
            for (OpcionesDTO opcion : opciones) {
                if (opcion.getOpcionEspecial() &&
                        !progreso.getHistoriasDesbloqueadas().contains(opcion.getIdOpcion() + "")) {
                    System.out.println(opcionElegida + " " + opcion.getDescripcion());
                } else if (!opcion.getOpcionEspecial()) {
                    System.out.println(opcionElegida + " " + opcion.getDescripcion());
                }
                opcionElegida++;
            }
            Scanner scanner = new Scanner(System.in);
            int eleccion = scanner.nextInt();

            OpcionesDTO opcionActual = opciones.get(eleccion - 1);
            progreso.setIdHistoria(opcionActual.getIdHistoriaDestino());
            progreso.setIdUsuario(currentUser.getIdUsuario());
            if (opcionActual.getIdOpcionDesbloqueada() != 0) {
                progreso.setHistoriasDesbloqueadas(
                        progreso.getHistoriasDesbloqueadas() + "," + opcionActual.getIdOpcionDesbloqueada());
            }
            progreso = serviceManager.guardarPartida(progreso);

        } catch (Exception e) {
            System.out.println(Constants.MENSAJE_ERROR_ELEGIR_OPCION);
            elegirOpcion();
        }
    }
}
