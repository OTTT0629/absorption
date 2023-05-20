package com.ottt.ottt.dao.home;

import com.ottt.ottt.dto.ContentGenreDTO;

public interface ContentGenreDao {

	ContentGenreDTO genreSelect(Integer content_no) throws Exception;
}
