package dev.simulator.application.ports.outputs;

import dev.simulator.domain.models.SimulatorModel;

/**
 * Interface encargada de Persistir los datos simuldos.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-18.
 */
public interface SimulatorRepository {

  /**
   * Metodo encargado de guardar los datos del simulador.
   *
   * @param simulator Datos minimos necesarios.
   *
   * @return Modelo de datos.
   */
  SimulatorModel save(SimulatorModel simulator);

}
