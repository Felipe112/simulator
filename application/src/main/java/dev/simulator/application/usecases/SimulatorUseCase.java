package dev.simulator.application.usecases;

import dev.simulator.application.ports.inputs.CreateSimulationUseCaseInput;
import dev.simulator.application.ports.outputs.WireMockRepository;
import dev.simulator.domain.models.SimulatorModel;
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

  /// /
  /// / DEPENDENCIAS
  /// /

  private final WireMockRepository wireMockRepository;

  /// /
  /// / CONSTRUCTORES
  /// /

  @Autowired
  public SimulatorUseCase(WireMockRepository wireMockRepository) {
    this.wireMockRepository = wireMockRepository;
  }


  /// /
  /// / MÉTODOS PÚBLICOS
  /// /


  @Override
  public String execute(SimulatorModel request) {

    if (null == request) {
      request = new SimulatorModel();
    }

    return wireMockRepository.generate(request);
  }

  //TODO
  //1. Validar que todos los paths inicien con un /, de lo contrario adicionarlo.
  //2. Validar que los metodos correspondan a los permitidos (GET,POST, PUT, DELETE)
  //3. En caso de que no especifiquen el metodo se crearan todos los metodos, de lo contario el especifico.
  //4. Definir la libreria y apis para generar los datos con IA, esto sera antes de invocar el servicio de MOCK.
  //5. Integrarnos con Hugging Face (Esto puede cambiar por un modelo generativo propio o administrado propiamente)
  

}
