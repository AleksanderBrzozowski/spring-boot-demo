package com.example.assembler;

import com.example.entity.ActorRole;
import com.example.entity.Film;
import com.example.resource.ActorRoleResource;
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
public class ActorRolesAssembler implements ResourcesAssembler<Map<ActorRole, Film>, ActorRoleResource> {

    @Override
    public List<ActorRoleResource> toResources(Map<ActorRole, Film> actorRoleFilmMap) {
        List<ActorRoleResource> actorRoles = new ArrayList<>();
        actorRoleFilmMap.forEach((actorRole, film) ->
                actorRoles.add(new ActorRoleResource(film.getName(), actorRole.getNameInFilm(), actorRole.getRating().getStars())));
        return actorRoles;
    }
}
