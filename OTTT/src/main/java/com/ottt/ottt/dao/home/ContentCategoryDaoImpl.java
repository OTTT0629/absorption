package com.ottt.ottt.dao.home;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.ContentCategoryDTO;

@Repository
public class ContentCategoryDaoImpl implements ContentCategoryDao {
	
	@Autowired
	private SqlSession session;
	private String namespace = "com.ottt.ottt.dao.home.ContentCategoryMapper.";

	@Override
	public ContentCategoryDTO categorySelect(Integer category_no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
