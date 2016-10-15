package com.example.configuration;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author Aleksander
 */

@Configuration
@RequiredArgsConstructor
public class HalConfiguration implements ApplicationListener<ContextRefreshedEvent>{

    @NonNull private final MappingJackson2HttpMessageConverter converter;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        converter.getObjectMapper().registerModule(new Jackson2HalModule());
    }
}
