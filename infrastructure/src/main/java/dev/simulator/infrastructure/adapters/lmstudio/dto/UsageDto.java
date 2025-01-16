package dev.simulator.infrastructure.adapters.lmstudio.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * DTO de uso.
 */
@Data
public class UsageDto implements Serializable {

  private int promptTokens;
  private int completionTokens;
  private int totalTokens;

}
