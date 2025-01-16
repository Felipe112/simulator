package dev.simulator.infrastructure.adapters.lmstudio;

import dev.simulator.application.ports.outputs.DataGeneratorRepository;
import dev.simulator.domain.models.SimulatorModel;
import dev.simulator.infrastructure.adapters.lmstudio.dto.ModelResponseDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Clase que implementa para integrarnos con hugginface y generar datos mediante los modelos pre entrenados.
 *
 * @author Andrés F. Ceballos.
 * @since 2025-01-08.
 */
@Service
public class LlamaRepositoryImpl implements DataGeneratorRepository {

  String url = "http://127.0.0.1:1234/v1/completions";

  private final WebClient webClient;

  /**
   * Constructor.
   */
  public LlamaRepositoryImpl() {
    this.webClient = WebClient.builder()
            .baseUrl(url)
            .build();
  }

  @Override
  public String generate(SimulatorModel simulator) {
    HttpHeaders headers = new HttpHeaders();
    //headers.set("Authorization", "Bearer " + token);
    headers.set("Content-Type", "application/json");

    // Crear el body con el texto a enviar
    Map<String, String> body = new HashMap<>();
    body.put("model", "llama-3.2-3b-instruct");
    body.put("prompt", "Generate a JSON array with 10 objects. Each object should represent a user with the following 15 fields: "
            + "id, name, email, phone, address, city, state, zip, country, created_at, updated_at, status, role, last_login, and "
            + "is_verified. Ensure the JSON is valid and properly formatted.");
    body.put("max_tokens", "1000");
    body.put("temperature", "0.7");

    Mono<ModelResponseDto> responseMono = webClient.post()
            .headers(httpHeaders -> httpHeaders.addAll(headers)) // Añadir encabezados
            .bodyValue(body) // Añadir el cuerpo
            .retrieve() // Enviar la solicitud y manejar la respuesta
            .bodyToMono(ModelResponseDto.class);

    // Procesar la respuesta
    ModelResponseDto responseDto = responseMono.block(); // Bloqueo para obtener la respuesta de forma sincrónica
    if (responseDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
      throw new RuntimeException("El cuerpo de la respuesta es nulo o no contiene datos.");
    }

    // Retornar la respuesta
    return responseDto.getChoices().get(0).getText();
  }

}
