package com.ottt.ottt.service.mypage;

import java.util.List;

import com.ottt.ottt.dto.UserDTO;

public interface FollowService {
	boolean getFollowStatus (Integer my_no, Integer user_no) throws Exception;
	int startFollow (Integer my_no, Integer user_no) throws Exception;
	int stopFollow (Integer my_no, Integer user_no) throws Exception;
	List<UserDTO>getFollowerList(Integer my_no) throws Exception;
	List<UserDTO>getFollowingList(Integer my_no) throws Exception;	
	int followerCnt(Integer my_no) throws Exception;
	int followingCnt(Integer my_no) throws Exception;
}
