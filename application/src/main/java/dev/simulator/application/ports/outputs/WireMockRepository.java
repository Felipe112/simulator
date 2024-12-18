package dev.simulator.application.ports.outputs;

import dev.simulator.domain.models.Simulator;

public interface WireMockRepository {

  String generate(Simulator simulator);

}
