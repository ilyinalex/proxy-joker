package edu.ilin.task.proxyjoker.restconsumers.dtos;

import lombok.Data;

@Data
public class OfficialJokeDTO {
    private int id;
    private String type;
    private String setup;
    private String punchline;
}
