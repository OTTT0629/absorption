package com.ottt.ottt.dao.community;

import java.util.List;

import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;

public interface communityDao {
	
	
	ArticleDTO select(Integer article_no) throws Exception;
	
	List<ArticleDTO> selectAll() throws Exception;
	
	List<ArticleDTO> selectcollection(Integer user_no) throws Exception;
	
	
	int insert(ArticleDTO dto) throws Exception;
	
	
	int delete(Integer article_no, int user_no) throws Exception;
	
	
	int update(ArticleDTO articleDTO) throws Exception;


	
	
	
	
	
	

	
	
	
	
	

}
