package dev.simulator.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal del sistema.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-17.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"dev.simulator"})
public class SimulatorApplication {

  ////
  //// MÉTODOS PÚBLICOS
  ////

  /**
   * Metodo inicializador del programa.
   *
   * @param args Parametros.
   */
  public static void main(String[] args) {

    SpringApplication.run(SimulatorApplication.class, args);

  }

}