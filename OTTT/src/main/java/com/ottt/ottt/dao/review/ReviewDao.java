package com.ottt.ottt.dao.review;

import java.util.List;

import com.ottt.ottt.dto.ReviewDTO;

public interface ReviewDao {
	int delete(Integer review_no, int user_no) throws Exception;			//삭제
	int update(ReviewDTO reviewDTO) throws Exception;						//수정
	int insert(ReviewDTO dto) throws Exception ;							//작성
	
	
	ReviewDTO selectReview(Integer content_no, Integer user_no)throws Exception;
	
	int count() throws Exception;
	
	List<ReviewDTO> selectAll() throws Exception;
	
	
//	List<CommentDTO> selectCommentsByBoard(??) throws Exception;
}
