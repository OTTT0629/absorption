package com.ottt.ottt.dao.mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.MyDiaryDTO;

@Repository
public class MyDiaryDaoImpl implements MyDiaryDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace ="com.ottt.ottt.dao.mypage.MyDiaryMapper.";

	@Override
	public List<MyDiaryDTO> myDiaryAll(SearchItem sc) throws Exception {
		return session.selectList(namespace + "myDiaryAll", sc);
	}

	@Override
	public int myDiaryCnt(SearchItem sc) throws Exception {
		return session.selectOne(namespace + "myDiaryCnt", sc);
	}

}
