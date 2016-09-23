package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.core.DefaultRelProvider;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

/**
 * @author Aleksander
 */

//@Configuration
public class RestConfiguration extends AbstractJackson2HttpMessageConverter {

    public RestConfiguration() {
        super(new ObjectMapper(), new MediaType("application", "hal+json", DEFAULT_CHARSET));
        objectMapper.registerModule(new Jackson2HalModule());
        objectMapper.setHandlerInstantiator(new Jackson2HalModule.HalHandlerInstantiator(new DefaultRelProvider(), null, null));
        // customize your mapper if needed
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return ResourceSupport.class.isAssignableFrom(clazz);
    }
}
