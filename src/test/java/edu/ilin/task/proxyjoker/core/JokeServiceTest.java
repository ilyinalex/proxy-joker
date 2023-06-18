package edu.ilin.task.proxyjoker.core;

import edu.ilin.task.proxyjoker.core.dtos.ExternalJokeDTO;
import edu.ilin.task.proxyjoker.core.models.Joke;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
class JokeServiceTest {



    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        @Primary
        public JokeRestConsumer getMockRestConsumer() {
            return () -> new ExternalJokeDTO("a dummy joke walks into a bar", "");
        }
    }

    @Autowired
    private JokeService jokeService;

    @Test
    public void testGetJokes_whenCount6_thenGet6Jokes() {
        List<Joke> jokes = jokeService.getJokes(6);

        assertNotNull(jokes);
        assertEquals(jokes.size(), 6);
    }

    @Test
    public void testGetJokes_whenCount100_thenGet100Jokes() {
        List<Joke> jokes = jokeService.getJokes(100);

        assertNotNull(jokes);
        assertEquals(jokes.size(), 100);
    }
}