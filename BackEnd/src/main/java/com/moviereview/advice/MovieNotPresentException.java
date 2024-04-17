package com.moviereview.advice;

public class MovieNotPresentException extends RuntimeException{
    public MovieNotPresentException(String msg) {
        super(msg);
    }
}
