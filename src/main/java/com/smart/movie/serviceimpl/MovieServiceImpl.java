package com.smart.movie.serviceimpl;

import com.smart.movie.entity.MovieEntity;
import com.smart.movie.exception.MovieNotFoundException;
import com.smart.movie.model.Movie;
import com.smart.movie.repository.MovieRepository;
import com.smart.movie.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Choudhury Subham on 11-04-2022
 */

@Service
public class MovieServiceImpl implements MovieService {

   //field injection
    @Autowired
    private  MovieRepository movieRepository;

    @Override
    public boolean saveMovie(Movie movie) {
        MovieEntity movieEntity = new MovieEntity();
        BeanUtils.copyProperties(movie,movieEntity);
        MovieEntity saveMovie =movieRepository.save(movieEntity);
        return saveMovie.getMovieId()!=null;
    }

    @Override
    public List<Movie> getAllMovie() {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        return movieEntities.stream().map(movieEntity -> {
            Movie movie = new Movie();
            BeanUtils.copyProperties(movieEntity,movie);
            return movie;
        }).collect(Collectors.toList());
    }

    @Override
    public Movie getMovieById(Integer mid) {
        Optional<MovieEntity> movieEntity = Optional.ofNullable(movieRepository.findById(mid).orElseThrow(
                () -> new MovieNotFoundException("Movie" + mid + "Not found")));
        if(movieEntity.isPresent()){
            MovieEntity entity = movieEntity.get();
            Movie movie = new Movie();
            BeanUtils.copyProperties(entity,movie);
            return movie;
        }
        return null;
    }

    @Override
    public boolean deleteByID(Integer mid) {
        movieRepository.deleteById(mid);
        return true;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        return saveMovie(movie);
    }

}
