package com.ottt.ottt.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.review.ReviewDao;
import com.ottt.ottt.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
    ReviewDao reviewDao;

	@Override
	public int removeReview(Integer review_no, Integer user_no) throws Exception {
		
		return reviewDao.delete(review_no, user_no);
	}

	@Override
	public int modifyReview(ReviewDTO reviewDTO) throws Exception {
		
		return reviewDao.update(reviewDTO);
	}

	@Override
	public int writeReview(ReviewDTO dto) throws Exception {
		
		return reviewDao.insert(dto);
	}

	@Override
	public int getCount() throws Exception {
		
		return reviewDao.count();
	}

	@Override
	public List<ReviewDTO> getReview() throws Exception {
		
		return reviewDao.selectAll();
	}

	@Override
	public ReviewDTO getReviewNo(Integer content_no, Integer user_no) throws Exception {
		// TODO Auto-generated method stub
		return reviewDao.selectReview(content_no, user_no);
	}

	

	
    

}
