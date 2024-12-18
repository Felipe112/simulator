package dev.simulator.infrascture.adapters.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import dev.simulator.application.ports.outputs.WireMockRepository;
import dev.simulator.domain.models.Simulator;

public class WireMockService implements WireMockRepository {

  private final WireMockServer wireMockServer;

  public WireMockService(){
    wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8089));
    wireMockServer.start();
    WireMock.configureFor("localhost", 8089);
  }

  @Override
  public String generate(Simulator simulator) {
    // Configurar un stub para la ruta /external-api/data
    stubFor(get(urlEqualTo("/external-api/data"))
        .willReturn(aResponse()
            .withHeader("Content-Type", "application/json")
            .withStatus(200)
            .withBody("{ \"message\": \"Mocked response\" }")));

    // Simular una solicitud HTTP al servidor WireMock
    String response = callExternalApi("http://localhost:8089/external-api/data");

    return "";
  }

}
