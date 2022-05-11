package com.smart.movie.repository;

import com.smart.movie.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Choudhury Subham on 11-04-2022
 */
@Repository
public interface MovieRepository extends JpaRepository<MovieEntity , Serializable> {
}
