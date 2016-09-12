package com.example.assembler;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by aleksander on 12.09.16.
 */
public interface ResourcesAssembler<T, D extends ResourceSupport>{
    List<D> toResources(T entities);
}
