package com.moviereview.service;

import com.moviereview.advice.MovieNotPresentException;
import com.moviereview.dto.ReviewDto;
import com.moviereview.entity.Movie;
import com.moviereview.entity.Review;
import com.moviereview.mapper.ReviewMapper;
import com.moviereview.repository.MovieRepository;
import com.moviereview.repository.ReviewRepository;
import com.moviereview.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ReviewMapper reviewMapper;
    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

@Override
public String createReview(ReviewDto reviewDto) {
    logger.info("Adding review using mongodb insert");
    Review addReview =reviewRepository.insert(new Review(reviewDto.getReviewBody()));
    Movie movieByImdbId = movieRepository.findMovieByImdbId(reviewDto.getImdbId())
            .orElseThrow(() -> new MovieNotPresentException(Constants.MOVIE_NOTFOUND));

    //to associate with a movie
    //mongoTemplate helps to talk with the repository, for complex problems
    logger.info("Adding review into the movies collection using mongodb template");
    mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(reviewDto.getImdbId()))
            .apply(new Update().push("reviewIds").value(addReview))
            .first();
    return String.format(Constants.REVIEW_ADDED,movieByImdbId.getTitle());
}
    //    @Override
//    public ReviewDto createReview(String reviewBody, String imdbId) {
//        Review addReview =reviewRepository.insert(new Review(reviewBody));
//        Movie movieByImdbId = movieRepository.findMovieByImdbId(imdbId)
//                .orElseThrow(() -> new MovieNotPresentException(Constants.MOVIE_NOTFOUND));
//
//        //to associate with a movie
//        //mongoTemplate helps to talk with the repository, for complex problems
//        mongoTemplate.update(Movie.class)
//                .matching(Criteria.where("imdbId").is(imdbId))
//                .apply(new Update().push("reviewIds").value(addReview))
//                .first();
//        return reviewMapper.convertReviewEntityToDto(addReview);
//    }
}