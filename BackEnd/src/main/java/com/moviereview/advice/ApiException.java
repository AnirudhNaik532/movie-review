package com.moviereview.advice;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;
}
