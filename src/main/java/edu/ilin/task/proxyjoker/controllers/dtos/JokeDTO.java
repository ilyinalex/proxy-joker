package edu.ilin.task.proxyjoker.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

//Internal return joke dto
@Data
@AllArgsConstructor
public class JokeDTO {
    private String setup;
    private String punchline;
}
