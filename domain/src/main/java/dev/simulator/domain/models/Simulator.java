package dev.simulator.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Simulator {

  private String path;

  private String method;

  private int statusCode;

  private String contentType;

  private String body;

}
