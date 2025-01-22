package dev.simulator.infrastructure.adapters.lmstudio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;

/**
 * DTO Respuesta.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelResponseDto implements Serializable {

  private String id;
  private long created;
  private String model;
  private List<ChoiceDto> choices;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getCreated() {
    return created;
  }

  public void setCreated(long created) {
    this.created = created;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public List<ChoiceDto> getChoices() {
    return choices;
  }

  public void setChoices(List<ChoiceDto> choices) {
    this.choices = choices;
  }
}
