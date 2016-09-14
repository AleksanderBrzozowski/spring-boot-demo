package com.example.assembler;

import com.example.controller.ActorController;
import com.example.entity.Actor;
import com.example.resource.ActorResource;
import com.example.resource.FilmRoleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Aleksander
 */
@Service
public class ActorAssembler extends ResourceAssemblerSupport<Actor, ActorResource> {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RelProvider relProvider;

    public ActorAssembler() {
        super(ActorController.class, ActorResource.class);
    }

    @Override
    public ActorResource toResource(Actor actor) {
        final ActorResource actorResource = createResourceWithId(actor.getId(), actor);
        List<Link> links = asList(
                linkTo(methodOn(ActorController.class).filmography(actor.getId()))
                        .withRel(relProvider.getCollectionResourceRelFor(FilmRoleResource.class))
        );
        actorResource.add(links);
        return actorResource;
    }

    @Override
    protected ActorResource instantiateResource(Actor entity) {
        return new ActorResource(entity.getName());
    }
}
