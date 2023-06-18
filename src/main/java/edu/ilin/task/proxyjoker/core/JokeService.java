package edu.ilin.task.proxyjoker.services;

import edu.ilin.task.proxyjoker.models.Joke;

import java.util.List;

public interface JokeService {
    List<Joke> getJokes(int count);
}
