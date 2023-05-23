package com.ottt.ottt.dao.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.ReviewDTO;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSession session;
	private static String namespace ="com.ottt.ottt.dao.review.reviewMapper.";
	@Override
	public int delete(Integer review_no, int user_no) throws Exception {
		Map map = new HashMap();
		map.put("review_no", review_no);
		map.put("user_no", user_no);
		return session.delete(namespace+"delete", map);
	}
	@Override
	public int update(ReviewDTO reviewDTO) throws Exception {
		
		return session.update(namespace+"update", reviewDTO);
	}
	@Override
	public int insert(ReviewDTO dto) throws Exception {
		
		return session.insert(namespace+"insert", dto);
	}
	@Override
	public int count() throws Exception {
		
		return session.selectOne(namespace+"count");
	}
	@Override
	public List<ReviewDTO> selectAll() throws Exception {
		
		return session.selectList(namespace+"selectAll");
	}
<<<<<<< HEAD
=======
	@Override
	public ReviewDTO selectReview(Integer content_no, Integer user_no) throws Exception {
		Map map = new HashMap();
		map.put("user_no", user_no);
		map.put("content_no", content_no );
		return session.selectOne(namespace + "selectReview", map);
	}
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
	
	
	
}
