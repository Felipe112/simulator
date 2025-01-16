package dev.simulator.infrastructure.config;

import dev.simulator.application.ports.outputs.WireMockRepository;
import dev.simulator.infrastructure.adapters.wiremock.WireMockRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración que facilita la inyección de las dependencias usado por spring boot.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-30.
 */
@Configuration
public class InfrastructureConfig {

  /**
   * Bean de configuración usado por spring boot para respetar la inversión de dependencias.
   *
   * @return Configuraciones.
   */
  @Bean
  public WireMockRepository wireMockRepository() {

    return new WireMockRepositoryImpl();
  }

  /*@Bean
  public DataGeneratorRepository dataGeneratorRepository() {

    return new HuggingFaceRepositoryImpl();
  }*/

}
