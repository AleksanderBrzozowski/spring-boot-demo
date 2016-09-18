package com.example;

import com.example.entity.*;
import com.example.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Locale;

import static java.util.Arrays.asList;

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
    private final PictureRepository pictureRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Actor actor = actorRepository.save(new Actor("Cezary Pazura", LocalDate.of(1962, 6, 13), new Locale("pl", "PL")));
        Film film = filmRepository.save(new Film("Kiler", LocalDate.of(1997, 11, 17), new Locale("pl","PL")));
        Rating rating = ratingRepository.save(new Rating());
        ActorRole actorRole = actorRoleRepository.save(new ActorRole("Jerzy Kiler", rating));
        film.getActors().put(actorRole, actor);

        Actor actor1 = actorRepository.save(new Actor("Jerzy Stuhr", LocalDate.of(1947, 4 ,18), new Locale("pl", "PL")));
        Rating rating1 = ratingRepository.save(new Rating());
        ActorRole actorRole1 = actorRoleRepository.save(new ActorRole("Komisarz Jerzy Ryba", rating1));
        film.getActors().put(actorRole1, actor1);

        Picture picture = new Picture("some url", film);
        picture.getActorsSet().addAll(asList(actor, actor1));
        pictureRepository.save(picture);
    }
}
