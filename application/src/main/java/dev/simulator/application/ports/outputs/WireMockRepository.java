package dev.simulator.application.ports.outputs;

import dev.simulator.domain.models.SimulatorModel;

/**
 * Esta inteface define las funcionalidadesd necesarias para crear el simulador de apis.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-18.
 */
public interface WireMockRepository {

  /**
   * Metodo encargado de generar un simulador de un api.
   *
   * @param simulator Datos minimos necesarios.
   *
   * @return URL con el simulador.
   */
  String generate(SimulatorModel simulator);

}
