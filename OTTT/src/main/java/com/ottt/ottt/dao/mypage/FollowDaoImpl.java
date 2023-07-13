package com.ottt.ottt.dao.mypage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.UserDTO;

@Repository
public class FollowDaoImpl implements FollowDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace ="com.ottt.ottt.dao.mypage.FollowMapper.";

	@Override
	public int followCnt(Integer my_no, Integer user_no) throws Exception {
		Map map = new HashMap();
		map.put("my_no", my_no);
		map.put("user_no", user_no);
		return session.selectOne(namespace + "followCnt", map);
	}

	@Override
	public int insertFollow(Integer my_no, Integer user_no) throws Exception {
		Map map = new HashMap();
		map.put("my_no", my_no);
		map.put("user_no", user_no);
		return session.insert(namespace + "insertFollow", map);
	}

	@Override
	public int deletFollow(Integer my_no, Integer user_no) throws Exception {
		Map map = new HashMap();
		map.put("my_no", my_no);
		map.put("user_no", user_no);
		return session.delete(namespace + "deletFollow", map);
	}

	@Override
	public List<UserDTO> selectFollower(Integer my_no) throws Exception {
		return session.selectList(namespace + "selectFollower", my_no);
	}

	@Override
	public List<UserDTO> selectFollowing(Integer my_no) throws Exception {
		return session.selectList(namespace + "selectFollowing", my_no);
	}

	@Override
	public int selectAllFollowing(Integer my_no) throws Exception {
		return session.selectOne(namespace + "selectAllFollowing", my_no);
	}

	@Override
	public int selectAllFollower(Integer my_no) throws Exception {
		return session.selectOne(namespace + "selectAllFollower", my_no);
	}

}
