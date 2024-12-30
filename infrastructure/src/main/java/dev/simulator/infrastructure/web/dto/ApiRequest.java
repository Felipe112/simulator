package dev.simulator.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO enfocado en capturar los datos necesarios en una petición.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiRequest implements Serializable {

  ////
  //// PROPIEDADES
  ////

  private String paths;

  private String method;

  private int statusCode;

  private String contentType;

  private String body;

}
