package com.example.assembler;

import com.example.entity.ActorRole;
import com.example.entity.Film;
import com.example.resource.FilmRoleResource;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aleksander on 12.09.16.
 */

@Component
@NoArgsConstructor
public class FilmRoleAssembler implements ResourcesAssembler<Map<ActorRole, Film>, FilmRoleResource> {

    @Override
    public List<FilmRoleResource> toResources(Map<ActorRole, Film> actorRoleFilmMap) {
        List<FilmRoleResource> actorRoles = new ArrayList<>();
        actorRoleFilmMap.forEach((actorRole, film) ->
                actorRoles.add(new FilmRoleResource(film.getName(), actorRole.getNameInFilm(), actorRole.getRating().getStars())));
        return actorRoles;
    }
}
