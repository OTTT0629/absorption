package com.ottt.ottt.service.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.mypage.FollowDao;
import com.ottt.ottt.dao.user.UserDao;
import com.ottt.ottt.dto.UserDTO;

@Service
public class FollowServiceImpl implements FollowService{
	
	@Autowired
	FollowDao followDao;
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean getFollowStatus(Integer my_no, Integer user_no) throws Exception {
		return (followDao.followCnt(my_no, user_no) != 0);
	}

	@Override
	public int startFollow(Integer my_no, Integer user_no) throws Exception {
		userDao.increaseFollowing(my_no);
		userDao.increaseFollower(user_no);
		return followDao.insertFollow(my_no, user_no);
	}

	@Override
	public int stopFollow(Integer my_no, Integer user_no) throws Exception {
		userDao.decreaseFollowing(my_no);
		userDao.decreaseFollower(user_no);
		return followDao.deletFollow(my_no, user_no);
	}

	@Override
	public List<UserDTO> getFollowerList(Integer my_no) throws Exception {
		return followDao.selectFollower(my_no);
	}

	@Override
	public List<UserDTO> getFollowingList(Integer my_no) throws Exception {
		return followDao.selectFollowing(my_no);
	}

	@Override
	public int followerCnt(Integer my_no) throws Exception {
		return followDao.selectAllFollower(my_no);
	}

	@Override
	public int followingCnt(Integer my_no) throws Exception {
		return followDao.selectAllFollowing(my_no);
	}

}
