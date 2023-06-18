package edu.ilin.task.proxyjoker.core.impl;

import edu.ilin.task.proxyjoker.core.JokeRestConsumer;
import edu.ilin.task.proxyjoker.core.dtos.ExternalJokeDTO;
import edu.ilin.task.proxyjoker.core.models.Joke;
import edu.ilin.task.proxyjoker.core.JokeService;
import edu.ilin.task.proxyjoker.restconsumers.dtos.OfficialJokeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class JokeServiceImpl implements JokeService {

    private final JokeRestConsumer consumer;

    @Autowired
    public JokeServiceImpl(JokeRestConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public List<Joke> getJokes(int count) {
        if (count > 100) {
            throw new IllegalArgumentException("U cannot get more than 100 jokes at a time, sorry(.");
        }

        List<Joke> jokes = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<ExternalJokeDTO>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            futures.add(executorService.submit(consumer::getJokeFromAPI));
        }

        for (Future<ExternalJokeDTO> future : futures) {
            try {
                ExternalJokeDTO externalJoke = future.get();

                if (externalJoke != null) {
                    jokes.add(convertToModel(externalJoke));
                }

            } catch (InterruptedException | ExecutionException e) {
                //TODO Add logs/user exception
            }
        }

        executorService.shutdown();

        return jokes;
    }

    private Joke convertToModel(ExternalJokeDTO externalJokeDTO) {
        return new Joke(externalJokeDTO.getSetup(), externalJokeDTO.getPunchline());
    }

}
