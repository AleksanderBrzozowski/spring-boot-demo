package com.example.repository;

import com.example.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksander
 */
public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
