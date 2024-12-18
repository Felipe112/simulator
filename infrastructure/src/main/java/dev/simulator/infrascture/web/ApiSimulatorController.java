package dev.simulator.infrascture.web;

import dev.simulator.application.ports.inputs.CreateSimulationUseCaseInput;
import dev.simulator.domain.models.Simulator;
import dev.simulator.infrascture.utils.Constants;
import dev.simulator.infrascture.web.dto.ApiRequest;
import dev.simulator.infrascture.web.dto.GenericResponse;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/simulator")
public class ApiSimulatorController {

  ////
  //// PROPIEDADES
  ////

  private final CreateSimulationUseCaseInput simulatorService;

  ////
  //// MÉTODOS PÚBLICOS
  ////

  @PostMapping("/create")
  public ResponseEntity<GenericResponse<String>> createSimulation(@Valid @RequestBody ApiRequest request) {

   String result =  simulatorService.execute(Simulator.builder().build());

    // Retornar la URL simulada
    String apiUrl = "http://localhost:8081" + request.getPath();
    return new ResponseEntity<>(new GenericResponse<>(Constants.SUCCESS_RESPONSE,result),HttpStatus.CREATED);

  }

}
