package com.example.assembler;

import com.example.controller.PictureController;
import com.example.entity.Picture;
import com.example.resource.ActorResource;
import com.example.resource.FilmResource;
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
 * @author aleksander
 */

@RequiredArgsConstructor
@Service
public class PictureAssembler extends AbstractAssembler<Picture, PictureResource> {

    @NonNull private final RelProvider relProvider;

    @Override
    public Class<PictureResource> resourceClass() {
        return PictureResource.class;
    }

    @Override
    public PictureResource instantiateResource(Picture entity) {
        return new PictureResource(entity.getUrl());
    }

    @Override
    public PictureResource toResource(Picture entity) {
        final PictureResource resource = createResourceWithId(entity);
        List<Link> links = asList(
                linkTo(methodOn(PictureController.class).actors(entity.getUrl(), null, null))
                        .withRel(relProvider.getCollectionResourceRelFor(ActorResource.class)),
                linkTo(methodOn(PictureController.class).film(entity.getUrl()))
                        .withRel(relProvider.getCollectionResourceRelFor(FilmResource.class))
        );
        resource.add(links);
        return resource;
    }
}
