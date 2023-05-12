package com.ottt.ottt.dao.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;

@Repository
public class communityDaoImpl implements communityDao {
	
	
	@Autowired
	private SqlSession session;
	private static String namespace = "com.ottt.ottt.dao.CommunityMapper.";
	
	

	@Override
	public ArticleDTO select(Integer article_no) throws Exception {
		return session.selectOne(namespace + "select", article_no);
	}
	


	@Override
	public List<ArticleDTO> selectAll() throws Exception {
		return session.selectList(namespace + "selectAll");
	}

	@Override
	public int insert(ArticleDTO dto) throws Exception {
		return session.selectOne(namespace + "insert", dto);
	}


	@Override
	public int delete(Integer article_no, int user_no) throws Exception {
		Map map = new HashMap();
		map.put("article_no", article_no);
		map.put("user_no", user_no);
		
		return session.delete(namespace + "delete", map);
	}

	@Override
	public int update(ArticleDTO articleDTO) throws Exception {
		return session.update(namespace + "update", articleDTO);
	}



	@Override
	public List<ArticleDTO> selectcollection(Integer user_no) throws Exception {
		return session.selectList(namespace +"selectcollection", user_no);
	}








}
