package com.smart.movie.service;

import com.smart.movie.entity.MovieEntity;
import com.smart.movie.model.Movie;

import java.util.List;

/**
 * @author Choudhury Subham on 11-04-2022
 */
public interface MovieService {

       boolean saveMovie(Movie movie);
       List<Movie> getAllMovie();
       Movie getMovieById(Integer mid);
       boolean deleteByID(Integer mid);
       boolean updateMovie(Movie movie);


}
