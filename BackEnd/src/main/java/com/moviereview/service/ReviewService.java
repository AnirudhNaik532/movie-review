package com.moviereview.service;

import com.moviereview.dto.ReviewDto;

public interface ReviewService {
//    public ReviewDto createReview(String reviewBody, String imdbId);
    public String createReview(ReviewDto reviewDto);
}
