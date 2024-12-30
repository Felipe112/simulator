package dev.simulator.infrastructure.adapters.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import dev.simulator.application.ports.outputs.WireMockRepository;
import dev.simulator.domain.models.SimulatorModel;
import org.springframework.stereotype.Service;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

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

  private WireMockServer wireMockServer;

  /**
   * Constructor de la clase de configuración que inicializa el servidor WireMock.
   */
  public WireMockRepositoryImpl() {
    // Configuración del servidor WireMock
    this.wireMockServer = new WireMockServer(options().notifier(new ConsoleNotifier(true)));
    this.wireMockServer.start();  // Iniciar el servidor WireMock
    // Configuración de los stubs después de iniciar el servidor
    this.configureStubs();
  }

  /// / / MÉTODOS PÚBLICOS /

  @Override
  public String generate(SimulatorModel simulator) {
    // Simular una solicitud HTTP al servidor WireMock
    int port = wireMockServer.port();
    String response = "http://localhost:"+port+"/api/v1/";

    return response;
  }

  ////
  //// MÉTODOS PRIVADOS
  ////


  private void configureStubs() {
    wireMockServer.stubFor(get(urlEqualTo("/api/v1/users"))
            .willReturn(aResponse().withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody("[{\"id\": 1, \"name\": \"John Doe\"}, {\"id\": 2, \"name\": \"Jane Doe\"}]")));

    wireMockServer.stubFor(post(urlEqualTo("/api/v1/login"))
            .willReturn(aResponse().withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody("{\"token\": \"abc123\"}")));
  }

}
