package com.ottt.ottt.service.admin;

import java.util.List;

import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.CommentDTO;
import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.dto.UserDTO;


public interface AdminService {
	
	//유저 정보 페이지
	List<UserDTO> getUserInfo(SearchItem sc) throws Exception;
	int getCount(SearchItem sc) throws Exception;
	int blockUser(Integer user_no) throws Exception;
	
	//유저 신고 페이지
	List<UserDTO> getUserReport(SearchItem sc) throws Exception;
	
	//리뷰 신고 페이지
	List<ReviewDTO> getReview(SearchItem sc)throws Exception;
	int getReviewCount(SearchItem sc) throws Exception;
	int removeReview(int review_no) throws Exception;
	
	//게시글 신고 페이지
	List<ArticleDTO> getArticle(SearchItem sc)throws Exception;
	int getArticleCount(SearchItem sc) throws Exception;
	int removeArticle(int article_no) throws Exception;
	
	//댓글 신고 페이지
	List<CommentDTO> getComment(SearchItem sc)throws Exception;
	int getCommnetCount(SearchItem sc) throws Exception;
	int removeComment(int cmt_no) throws Exception;
}
