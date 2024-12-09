package dev.lara.End.Game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "dev.lara.End.Game")
@EnableAsync
public class EndGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndGameApplication.class, args);
	}

}
