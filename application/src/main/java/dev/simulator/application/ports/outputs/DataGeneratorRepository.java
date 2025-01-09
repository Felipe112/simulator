package dev.simulator.application.ports.outputs;

import dev.simulator.domain.models.SimulatorModel;

/**
 * Esta inteface define las funcionalidadesd necesarias para el generador de datos.
 *
 * @author Andrés F. Ceballos.
 * @since 2025-01-08.
 */
public interface DataGeneratorRepository {

  /**
   * Metodo encargado de generar datos para apis.
   *
   * @param simulator Datos base.
   * @return Datos generados.
   */
  String generate(SimulatorModel simulator);

}
