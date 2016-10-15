package com.example.tests.web;

import com.example.AbstractControllerTest;
import org.junit.Test;

/**
 * @author Aleksander
 */

public class ActorRoleControllerTest extends AbstractControllerTest {

    @Test
    public void whenActorRoleNotNullExpectHttpOk() throws Exception {
        resourceFound("/roles/1");
    }

    @Test
    public void whenActorRoleNullExpectHttpNotFound() throws Exception {
        resourceNotFound("/roles/7");
    }
}
