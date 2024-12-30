package dev.simulator.application.usecases;

import dev.simulator.application.ports.inputs.CreateSimulationUseCaseInput;
import dev.simulator.application.ports.outputs.WireMockRepository;
import dev.simulator.domain.models.SimulatorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

  private final WireMockRepository wireMockRepository;

  ////
  //// CONSTRUCTORES
  ////

  @Autowired
  public SimulatorUseCase(WireMockRepository wireMockRepository) {
    this.wireMockRepository = wireMockRepository;
  }



  ////
  //// MÉTODOS PÚBLICOS
  ////


  @Override
  public String execute(SimulatorModel request) {

    return wireMockRepository.generate(request);
  }

}
