package com.moviereview.dto;

import com.moviereview.utils.Constants;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReviewDto {
    @NotEmpty(message = Constants.REVIEW_CANNOT_BE_EMPTY)
    private String body;
    @NotEmpty(message = Constants.IMDB_ID_CANNOT_BE_EMPTY)
    private String imdbId;
}
