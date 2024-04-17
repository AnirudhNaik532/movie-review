package com.moviereview.service;

import com.moviereview.dto.MovieDto;
import com.moviereview.entity.Movie;
import org.bson.types.ObjectId;

import java.util.List;

public interface MovieService {
    List<MovieDto> allMovies();
    MovieDto movieById(String imdbId);
}
