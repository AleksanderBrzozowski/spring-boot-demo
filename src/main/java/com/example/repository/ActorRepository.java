package com.example.repository;

import com.example.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by aleksander on 09.09.16.
 */
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
