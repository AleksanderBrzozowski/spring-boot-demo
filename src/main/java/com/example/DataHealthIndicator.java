package com.example;

import com.example.repository.ActorRepository;
import com.example.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author Aleksander
 */

@Component
public class DataHealthIndicator implements HealthIndicator {

    private final ActorRepository actorRepository;
    private final PlayRepository playRepository;

    @Autowired
    public DataHealthIndicator(ActorRepository actorRepository, PlayRepository playRepository) {
        this.actorRepository = actorRepository;
        this.playRepository = playRepository;
    }

    @Override
    public Health health() {
        return Health.up()
                .withDetail("Actors count", actorRepository.count())
                .withDetail("Plays count", playRepository.count())
                .build();
    }
}
