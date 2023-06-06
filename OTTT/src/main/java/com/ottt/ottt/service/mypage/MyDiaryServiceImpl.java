package com.ottt.ottt.service.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.mypage.MyDiaryDao;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.MyDiaryDTO;

@Service
public class MyDiaryServiceImpl implements MyDiaryService {
	
	@Autowired
	MyDiaryDao myDiaryDao;

	@Override
	public List<MyDiaryDTO> getMyDiary(SearchItem sc) throws Exception {
		return myDiaryDao.myDiaryAll(sc);
	}

	@Override
	public int myDiaryCnt(SearchItem sc) throws Exception {
		return myDiaryDao.myDiaryCnt(sc);
	}

}
