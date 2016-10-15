package com.example.tests.web;

import com.example.AbstractControllerTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Aleksander
 */

public class ActorControllerTest extends AbstractControllerTest {

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


