package edu.ilin.task.proxyjoker.restconsumers;

import edu.ilin.task.proxyjoker.core.JokeRestConsumer;
import edu.ilin.task.proxyjoker.core.dtos.ExternalJokeDTO;
import edu.ilin.task.proxyjoker.restconsumers.dtos.OfficialJokeDTO;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OfficialRandomJokeRestConsumer implements JokeRestConsumer {


    private static final String JOKE_API_URL = "https://official-joke-api.appspot.com/random_joke" ;
    @Override
    public ExternalJokeDTO getJokeFromAPI() {
        RestTemplate restTemplate = new RestTemplate();

        OfficialJokeDTO joke = restTemplate.getForObject(JOKE_API_URL, OfficialJokeDTO.class);

        //TODO need to handle nulls
        if (joke == null) {
            return null;
        }

        return convertToExternalDTO(joke);
    }


    //TODO need to add converters
    private ExternalJokeDTO convertToExternalDTO(OfficialJokeDTO officialJokeDTO) {
        return new ExternalJokeDTO(officialJokeDTO.getSetup(), officialJokeDTO.getPunchline());
    }
}
