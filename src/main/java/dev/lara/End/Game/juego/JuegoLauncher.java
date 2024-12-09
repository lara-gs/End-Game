package dev.lara.End.Game.juego;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class JuegoLauncher {

    private final Juego juego;

    public JuegoLauncher(Juego juego) {
        this.juego = juego;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Async
    public void startGame() {   
        juego.iniciarJuego();
    }
}
