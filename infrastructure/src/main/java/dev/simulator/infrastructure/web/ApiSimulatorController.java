package dev.simulator.infrastructure.web;

import dev.simulator.application.ports.inputs.CreateSimulationUseCaseInput;
import dev.simulator.domain.models.SimulatorModel;
import dev.simulator.infrastructure.utils.Constants;
import dev.simulator.infrastructure.web.dto.ApiRequest;
import dev.simulator.infrastructure.web.dto.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para el ingreso de las peticiones del simulador.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-17.
 */
@RestController
@RequestMapping(value = "/simulator", produces = "application/json", consumes = "application/json")
public class ApiSimulatorController {

  /// / / PROPIEDADES /

  private final CreateSimulationUseCaseInput simulatorService;

  /// / / MÉTODOS PÚBLICOS /

  @Autowired
  public ApiSimulatorController(CreateSimulationUseCaseInput input) {

    this.simulatorService = input;
  }

  /**
   * Metodo encargado de recibir las peticiones mediante un servicio Rest.
   *
   * @param request Datos minimos de la solicitud.
   * @return Resultado del simulador.
   */
  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GenericResponse<String>> createSimulation(@RequestBody ApiRequest request) {

    String result = simulatorService.execute(
            SimulatorModel.builder().path(request.getPaths()).method(request.getMethod())
                .statusCode(request.getStatusCode()).contentType(request.getContentType())
                .body(request.getBody()).build());

    // Retornar la URL simulada
    // String apiUrl = "http://localhost:8081" + request.getPathx();
    return new ResponseEntity<>(new GenericResponse<>(Constants.SUCCESS_RESPONSE, result),
            HttpStatus.OK);

  }

}
