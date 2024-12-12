package dev.simulator.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del sistema.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-12.
 */
@SpringBootApplication
public class SimulatorApplication {

  public static void main(String[] args) {

    SpringApplication.run(SimulatorApplication.class, args);
  }

}