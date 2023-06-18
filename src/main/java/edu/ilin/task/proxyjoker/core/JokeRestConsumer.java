package edu.ilin.task.proxyjoker.core;

import edu.ilin.task.proxyjoker.core.models.Joke;

import java.util.List;

public interface RestConsumer {
    List<Joke> getJokesFromAPI(int count);
}
