package com.example.configuration;

import com.example.entity.*;
import com.example.repository.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Locale;

import static java.util.Arrays.asList;

/**
 * @author Aleksander
 */

@Configuration
@RequiredArgsConstructor
@Profile("test")
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent>{

    @NonNull private final ActorRepository actorRepository;
    @NonNull private final FilmRepository filmRepository;
    @NonNull private final ActorRoleRepository actorRoleRepository;
    @NonNull private final RatingRepository ratingRepository;
    @NonNull private final PictureRepository pictureRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Actor actor = actorRepository.save(new Actor("Aktor1", LocalDate.of(1962, 6, 13), new Locale("pl", "PL"), "a0-pic"));
        Film film = filmRepository.save(new Film("Film1", LocalDate.of(1997, 11, 17), new Locale("pl","PL"), "mainPic"));
        Rating rating = ratingRepository.save(new Rating());
        actorRoleRepository.save(new ActorRole("AktoRole", "role-pic-url", rating, film, actor));

        Actor actor1 = actorRepository.save(new Actor("Aktor2", LocalDate.of(1947, 4 ,18), new Locale("pl", "PL"), "a1-pic"));
        Rating rating1 = ratingRepository.save(new Rating());
        actorRoleRepository.save(new ActorRole("Role2", "role1-pic-url", rating1, film, actor1));

        Picture picture = new Picture("pic", film);
        picture.getActorsSet().addAll(asList(actor, actor1));
        pictureRepository.save(picture);
    }
}
