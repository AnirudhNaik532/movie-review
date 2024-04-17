package com.moviereview.controller;

import com.moviereview.dto.ReviewDto;
import com.moviereview.service.ReviewService;
import com.moviereview.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

//    @PostMapping(Constants.Routes.API_MOVIES_REVIEWS)
//    public ResponseEntity<String> createReview(@RequestBody Map<String, String> payload) {
//        return new ResponseEntity<String>(
//                reviewService.createReview(payload.get("reviewBody"),
//                        payload.get("imdbId")),
//                HttpStatus.CREATED);

        @PostMapping(Constants.Routes.API_MOVIES_REVIEWS)
        public ResponseEntity<String> createReview(@RequestBody @Valid ReviewDto reviewDto) {
            return new ResponseEntity<String>(
                    reviewService.createReview(reviewDto),
                    HttpStatus.CREATED);
    }
}
