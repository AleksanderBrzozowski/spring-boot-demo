package com.example.assembler;

import com.example.resource.ActorResource;
import com.example.resource.IndexResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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

    private final RelProvider relProvider;
    private final EntityLinks entityLinks;

    public IndexResource buildIndex() {
        final List<Link> links = asList(
                entityLinks.linkToCollectionResource(ActorResource.class).withRel(relProvider.getCollectionResourceRelFor(ActorResource.class))
        );
        final IndexResource resource = new IndexResource("Film API", "A simple film api");
        resource.add(links);
        return resource;
    }
}
