package com.example;

import com.example.repository.ActorRepository;
import com.example.repository.FilmRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author Aleksander
 */

@Component
public class DataHealthIndicator implements HealthIndicator {

    private @NonNull final ActorRepository actorRepository;
    private @NonNull final FilmRepository filmRepository;

    @Autowired
    public DataHealthIndicator(ActorRepository actorRepository, FilmRepository filmRepository) {
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public Health health() {
        return Health.up()
                .withDetail("Actors count", actorRepository.count())
                .withDetail("Films count", filmRepository.count())
                .build();
    }
}
