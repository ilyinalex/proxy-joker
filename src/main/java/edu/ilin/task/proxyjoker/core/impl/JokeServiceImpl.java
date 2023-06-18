package edu.ilin.task.proxyjoker.services.impl;

import edu.ilin.task.proxyjoker.models.Joke;
import edu.ilin.task.proxyjoker.services.JokeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeServiceImpl implements JokeService {
    @Override
    public List<Joke> getJokes(int count) {
        return null;
    }

}
