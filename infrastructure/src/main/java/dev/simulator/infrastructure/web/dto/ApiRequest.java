package dev.simulator.infrastructure.web.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO enfocado en capturar los datos necesarios en una petición.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiRequest implements Serializable {

  /// /
  /// / PROPIEDADES
  /// /

  private String paths;

  private String method;

  private int statusCode;

  private String body;

  public String getPaths() {
    return paths;
  }

  public void setPaths(String paths) {
    this.paths = paths;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}


