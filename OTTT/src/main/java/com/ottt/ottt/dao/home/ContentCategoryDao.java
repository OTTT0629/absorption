package com.ottt.ottt.dao.home;

import com.ottt.ottt.dto.ContentCategoryDTO;

public interface ContentCategoryDao {
	
	ContentCategoryDTO categorySelect(Integer category_no) throws Exception;
}
