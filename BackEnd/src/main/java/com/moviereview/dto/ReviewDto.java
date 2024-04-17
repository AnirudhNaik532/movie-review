package com.moviereview.dto;

import com.moviereview.utils.Constants;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    @NotEmpty(message = Constants.REVIEW_CANNOT_BE_EMPTY)
    private String reviewBody;

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @NotEmpty(message = Constants.IMDB_ID_CANNOT_BE_EMPTY)
    private String imdbId;
}
