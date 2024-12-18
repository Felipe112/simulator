package dev.simulator.infrascture.web.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase general para dar un estandar de respuestas con el mismo formato.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-17.
 */
@Data
@NoArgsConstructor
public class GenericResponse<T extends Serializable> implements Serializable {

  ////
  //// PROPIEDADES
  ////
  private String message;

  private LocalDate date;

  private T result;

  ////
  //// CONSTRUCTORES
  ////
  /**
   * Constructor de mensaje.
   *
   * @param message Mensaje de respuesta.
   */
  public GenericResponse(String message) {

    this.message = message;
    this.date = LocalDate.now();
    this.result = null;
  }

  /**
   * Constructor de mensaje y resultados.
   *
   * @param message Mensaje.
   * @param result Resultado.
   */
  public GenericResponse(String message, T result) {

    this.message = message;
    this.date = LocalDate.now();
    this.result = result;
  }

}
