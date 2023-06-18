package edu.ilin.task.proxyjoker.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExternalJokeDTO {
    private String setup;
    private String punchline;
}
