package com.ottt.ottt.service.content;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.content.ContentDaoImpl;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ContentDTO;
import com.ottt.ottt.dto.ContentOTTDTO;
import com.ottt.ottt.dto.GenreDTO;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	ContentDaoImpl contentDao;
	
	@Override
	public List<ContentDTO> getRating() throws Exception {
		return contentDao.ratingSelect();
	}

	@Override
	public List<ContentOTTDTO> getOttImg(Integer content_no) throws Exception {
		// TODO Auto-generated method stub
		return contentDao.ottNameSelect(content_no);
	}

	@Override
	public List<ContentDTO> getMovieList(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return contentDao.movieSelect(sc);
	}

	@Override
	public int getMovieTotalCount(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return contentDao.movieCount(sc);
	}

	@Override
	public List<ContentDTO> getSearchSelect(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return contentDao.searchSelect(map);
	}

	@Override
	public int getSearchTotalCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return contentDao.searchCount(map);
	}

	@Override
	public ContentDTO getContent(Integer content_no) throws Exception {
		// TODO Auto-generated method stub
		return contentDao.selectContent(content_no);
	}

	@Override
	public List<GenreDTO> getGenrenm(Integer content_no) throws Exception {
		
		return contentDao.selectGenrenm(content_no);
	}

	@Override
	public List<ContentOTTDTO> getOTT(Integer content_no) throws Exception {
		
		return contentDao.selectOTT(content_no);
	}


	
}
