package com.example.assembler;

import com.example.controller.PictureController;
import com.example.entity.Picture;
import com.example.resource.ActorResource;
import com.example.resource.PictureResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author aleksander
 */

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PictureAssembler extends AbstractAssembler<Picture, PictureResource> {

    private final EntityLinks entityLinks;
    private final RelProvider relProvider;
    private final ActorAssembler actorAssembler;

    @Override
    public Class<PictureResource> resourceClass() {
        return PictureResource.class;
    }

    @Override
    public Link linkToSingleResource(Picture entity) {
        return entityLinks.linkToSingleResource(PictureResource.class, entity.getUrl())
                .withRel(relProvider.getItemResourceRelFor(PictureResource.class));
    }

    @Override
    public PictureResource instantiateResource(Picture entity) {
        return new PictureResource(entity.getUrl());
    }

    @Override
    public PictureResource toResource(Picture entity) {
        final PictureResource resource = createResourceWithId(entity);
        resource.add(linkTo(methodOn(PictureController.class).actors(entity.getUrl()))
                .withRel(relProvider.getCollectionResourceRelFor(ActorResource.class)));
        return resource;
    }
}
