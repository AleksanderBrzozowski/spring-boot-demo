package com.example.assembler;

import com.example.controller.ActorController;
import com.example.entity.Actor;
import com.example.resource.ActorResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 * Created by Aleksander on 2016-09-10.
 */

@Service
public class ActorAssembler extends ResourceAssemblerSupport<Actor, ActorResource> {

    public ActorAssembler() {
        super(ActorController.class, ActorResource.class);
    }

    @Override
    public ActorResource toResource(Actor actor) {
        final ActorResource actorResource = createResourceWithId(actor.getId(), actor);
        return actorResource;
    }

    @Override
    protected ActorResource instantiateResource(Actor entity) {
        return new ActorResource(entity.getName());
    }
}
