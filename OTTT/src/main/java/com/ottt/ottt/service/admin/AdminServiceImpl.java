package com.ottt.ottt.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.admin.AdminDao;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.CommentDTO;
import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.dto.UserDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired 
	AdminDao adminDao;
	
	//유저 정보 페이지
	@Override
	public List<UserDTO> getUserInfo(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectUser(sc);
	}

	@Override
	public int getCount(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.count(sc);
	}
	
	@Override
	public int blockUser(Integer user_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.blockUser(user_no);
	}
	
	//유저 신고 페이지
	@Override
	public List<UserDTO> getUserReport(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectUserReport(sc);
	}

	
	// 리뷰 신고 페이지
	@Override
	public List<ReviewDTO> getReview(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectReview(sc);
	}

	@Override
	public int getReviewCount(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countReview(sc);
	}
	
	@Override
	public int removeReview(int review_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.deleteReview(review_no);
	}
	
	//게시글 신고 페이지
	@Override
	public List<ArticleDTO> getArticle(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectArticle(sc);
	}

	@Override
	public int getArticleCount(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countArticle(sc);
	}
	
	@Override
	public int removeArticle(int article_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.deleteArticle(article_no);
	}
	
	//댓글 신고 페이지
	@Override
	public List<CommentDTO> getComment(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectComment(sc);
	}

	@Override
	public int getCommnetCount(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countComment(sc);
	}

	@Override
	public int removeComment(int cmt_no) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.deleteComment(cmt_no);
	}

}
