package dev.simulator.application.usecases;

import dev.simulator.application.ports.inputs.CreateSimulationUseCaseInput;
import dev.simulator.application.ports.outputs.SimulatorRepository;
import dev.simulator.domain.models.Simulator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SimulatorUseCase implements CreateSimulationUseCaseInput {

  ////
  //// DEPENDENCIAS
  ////

  private final SimulatorRepository repository;


  ////
  //// MÉTODOS PÚBLICOS
  ////

  /**
   * Metodo encargado de crear un simulador de un api con base en los parametros recibidos.
   * @param request Parametros.
   * @return URL con el api.
   */
  @Override
  public String execute(Simulator request) {

    String apiUrl = "http://localhost:8081" + request.getPath();

    String response = repository.generate(request);

    return apiUrl;
  }

}
