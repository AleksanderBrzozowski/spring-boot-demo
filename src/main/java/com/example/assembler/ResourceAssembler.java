package com.example.assembler;

import com.example.entity.ActorRole;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by aleksander on 14.09.16.
 */
public interface ResourceAssembler<T, S, D extends ResourceSupport> {
    D toResource(T entity1, S entity2);
}
