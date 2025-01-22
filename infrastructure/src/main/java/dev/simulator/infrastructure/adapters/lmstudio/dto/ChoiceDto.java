package dev.simulator.infrastructure.adapters.lmstudio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * DTO Respuesta.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoiceDto implements Serializable {

  private int index;
  private String text;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
