package com.ottt.ottt.service.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.home.ContentDaoImpl;
import com.ottt.ottt.dto.ContentDTO;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	ContentDaoImpl contentDao;
	
	@Override
	public List<ContentDTO> getRating() throws Exception {
		return contentDao.ratingSelect();
	}

	
}
