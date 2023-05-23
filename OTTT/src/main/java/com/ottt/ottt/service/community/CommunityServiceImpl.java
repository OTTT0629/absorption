package com.ottt.ottt.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.community.communityDao;
import com.ottt.ottt.dao.community.communityDaoImpl;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;
import com.ottt.ottt.dto.ArticleSearchDTO;

@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	communityDao communityDao;
	

	
	@Override
	public ArticleDTO read(Integer article_no) throws Exception {
		ArticleDTO articleDTO = communityDao.select(article_no);
		return articleDTO;
	}

	@Override
	public int remove(Integer article_no) throws Exception {
		communityDao.delete(article_no);
		return communityDao.delete(article_no);
	}

	@Override
	public int write(ArticleDTO articleDTO) throws Exception {
		return communityDao.insert(articleDTO);
	}

	@Override
	public int modify(ArticleDTO articleDTO) throws Exception {
		return communityDao.update(articleDTO);
	}

	@Override
	public List<ArticleDTO> showAllPage() throws Exception {
		return communityDao.selectAll();
	}


	/**
	 * 페이징용 목록
	 */
	@Override
	public List<ArticleDTO> getArticleList(ArticleSearchDTO dto) throws Exception {
		return communityDao.getArticleList(dto);
	}

	/**
	 * 총 개수
	 */
	@Override
	public int getArticleTotalCount(Integer user_no) throws Exception {
		return communityDao.getArticleTotalCount(user_no);
	}
}
