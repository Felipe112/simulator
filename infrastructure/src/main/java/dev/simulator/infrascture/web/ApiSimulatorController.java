package dev.simulator.infrascture.web;

import dev.simulator.application.ports.inputs.CreateSimulationUseCaseInput;
import dev.simulator.infrascture.utils.Constants;
import dev.simulator.infrascture.web.dto.ApiRequest;
import dev.simulator.infrascture.web.dto.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/simulator")
public class ApiSimulatorController {

  ////
  //// PROPIEDADES
  ////

  @Autowired
  private CreateSimulationUseCaseInput simulatorService;

  ////
  //// MÉTODOS PÚBLICOS
  ////

  /**
   * Metodo encargado de recibir las peticiones mediante un servicio Rest.
   *
   * @param request Datos minimos de la solicitud.
   *
   * @return Resultado del simulador.
   */
  @PostMapping("/create")
  public ResponseEntity<GenericResponse<String>> createSimulation(@RequestBody ApiRequest request) {

    String result = simulatorService.execute(null);

    // Retornar la URL simulada
    // String apiUrl = "http://localhost:8081" + request.getPathx();
    return new ResponseEntity<>(new GenericResponse<>(Constants.SUCCESS_RESPONSE, result),
        HttpStatus.CREATED);

  }

}
