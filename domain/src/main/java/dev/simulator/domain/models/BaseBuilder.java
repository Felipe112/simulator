package dev.simulator.domain.models;

/**
 * Clase general para patron builder.
 *
 * @param <T> Tipo de dato.
 * @param <B> Builder que se esta generando.
 */
public abstract class BaseBuilder<T, B extends BaseBuilder<T, B>> {
  // Método abstracto para construir el objeto final
  protected abstract T buildObject();

  // Método público para construir el objeto
  @SuppressWarnings("unchecked")
  public T build() {
    return buildObject();
  }

  // Devuelve el builder concreto para permitir el encadenamiento de métodos
  @SuppressWarnings("unchecked")
  protected B self() {
    return (B) this;
  }
}