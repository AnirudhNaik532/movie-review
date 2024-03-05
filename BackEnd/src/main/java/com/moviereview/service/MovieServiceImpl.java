package com.moviereview.service;

import com.moviereview.advice.MovieNotPresentException;
import com.moviereview.dto.MovieDto;
import com.moviereview.entity.Movie;
import com.moviereview.mapper.MovieMapper;
import com.moviereview.repository.MovieRepository;
import com.moviereview.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<MovieDto> allMovies() {
        List<Movie> listOfMovies = movieRepository.findAll();
        return listOfMovies.stream()
                .map(movie -> {
                    return movieMapper.convertMovieEntityToDto(movie);
                })
                .collect(Collectors.toList());

    }

    @Override
    public MovieDto movieById(String imdbId) {
        Movie movieByImdbId = movieRepository.findMovieByImdbId(imdbId)
                .orElseThrow(() -> new MovieNotPresentException(Constants.MOVIE_NOTFOUND));
        return movieMapper.convertMovieEntityToDto(movieByImdbId);
    }
}