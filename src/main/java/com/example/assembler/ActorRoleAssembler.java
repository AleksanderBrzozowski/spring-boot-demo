package com.example.assembler;

import com.example.entity.ActorRole;
import com.example.resource.ActorRoleResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author aleksander
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorRoleAssembler extends AbstractAssembler<ActorRole, ActorRoleResource>{

    private final ActorAssembler actorAssembler;

    @Override
    public Class<ActorRoleResource> resourceClass() {
        return ActorRoleResource.class;
    }

    @Override
    public ActorRoleResource instantiateResource(ActorRole entity) {
        return new ActorRoleResource(entity.getNameInFilm(), entity.getRating().getStars(), entity.getRating().getSumOfVotes(), entity.getPicture());
    }

    @Override
    public ActorRoleResource toResource(ActorRole actorRole) {
        final ActorRoleResource resource = createResourceWithId(actorRole);
        List<Link> links = asList(
                actorAssembler.linkToSingleResource(actorRole.getActor())
        );
        resource.add(links);
        return resource;
    }
}
