package dev.simulator.infrastructure.adapters.huggingface;

import java.util.HashMap;
import java.util.Map;
import dev.simulator.application.ports.outputs.DataGeneratorRepository;
import dev.simulator.domain.models.SimulatorModel;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Clase que implementa para integrarnos con hugginface y generar datos mediante los modelos pre entrenados.
 *
 * @author Andrés F. Ceballos.
 * @since 2025-01-08.
 */
@Service
public class HuggingFaceRepositoryImpl implements DataGeneratorRepository {

  String token = "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";
  //String url = "https://api-inference.huggingface.co/models/cardiffnlp/twitter-roberta-base-sentiment-latest";
  //String url = "https://api-inference.huggingface.co/models/openai-community/gpt2";
  String url = "https://api-inference.huggingface.co/models/google/flan-t5-large";

  private final RestTemplate restTemplate;

  public HuggingFaceRepositoryImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public String generate(SimulatorModel simulator) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + token);
    headers.set("Content-Type", "application/json");

    // Crear el body con el texto a enviar
    Map<String, String> body = new HashMap<>();
    body.put("inputs", "Hello create a json structure for a user api with at least 10 records and 15 fields.");
    //body.put("parameters", Map.of("max_length", 300).toString());

    HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

    // Hacer la llamada a Hugging Face
    ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            request,
            String.class
    );

    // Retornar la respuesta
    return response.getBody();
  }

}
