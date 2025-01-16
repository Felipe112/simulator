package dev.simulator.infrastructure.adapters.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.common.ContentTypes;
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

  /// /
  /// / PROPIEDADES
  /// /
  private static final String PATH_DEFAULT = "/api/v1/users";
  private static final String BODY_DEFAULT = "[{\"id\": 1, \"name\": \"John Doe\"}, {\"id\": 2, \"name\": \"Jane Doe\"}]";
  private static final int STATUS_DEFAULT = 200;


  /// /
  /// / DEPENDENCIAS
  /// /

  private final WireMockServer wireMockServer;

  /**
   * Constructor de la clase que inicializa el servidor WireMock.
   */
  public WireMockRepositoryImpl() {
    this.wireMockServer = new WireMockServer(options().port(0).notifier(new ConsoleNotifier(true)));
    this.wireMockServer.start();
  }

  /// / / MÉTODOS PÚBLICOS /

  @Override
  public String generate(SimulatorModel simulator) {

    this.configureStubs(simulator);

    int port = wireMockServer.port();

    String response = wireMockServer.baseUrl() + (simulator.getPath() == null || simulator.getPath().isBlank() ? PATH_DEFAULT :
            simulator.getPath());


    return response;
  }

  /// /
  /// / MÉTODOS PRIVADOS
  /// /

  /**
   * Metodo encargado de configurar los parametros recibidos o de definir los que hagan falta.
   *
   * @param simulator parametros.
   */
  private void configureStubs(SimulatorModel simulator) {

    wireMockServer.stubFor(
            get(urlEqualTo(simulator.getPath() == null || simulator.getPath().isBlank() ? PATH_DEFAULT : simulator.getPath()))
                    .willReturn(aResponse().withStatus(simulator.getStatusCode() <= 0 ? STATUS_DEFAULT : simulator.getStatusCode())
                            .withHeader(ContentTypes.CONTENT_TYPE, ContentTypes.APPLICATION_JSON)
                            .withBody(simulator.getBody() == null || simulator.getBody().isBlank() ? BODY_DEFAULT : simulator.getBody())));

  }

}
