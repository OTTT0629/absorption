package com.ottt.ottt.dao.admin;

import java.util.List;

import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.CommentDTO;
import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.dto.UserDTO;


public interface AdminDao {
	
	//유저 정보 페이지
	List<UserDTO> selectUser(SearchItem sc) throws Exception;
	int count(SearchItem sc) throws Exception;
	int blockUser(Integer user_no) throws Exception;
	
	//유저 신고 페이지
	List<UserDTO> selectUserReport(SearchItem sc)throws Exception;
	
	//리뷰 신고 페이지
	List<ReviewDTO> selectReview(SearchItem sc) throws Exception;
	int countReview(SearchItem sc) throws Exception;
	int deleteReview(int review_no) throws Exception;
	
	//게시글 신고 페이지
	List<ArticleDTO> selectArticle(SearchItem sc) throws Exception;
	int countArticle(SearchItem sc) throws Exception;
	int deleteArticle(int article_no) throws Exception;
	
	//댓글 신고 페이지
	List<CommentDTO> selectComment(SearchItem sc) throws Exception;
	int countComment(SearchItem sc) throws Exception;
	int deleteComment(int cmt_no) throws Exception;
}
