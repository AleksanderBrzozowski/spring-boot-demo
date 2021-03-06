package com.example.assembler;

import com.example.controller.ActorController;
import com.example.entity.Actor;
import com.example.resource.ActorResource;
import com.example.resource.ActorRoleResource;
import com.example.resource.PictureResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ActorAssembler extends AbstractAssembler<Actor, ActorResource> {

    @NonNull private final RelProvider relProvider;

    @Override
    public ActorResource toResource(Actor actor) {
        final ActorResource actorResource = createResourceWithId(actor);
        List<Link> links = asList(
                linkTo(methodOn(ActorController.class).roles(actor.getId(), null, null))
                        .withRel(relProvider.getCollectionResourceRelFor(ActorRoleResource.class)),
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
    public ActorResource instantiateResource(Actor entity) {
        return new ActorResource(entity.getName(), entity.getDateOfBirth(), entity.getCountry().getDisplayCountry(), entity.getMainPicture());
    }
}
