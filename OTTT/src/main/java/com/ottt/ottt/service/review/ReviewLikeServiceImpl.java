package com.ottt.ottt.service.review;

import org.springframework.beans.factory.annotation.Autowired;

import com.ottt.ottt.dao.review.ReviewLikeDao;
import com.ottt.ottt.dto.ReviewLikeDTO;

public class ReviewLikeServiceImpl implements ReviewLikeService {

	@Autowired
	ReviewLikeDao reviewLikeDao;
	
	@Override
	public int getReviewLikeYN(Integer review_no, Integer user_no) {
		
		return reviewLikeDao.reviewLikeYN(review_no, user_no);
	}

	@Override
	public int getReviewCount(Integer review_no) {
		
		return reviewLikeDao.likeCount(review_no);
	}

	@Override
	public int addLike(Integer review_no, Integer user_no) {
		
		return reviewLikeDao.addLike(review_no, user_no);
	}

	@Override
	public int removeLike(Integer review_no, Integer user_no) {
		
		return reviewLikeDao.removeLike(review_no, user_no);
	}

}
