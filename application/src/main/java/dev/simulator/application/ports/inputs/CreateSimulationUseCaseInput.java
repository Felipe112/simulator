package dev.simulator.application.ports.inputs;

import dev.simulator.domain.models.SimulatorModel;

/**
 * Interfaces usada para poder acceder a la logica de negocio del usecase especifico.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-18.
 */
public interface CreateSimulationUseCaseInput {

  /**
   * Metodo encargado de crear un simulador de un api con base en los parametros recibidos.
   *
   * @param request Parametros.
   *
   * @return URL con el api.
   */
  String execute(SimulatorModel request);

}
