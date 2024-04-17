package com.moviereview.dto;

import com.moviereview.entity.Review;
import lombok.Data;
import java.util.List;

@Data
public class MovieDto {
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    private List<Review> reviewIds;
}
