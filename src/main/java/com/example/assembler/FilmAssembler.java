package com.example.assembler;

import com.example.controller.FilmController;
import com.example.entity.Film;
import com.example.resource.ActorResource;
import com.example.resource.FilmResource;
import com.example.resource.PictureResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class FilmAssembler  extends AbstractAssembler<Film, FilmResource>{

    private @NonNull final RelProvider relProvider;

    @Override
    public FilmResource instantiateResource(Film entity) {
        return new FilmResource(entity.getName(), entity.getReleaseDate(), entity.getCountry().getDisplayCountry(), entity.getMainPicture());
    }

    @Override
    public FilmResource toResource(Film film) {
        final FilmResource resource = createResourceWithId(film);
        List<Link> links = asList(
                linkTo(methodOn(FilmController.class).pictures(film.getId(), null, null))
                        .withRel(relProvider.getCollectionResourceRelFor(PictureResource.class)),
                linkTo(methodOn(FilmController.class).roles(film.getId(), null, null))
                        .withRel(relProvider.getCollectionResourceRelFor(ActorResource.class))
        );
        resource.add(links);
        return resource;
    }

    @Override
    public Class<FilmResource> resourceClass() {
        return FilmResource.class;
    }
}
