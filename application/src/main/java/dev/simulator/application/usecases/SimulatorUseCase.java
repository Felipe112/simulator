package dev.simulator.application.usecases;

import dev.simulator.application.ports.inputs.CreateSimulationUseCaseInput;
import dev.simulator.domain.models.SimulatorModel;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la logíca necesaria en el generador de simuladores.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-18.
 */

@Service
public class SimulatorUseCase implements CreateSimulationUseCaseInput {

  ////
  //// DEPENDENCIAS
  ////



  ////
  //// CONSTRUCTORES
  ////




  ////
  //// MÉTODOS PÚBLICOS
  ////


  @Override
  public String execute(SimulatorModel request) {

    return "response";
  }

}
