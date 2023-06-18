package edu.ilin.task.proxyjoker.restconsumers;

import edu.ilin.task.proxyjoker.core.RestConsumer;
import edu.ilin.task.proxyjoker.core.dtos.ExternalJokeDTO;
import edu.ilin.task.proxyjoker.core.models.Joke;
import edu.ilin.task.proxyjoker.restconsumers.dtos.OfficialJokeDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.springframework.web.client.RestTemplate;

public class OfficialRandomRestConsumer implements RestConsumer {


    private static final String JOKE_API_URL = "https://official-joke-api.appspot.com/random_joke" ;
    @Override
    public List<Joke> getJokesFromAPI(int count) {
        RestTemplate restTemplate = new RestTemplate();

        OfficialJokeDTO user = restTemplate.getForObject(JOKE_API_URL, OfficialJokeDTO.class);

        return null;
    }


    private ExternalJokeDTO convertToExternalDTOs(OfficialJokeDTO officialJokeDTO) {
        return new ExternalJokeDTO(officialJokeDTO.getSetup(), officialJokeDTO.getPunchline());
    }
}
