package com.ottt.ottt.service.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.user.UserDao;
import com.ottt.ottt.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDTO getUser(String user_id) throws Exception {
		//유저 id로 회원 찾기
		return userDao.select(user_id);
	}

	@Override
	public List<UserDTO> getAllUser() throws Exception {
		//유저정보 전체 받기
		return userDao.selectAll();
	}

	@Override
	public int bye(Integer user_no, String user_id) throws Exception {
		//유저정보 삭제
		return userDao.delete(user_no, user_id);
	}

	@Override
	public int modify(UserDTO userDTO) throws Exception {
		//유저정보 전부 변경
		return userDao.update(userDTO);
	}

	@Override
	public int mod_nick(UserDTO userDTO) throws Exception {
		//유저 닉네임 변경
		return userDao.up_nicknm(userDTO);
	}

	@Override
	public int getUserNo(String user_id) throws Exception {
		//유저 id로 user_no 찾기
		return userDao.selectUserNo(user_id);
	}

	@Override
	public int selectNicknmCnt(String user_nicknm) throws Exception {
		//중복된 닉네임 여부
		return userDao.selectNicknmCnt(user_nicknm);
	}

	@Override
	public int mod_pwd(UserDTO userDTO) throws Exception {
		//유저 비밀번호 변경
		return userDao.up_pwd(userDTO);
	}

}
