package com.example.controller;

import com.example.assembler.ActorRoleAssembler;
import com.example.entity.ActorRole;
import com.example.repository.ActorRoleRepository;
import com.example.resource.ActorRoleResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aleksander
 */

@RestController
@RequestMapping(value = "/roles")
@ExposesResourceFor(ActorRole.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorRoleController {

    @NonNull private final ActorRoleAssembler actorRoleAssembler;
    @NonNull private final ActorRoleRepository actorRoleRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ActorRoleResource actorRole(@PathVariable int id) {
        final ActorRole actorRole = actorRoleRepository.findOne(id);
        return actorRoleAssembler.toResource(actorRole);
    }
}
