package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Aleksander on 2016-09-10.
 */

@MappedSuperclass
@Getter
@EqualsAndHashCode
public class AbstractEntity<T extends Serializable> implements Identifiable<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final T id;

    protected AbstractEntity() {
        this.id = null;
    }
}
