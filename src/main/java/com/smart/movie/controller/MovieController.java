package com.smart.movie.controller;

import com.smart.movie.model.Movie;
import com.smart.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Choudhury Subham on 11-04-2022
 */
@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/api/v1/movie")
public class MovieController {


    @Autowired
    private MovieService movieService;

    @PostMapping("/")
    public String saveMovie(@RequestBody Movie movie){
        log.info("Inside save method");
        return movieService.saveMovie(movie)?"Movie " + movie.getMovieName() + " added successfully":"Movie "+ movie.getMovieName() +"Not added successfully";
    }

    @GetMapping("/")
    public List<Movie> allMovie(){
        log.info("Inside allMovie method");
        return movieService.getAllMovie();
    }

    @GetMapping("{mid}")
    public Movie getMovieByIds(@PathVariable Integer mid){
        log.info("Inside getMovieByIds method");
        return movieService.getMovieById(mid);
    }

    @DeleteMapping("/{mid}")
    public String updateMovieByIdDetails(@PathVariable Integer mid) {
        log.info("Inside updateMovieByIdDetails method");
        return movieService.deleteByID(mid)?"Movie " + mid + " removed successfully":"Movie "+ mid +"Not added successfully";
    }

    @PutMapping("/")
    public String getMovieByIdDetails(@RequestBody Movie movie) {
        log.info("Inside getMovieByIdDetails method");
        return movieService.updateMovie(movie)?"Movie " + movie.getMovieName() + " added successfully":"Movie "+ movie.getMovieName() +"Not added successfully";
    }

}
