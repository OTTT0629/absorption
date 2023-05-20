package com.ottt.ottt.dao.home;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.ContentGenreDTO;

@Repository
public class ContentGenreDaoImpl implements ContentGenreDao {
	
	@Autowired
	private SqlSession session;
	private String namespace="";

	@Override
	public ContentGenreDTO genreSelect(Integer content_no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"genreSelect", content_no);
	}

}
