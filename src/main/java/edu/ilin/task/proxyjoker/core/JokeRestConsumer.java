package edu.ilin.task.proxyjoker.core;

import edu.ilin.task.proxyjoker.core.dtos.ExternalJokeDTO;


public interface JokeRestConsumer {
    ExternalJokeDTO getJokeFromAPI();
}
