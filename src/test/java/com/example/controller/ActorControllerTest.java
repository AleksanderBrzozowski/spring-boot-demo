package com.example.controller;

import com.example.resource.ActorResource;
import com.example.resource.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Aleksander
 */

public class ActorControllerTest extends AbstractControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void whenActorNotNullExpectActor() throws Exception {
        ResponseEntity<ActorResource> response =
                restTemplate.getForEntity("/actors/1", ActorResource.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void whenActorNullExpectException() throws Exception {
        resourceNotFoundAssert("/actors/5");
    }

}


