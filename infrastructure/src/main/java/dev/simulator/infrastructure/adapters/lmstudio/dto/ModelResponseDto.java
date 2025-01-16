package dev.simulator.infrastructure.adapters.lmstudio.dto;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * DTO Respuesta.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelResponseDto implements Serializable {

  private String id;
  private String object;
  private long created;
  private String model;
  private List<ChoiceDto> choices;

}
