package com.moviereview.utils;

public interface Constants {
    String MOVIE_NOTFOUND = "Sorry this movie does not exist!";
    String REVIEW_CANNOT_BE_EMPTY = "Review cannot be empty! Please enter your review";
    String IMDB_ID_CANNOT_BE_EMPTY = "imdbId cannot be empty! Please enter the ID";
    String REVIEW_ADDED = "Review Added successfully for the movie %s";

    class Routes {
        public static final String API = "/api";
        public static final String API_VERSION = API + "/v1";
        public static final String API_MOVIES = API_VERSION + "/movies";
        public static final String API_MOVIES_USING_IMDB_ID = API_MOVIES + "/{imdbId}";
        public static final String API_MOVIES_REVIEWS = API_MOVIES + "/reviews";
        private Routes() {
        }
    }
}
