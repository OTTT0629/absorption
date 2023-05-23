package com.ottt.ottt.service.review;

import java.util.List;

import com.ottt.ottt.dto.ReviewDTO;

public interface ReviewService {
<<<<<<< HEAD
    int removeReview(Integer review_no, int user_no) throws Exception;
=======
    int removeReview(Integer review_no, Integer user_no) throws Exception;
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
    int modifyReview(ReviewDTO reviewDTO) throws Exception;
    int writeReview(ReviewDTO dto) throws Exception;

    int getCount()throws Exception;
<<<<<<< HEAD
    
=======
    ReviewDTO getReviewNo(Integer content_no,Integer user_no ) throws Exception; 
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
    List<ReviewDTO> getReview() throws Exception;
    
}