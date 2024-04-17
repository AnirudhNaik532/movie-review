package com.moviereview.controller;

import com.moviereview.dto.MovieDto;
import com.moviereview.entity.Movie;
import com.moviereview.service.MovieService;
import com.moviereview.utils.Constants;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping(Constants.Routes.API_MOVIES)
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return new ResponseEntity<List<MovieDto>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping(Constants.Routes.API_MOVIES_USING_IMDB_ID)
    public ResponseEntity<MovieDto> getMovieById(@PathVariable String imdbId) {
        return new ResponseEntity<MovieDto>(movieService.movieById(imdbId), HttpStatus.OK);
    }

}