package dev.simulator.infrascture.adapters.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import dev.simulator.application.ports.outputs.WireMockRepository;
import dev.simulator.domain.models.SimulatorModel;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la libreria generadora de los servidores Mock usados para el simulador.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-18.
 */
@Service
public class WireMockRepositoryImpl implements WireMockRepository {

  ////
  //// DEPENDENCIAS
  ////

  //private WireMockServer wireMockServer;

  /**
   * Constructor de la clase de configuración que inicializa el servidor WireMock.
   */
  public WireMockRepositoryImpl() {
    // Configuración del servidor WireMock
    WireMockServer wireMockServer = new WireMockServer();
    //new WireMockServer(options().port(2345).notifier(new ConsoleNotifier(true)));

    // Inicializar y arrancar el servidor WireMock
    wireMockServer.start();

    // Configuración de los stubs después de iniciar el servidor
    //this.configureStubs();
  }

  /// / / MÉTODOS PÚBLICOS /

  @Override
  public String generate(SimulatorModel simulator) {
    // Simular una solicitud HTTP al servidor WireMock
    String response = "http://localhost:8089/api/v1/";

    return response;
  }

  ////
  //// MÉTODOS PRIVADOS
  ////


  /*private void configureStubs() {
    try {
      // Configuración de los stubs
      wireMockServer.stubFor(get(urlEqualTo("/api/v1/users")).willReturn(
          aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(
              "[{\"id\": 1, \"name\": \"John Doe\"}, {\"id\": 2, \"name\": \"Jane Doe\"}]")));

      wireMockServer.stubFor(post(urlEqualTo("/api/v1/login")).willReturn(
          aResponse().withStatus(200).withHeader("Content-Type", "application/json")
              .withBody("{\"token\": \"abc123\"}")));

      wireMockServer.stubFor(
          put(urlMatching("/api/v1/users/\\d+")).willReturn(aResponse().withStatus(204)));

      wireMockServer.stubFor(
          delete(urlMatching("/api/v1/users/\\d+")).willReturn(aResponse().withStatus(204)));
    } catch (Exception e) {
      e.printStackTrace(); // Captura cualquier excepción para ver más detalles
    }
  }*/

}
