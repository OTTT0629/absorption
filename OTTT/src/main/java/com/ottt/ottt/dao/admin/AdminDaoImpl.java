package com.ottt.ottt.dao.admin;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.CommentDTO;
import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.dto.UserDTO;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace ="com.ottt.ottt.dao.admin.adminMapper.";
	
	//유저 정보 페이지
	@Override
	public List<UserDTO> selectUser(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectUser", sc);
	}

	@Override
	public int count(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"count", sc);
	}
	
	@Override
	public int blockUser(Integer user_no) throws Exception {
		// TODO Auto-generated method stub
		return session.update(namespace + "blockUser", user_no);
	}
	
	//유저 신고 페이지
	@Override
	public List<UserDTO> selectUserReport(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectUserReport", sc);
	}	
	
	//리뷰 신고 페이지
	@Override
	public List<ReviewDTO> selectReview(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectReview", sc);
	}

	@Override
	public int countReview(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + "countReview", sc);
	}
	
	@Override
	public int deleteReview(int review_no) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace + "deleteReview", review_no);
	}
	
	
	//게시글 신고 페이지
	@Override
	public List<ArticleDTO> selectArticle(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectArticle", sc);
	}

	@Override
	public int countArticle(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + "countArticle", sc);
	}
	
	@Override
	public int deleteArticle(int article_no) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace + "deleteArticle", article_no);
	}
	
	//댓글 신고 페이지
	@Override
	public List<CommentDTO> selectComment(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectComment", sc);
	}

	@Override
	public int countComment(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + "countComment", sc);
	}

	@Override
	public int deleteComment(int cmt_no) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(namespace + "deleteComment", cmt_no);
	}
	
}
