package dev.simulator.infrastructure.adapters.lmstudio.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * DTO Respuesta.
 */
@Data
public class ChoiceDto implements Serializable {
  private int index;
  private String text;
  private Object logprobs;
  private String finishReason;
}
