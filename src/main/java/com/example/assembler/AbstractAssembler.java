package com.example.assembler;

import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;

/**
 * @author aleksander
 */

abstract class AbstractAssembler<T extends Identifiable, S extends ResourceSupport> implements ResourceAssembler<T, S>{

    @Setter(onMethod = @__(@Autowired))
    private @NonNull RelProvider relProvider;
    @Setter(onMethod = @__(@Autowired))
    private @NonNull EntityLinks entityLinks;

    S createResourceWithId(T entity) {
        final S resource = instantiateResource(entity);
        resource.add(getEntityLink(entity).withSelfRel());
        return resource;
    }

    public abstract Class<S> resourceClass();

    public Link linkToSingleResource(T entity){
        return getEntityLink(entity)
                .withRel(relProvider.getItemResourceRelFor(resourceClass()));
    }

    private Link getEntityLink(T entity) {
        return entityLinks.linkToSingleResource(entity.getClass(), entity.getId());
    }

    public abstract S instantiateResource(T entity);
}
