package edu.ilin.task.proxyjoker.core.models;


import lombok.AllArgsConstructor;
import lombok.Data;

//Internal joke model
@Data
@AllArgsConstructor
public class Joke {
    private String setup;
    private String punchline;
}
