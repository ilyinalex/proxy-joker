package edu.ilin.task.proxyjoker.controllers;

import edu.ilin.task.proxyjoker.controllers.dtos.JokeDTO;
import edu.ilin.task.proxyjoker.core.JokeService;
import edu.ilin.task.proxyjoker.core.models.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JokeController {

    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/jokes")
    public List<JokeDTO> getJokes(@RequestParam(value = "count", defaultValue = "5") int count) {
        return convertToDTOs(jokeService.getJokes(count));
    }

    private List<JokeDTO> convertToDTOs(List<Joke> jokes) {
        return jokes.stream().map(model -> new JokeDTO(model.getSetup(), model.getPunchline())).collect(Collectors.toList());
    }
}
