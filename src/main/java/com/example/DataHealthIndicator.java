package com.example;

import com.example.repository.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author Aleksander
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataHealthIndicator implements HealthIndicator {

    private @NonNull final ActorRepository actorRepository;
    private @NonNull final FilmRepository filmRepository;
    private @NonNull final ActorRoleRepository actorRoleRepository;
    private @NonNull final PictureRepository pictureRepository;
    private @NonNull final RatingRepository ratingRepository;

    @Override
    public Health health() {
        return Health.up()
                .withDetail("Actors count", actorRepository.count())
                .withDetail("Films count", filmRepository.count())
                .withDetail("Actor roles count", actorRoleRepository.count())
                .withDetail("Pictures count", pictureRepository.count())
                .withDetail("Ratings count", ratingRepository.count())
                .build();
    }
}
