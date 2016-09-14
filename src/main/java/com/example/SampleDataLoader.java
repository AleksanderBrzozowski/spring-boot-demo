package com.example;

import com.example.entity.Actor;
import com.example.entity.ActorRole;
import com.example.entity.Film;
import com.example.entity.Rating;
import com.example.repository.ActorRepository;
import com.example.repository.ActorRoleRepository;
import com.example.repository.FilmRepository;
import com.example.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Aleksander
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent>{

    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;
    private final ActorRoleRepository actorRoleRepository;
    private final RatingRepository ratingRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Actor actor = actorRepository.save(new Actor("Cezary Pazura"));
        Film film = filmRepository.save(new Film("Kiler"));
        Rating rating = ratingRepository.save(new Rating());
        ActorRole actorRole = new ActorRole("Jerzy Kiler", rating);
        actorRole = actorRoleRepository.save(actorRole);
        film.getActors().put(actorRole, actor);
        filmRepository.save(film);
    }
}
