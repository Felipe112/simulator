package dev.simulator.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase general para dar un estandar de respuestas con el mismo formato.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse<T extends Serializable> implements Serializable {

  ////
  //// PROPIEDADES
  ////
  private String message;

  @JsonFormat(pattern = "yyyy-MM-dd")
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
