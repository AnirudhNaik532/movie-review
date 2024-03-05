package com.moviereview.mapper;

import com.moviereview.dto.ReviewDto;
import com.moviereview.entity.Review;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewMapper {
    @Autowired
    private ModelMapper modelMapper;
    public ReviewDto convertReviewEntityToDto(Review review) {
        return this.modelMapper.map(review, ReviewDto.class);
    }
}