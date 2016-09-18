package com.example.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


/**
 * @author Aleksander
 */

@MappedSuperclass
@Getter
@EqualsAndHashCode
public class AbstractEntity<T extends Serializable> implements Identifiable<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final T id;

    protected AbstractEntity() {
        this.id = null;
    }
}
