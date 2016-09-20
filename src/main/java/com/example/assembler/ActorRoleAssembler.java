package com.example.assembler;

import com.example.controller.ActorController;
import com.example.controller.FilmController;
import com.example.entity.Actor;
import com.example.entity.ActorRole;
import com.example.entity.Film;
import com.example.resource.ActorResource;
import com.example.resource.FilmResource;
import com.example.resource.FilmRoleResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author aleksander
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorRoleAssembler {

    private final RelProvider relProvider;

    public FilmRoleResource toResource(ActorRole role, Film film, Actor actor) {
        final FilmRoleResource resource = new FilmRoleResource(film.getName(), role.getNameInFilm(), role.getRating().getStars(), actor.getName());
        resource.add(linkTo(methodOn(FilmController.class).film(film.getId()))
                .withRel(relProvider.getItemResourceRelFor(FilmResource.class)));
        resource.add(linkTo(methodOn(ActorController.class).actor(actor.getId()))
                .withRel(relProvider.getItemResourceRelFor(ActorResource.class)));
        return resource;
    }
}