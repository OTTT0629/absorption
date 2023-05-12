package com.ottt.ottt.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.community.communityDao;
import com.ottt.ottt.dao.community.communityDaoImpl;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;

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
	public int remove(Integer article_no, int user_no) throws Exception {
		return communityDao.delete(article_no, user_no);
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



}
