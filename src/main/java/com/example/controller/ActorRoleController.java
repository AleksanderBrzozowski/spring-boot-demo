package com.example.controller;

import com.example.entity.ActorRole;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aleksander
 */

@RestController
@ExposesResourceFor(ActorRole.class)
public class ActorRoleController {

}
