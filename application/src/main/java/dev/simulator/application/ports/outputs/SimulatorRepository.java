package dev.simulator.application.ports.outputs;

import dev.simulator.domain.models.Simulator;

public interface SimulatorRepository {

  Simulator save (Simulator simulator);

}
