package dev.simulator.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase modelo para los datos base del simulador.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-18.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulatorModel {

  private String path;

  private String method;

  private int statusCode;

  private String contentType;

  private String body;

}
