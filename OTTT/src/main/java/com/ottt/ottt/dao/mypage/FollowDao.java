package com.ottt.ottt.dao.mypage;

import java.util.List;

import com.ottt.ottt.dto.UserDTO;

public interface FollowDao {
	int followCnt (Integer my_no, Integer user_no) throws Exception;
	int insertFollow (Integer my_no, Integer user_no) throws Exception;
	int deletFollow (Integer my_no, Integer user_no) throws Exception;
	List<UserDTO> selectFollower (Integer my_no) throws Exception;
	List<UserDTO> selectFollowing (Integer my_no) throws Exception;
	int selectAllFollower (Integer my_no) throws Exception;
	int selectAllFollowing (Integer my_no) throws Exception;	
}
