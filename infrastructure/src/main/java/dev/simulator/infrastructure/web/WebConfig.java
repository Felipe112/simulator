package dev.simulator.infrastructure.web;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuraciones de WebMvc de spring boot.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-30.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  /**
   * Este metodo se encarga de eliminar los convertidores existentes, y luego convertir todo a
   * Jackson.
   *
   * @param converters tipos de convertidores.
   */
  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    converters.clear();
    converters.add(new MappingJackson2HttpMessageConverter());
  }

}
