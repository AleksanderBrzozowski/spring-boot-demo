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

import java.time.LocalDate;

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
        Actor actor = actorRepository.save(new Actor("Cezary Pazura", LocalDate.of(1962, 6, 13)));
        Film film = filmRepository.save(new Film("Kiler"));
        Rating rating = ratingRepository.save(new Rating());
        ActorRole actorRole = actorRoleRepository.save(new ActorRole("Jerzy Kiler", rating));
        film.getActors().put(actorRole, actor);

        Actor actor1 = actorRepository.save(new Actor("Jerzy Stuhr", LocalDate.of(1947, 4 ,18)));
        Rating rating1 = ratingRepository.save(new Rating());
        ActorRole actorRole1 = actorRoleRepository.save(new ActorRole("Komisarz Jerzy Ryba", rating1));
        film.getActors().put(actorRole1, actor1);
        filmRepository.save(film);
    }
}
