package com.ottt.ottt.dao.review;

import java.util.List;

import com.ottt.ottt.dto.ReviewDTO;

public interface ReviewDao {
	int delete(Integer review_no, int user_no) throws Exception;			//삭제
	int update(ReviewDTO reviewDTO) throws Exception;						//수정
	int insert(ReviewDTO dto) throws Exception ;							//작성
<<<<<<< HEAD

=======
	
	
	ReviewDTO selectReview(Integer content_no, Integer user_no)throws Exception;
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
	
	int count() throws Exception;
	
	List<ReviewDTO> selectAll() throws Exception;
	
	
//	List<CommentDTO> selectCommentsByBoard(??) throws Exception;
}
