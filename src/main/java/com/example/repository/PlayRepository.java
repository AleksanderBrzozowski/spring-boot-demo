package com.example.repository;

import com.example.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksander
 */
public interface PlayRepository extends JpaRepository<Play, Integer> {
}
