package com.example.repository;

import com.example.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksander
 */
public interface PictureRepository extends JpaRepository<Picture, String> {
}
