package com.ottt.ottt.service.home;

import com.ottt.ottt.dto.ContentCategoryDTO;

public interface ContentCategoryService {

	ContentCategoryDTO getCategory(Integer content_no) throws Exception;
}
