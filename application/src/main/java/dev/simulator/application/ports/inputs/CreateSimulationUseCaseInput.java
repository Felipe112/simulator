package dev.simulator.application.ports.inputs;

import dev.simulator.domain.models.Simulator;

public interface CreateSimulationUseCaseInput {

  String execute(Simulator request);

}
