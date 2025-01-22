package dev.simulator.domain.models;

/**
 * Clase modelo para los datos base del simulador.
 *
 * @author Andrés F. Ceballos.
 * @since 2024-12-18.
 */
public class SimulatorModel {

  private String path;

  private String method;

  private int statusCode;

  private String body;

  /**
   * Constructor.
   */
  public SimulatorModel() {
  }

  /**
   * Constructor para builder.
   *
   * @param builder Objecto.
   */
  private SimulatorModel(Builder builder) {
    this.path = builder.path;
    this.method = builder.method;
    this.statusCode = builder.statusCode;
    this.body = builder.body;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
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

  /**
   * Clase builder.
   */
  public static class Builder extends BaseBuilder<SimulatorModel, Builder> {
    private String path;

    private String method;

    private int statusCode;

    private String body;

    public Builder path(String path) {
      this.path = path;
      return self();
    }

    public Builder method(String method) {
      this.method = method;
      return self();
    }

    public Builder statusCode(int statusCode) {
      this.statusCode = statusCode;
      return self();
    }

    public Builder body(String body) {
      this.body = body;
      return self();
    }

    @Override
    protected SimulatorModel buildObject() {
      return new SimulatorModel(this);
    }
  }
}
