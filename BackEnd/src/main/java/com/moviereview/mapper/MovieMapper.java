package com.moviereview.mapper;

import com.moviereview.dto.MovieDto;
import com.moviereview.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieMapper {
    private final ModelMapper modelMapper;

    public MovieDto convertMovieEntityToDto(Movie movie) {
        return this.modelMapper.map(movie, MovieDto.class);
    }

}
