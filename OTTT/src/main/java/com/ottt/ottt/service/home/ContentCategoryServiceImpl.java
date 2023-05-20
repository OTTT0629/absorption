package com.ottt.ottt.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.home.ContentCategoryDaoImpl;
import com.ottt.ottt.dto.ContentCategoryDTO;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	ContentCategoryDaoImpl contentCategoryDao;
	
	@Override
	public ContentCategoryDTO getCategory(Integer content_no) throws Exception {
		// TODO Auto-generated method stub
		return contentCategoryDao.categorySelect(content_no);
	}

}
