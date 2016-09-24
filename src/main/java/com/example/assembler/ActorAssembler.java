package com.example.assembler;

import com.example.controller.ActorController;
import com.example.entity.Actor;
import com.example.resource.ActorResource;
import com.example.resource.FilmRoleResource;
import com.example.resource.PictureResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Aleksander
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorAssembler extends AbstractAssembler<Actor, ActorResource> {

    private final RelProvider relProvider;
    private final EntityLinks entityLinks;

    @Override
    public ActorResource toResource(Actor actor) {
        final ActorResource actorResource = createResourceWithId(actor);
        List<Link> links = asList(
                linkTo(methodOn(ActorController.class).filmography(actor.getId()))
                        .withRel(relProvider.getCollectionResourceRelFor(FilmRoleResource.class)),
                linkTo(methodOn(ActorController.class).pictures(actor.getId(), null, null))
                        .withRel(relProvider.getCollectionResourceRelFor(PictureResource.class))
        );
        actorResource.add(links);
        return actorResource;
    }

    @Override
    public Class<ActorResource> resourceClass() {
        return ActorResource.class;
    }

    @Override
    public Link linkToSingleResource(Actor entity) {
        return entityLinks.linkToSingleResource(ActorResource.class, entity.getId())
                .withRel(relProvider.getItemResourceRelFor(ActorResource.class));
    }

    @Override
    public ActorResource instantiateResource(Actor entity) {
        return new ActorResource(entity.getName(), entity.getDateOfBirth(), entity.getCountry().getDisplayCountry(), entity.getMainPicture());
    }
}
