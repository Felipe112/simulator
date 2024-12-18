package dev.simulator.infrascture.web.dto;

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
public class ApiRequest {

  ////
  //// PROPIEDADES
  ////

  private String path;

  private String method;

  private int statusCode;

  private String contentType;

  private String body;

}
