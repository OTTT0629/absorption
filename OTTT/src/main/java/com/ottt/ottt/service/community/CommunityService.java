package com.ottt.ottt.service.community;

import java.util.List;

import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleSearchDTO;

public interface CommunityService {
	
	//service는 메서드의 이름을 dao와 dto와는 다른느낌
	List<ArticleDTO> showAllPage() throws Exception;
	
	ArticleDTO read(Integer article_no) throws Exception;
	
	int remove(Integer article_no) throws Exception;
	
	int write(ArticleDTO articleDTO) throws Exception;
	
	int modify(ArticleDTO articleDTO) throws Exception;
	
	/**
	 * 페이징용 목록
	 */
	List<ArticleDTO> getArticleList(ArticleSearchDTO dto) throws Exception;
	
	/**
	 * 총 건수
	 */
	int getArticleTotalCount(Integer user_no) throws Exception;
	
}
