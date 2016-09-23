package com.example.assembler;

import com.example.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;

/**
 * @author aleksander
 */
public abstract class MyResourceAssemblerSupport <T, S extends ResourceSupport> implements ResourceAssembler<T, S>{

    @Autowired
    private EntityLinks entityLinks;
    @Autowired
    private RelProvider relProvider;

    public S createResourceWithId(T entity) {
        final S resource = instantiateResource(entity);
        resource.add(linkToSingleResource(entity).withSelfRel());
        return resource;
    }

    public abstract Link linkToSingleResource(T entity);

    public abstract S instantiateResource(T entity);


}
