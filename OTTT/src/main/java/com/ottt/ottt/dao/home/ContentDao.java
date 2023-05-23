package com.ottt.ottt.dao.home;

import java.util.List;

import com.ottt.ottt.dto.ContentDTO;

public interface ContentDao {

	List<ContentDTO> ratingSelect() throws Exception;
	List<ContentDTO> genreNameSelect(Integer content_no) throws Exception;
}
