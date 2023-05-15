package com.ottt.ottt.service.review;

import java.util.List;

import com.ottt.ottt.dto.ReviewDTO;

public interface ReviewService {
    int removeReview(Integer review_no, int user_no) throws Exception;
    int modifyReview(ReviewDTO reviewDTO) throws Exception;
    int writeReview(ReviewDTO dto) throws Exception;

    int getCount()throws Exception;
    
    List<ReviewDTO> getReview() throws Exception;
    
}