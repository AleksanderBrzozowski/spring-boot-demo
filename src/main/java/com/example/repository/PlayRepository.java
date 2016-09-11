package com.example.repository;

import com.example.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aleksander on 09.09.16.
 */
public interface PlayRepository extends JpaRepository<Play, Integer> {
}
