package com.example.assembler;

import com.example.entity.Actor;
import com.example.entity.Film;
import com.example.resource.ActorResource;
import com.example.resource.FilmResource;
import com.example.resource.IndexResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Aleksander
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexAssembler {

    private @NonNull final RelProvider relProvider;
    private @NonNull final EntityLinks entityLinks;

    public IndexResource buildIndex() {
        final List<Link> links = asList(
                entityLinks.linkToCollectionResource(Actor.class).withRel(relProvider.getCollectionResourceRelFor(ActorResource.class)),
                entityLinks.linkToCollectionResource(Film.class).withRel(relProvider.getCollectionResourceRelFor(FilmResource.class))
        );
        final IndexResource resource = new IndexResource("Film API", "A simple film api");
        resource.add(links);
        return resource;
    }
}
