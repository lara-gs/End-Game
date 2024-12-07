package dev.lara.End.Game.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.lara.End.Game.config.LoginRequest;
import dev.lara.End.Game.config.LoginResponse;
import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.juego.Manager.ServiceManager;
import dev.lara.End.Game.juego.Utils.Constants;

public class Juego {

    UsuarioDTO currentUser = new UsuarioDTO();
    List<HistoriaDTO> historias = new ArrayList<>();
    List<OpcionesDTO> opciones = new ArrayList<>();
    ProgresoDTO progreso = new ProgresoDTO();
    ServiceManager serviceManager = new ServiceManager();

    public static void main(String[] args) {
        new Juego().iniciarJuego();
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
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            //scanner.close();
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
            scanner.close();

            if (loginResponse != null && loginResponse.getToken().equals(Constants.MENSAJE_EXITO_LOGIN)) {
                System.out.println(Constants.MENSAJE_LOGIN_EXITOSO);
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
            //scanner.close();
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
                historia = historias.stream().filter(h -> h.getIdHistoria() == progreso.getIdHistoria()).findFirst()
                        .orElse(null);
            }

            opciones = serviceManager.cargarOpciones(historia.getIdHistoria());

            System.out.println(historia.getDescripcion());

            elegirOpcion();

        } while (true);
    }

    private void elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        try {           
            int opcionElegida = 1;
            for (OpcionesDTO opcion : opciones) {
                System.out.println(opcionElegida + " " + opcion.getDescripcion());
                opcionElegida++;
            }

            int eleccion = scanner.nextInt();

            OpcionesDTO opcionActual = opciones.get(eleccion - 1);
            progreso.setIdHistoria(opcionActual.getIdHistoriaDestino());
            progreso = serviceManager.guardarPartida(progreso);

        } catch (Exception e) {            
            System.out.println(Constants.MENSAJE_ERROR_ELEGIR_OPCION);
            elegirOpcion();
        }
        finally {
            scanner.close();
        }
    }
}
