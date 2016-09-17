package com.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;


/**
 * @author Aleksander
 */

@Configuration
public class DateConfiguration {

    private static final DateTimeFormatter DATE_FORMATTER = ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = ofPattern("HH-MM");

    @Bean
    @Primary
    public ObjectMapper dateObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(timeModule);
        return objectMapper;
    }

    public class LocalDateSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(localDate.format(DATE_FORMATTER));
        }
    }

    public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return LocalDate.parse(jsonParser.getValueAsString(), DATE_FORMATTER);
        }
    }



}
