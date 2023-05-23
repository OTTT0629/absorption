package com.ottt.ottt.dao.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleSearchDTO;

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
	public int delete(Integer article_no) throws Exception {
		System.out.println("daoimpl");
		return session.delete(namespace + "delete", article_no);
	}

	@Override
	public int update(ArticleDTO articleDTO) throws Exception {
		return session.update(namespace + "update", articleDTO);
	}



	@Override
	public List<ArticleDTO> selectcollection(Integer user_no) throws Exception {
		return session.selectList(namespace +"selectcollection", user_no);
	}

	/**
	 * 페이징용 목록
	 */
	@Override
	public List<ArticleDTO> getArticleList(ArticleSearchDTO dto) throws Exception {
		return session.selectList(namespace + "getArticleList", dto);
	}
	
	@Override
	public int getArticleTotalCount(Integer user_no) throws Exception {
		return session.selectOne(namespace +"getArticleTotalCount", user_no);
	}







}
