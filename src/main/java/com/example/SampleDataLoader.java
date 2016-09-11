package com.example;

import com.example.entity.Actor;
import com.example.entity.Film;
import com.example.repository.ActorRepository;
import com.example.repository.FilmRepository;
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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Actor actor = actorRepository.save(new Actor("Olekk"));
        Film film = filmRepository.save(new Film("Kiler1"));
        film.getActors().add(actor);
        filmRepository.save(film);
    }
}
