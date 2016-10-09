package com.example.controller;

import com.example.resource.ActorResource;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;
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
    public void whenActorNotNullExpectHttpOk() throws Exception {
        resourceFound("/actors/1");
        resourceFound("/actors/1/roles");
        resourceFound("/actors/1/pictures");
    }

    @Test
    public void whenActorNullExpectHttpNotFound() throws Exception {
        resourceNotFound("/actors/5");
        resourceNotFound("/actors/5/roles");
        resourceNotFound("/actors/5/pictures");
    }
}


