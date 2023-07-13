package com.ottt.ottt.controller.mypage;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.mypage.FollowService;
import com.ottt.ottt.service.user.UserService;

@Controller
public class FollowController {
	
	private static final Logger logger = LoggerFactory.getLogger(FollowController.class);
	
	@Autowired
	UserService us;
	
	@Autowired
	FollowService fs;

	// 내 팔로워
	@GetMapping(value = "/mypage/follower")
	public String myFollower(HttpSession session, Model m) {
		Integer user_no = (Integer) session.getAttribute("user_no");
		
		try {
			UserDTO userDTO = us.getUser(user_no);
			List<UserDTO> follower = fs.getFollowerList(user_no);
			Integer followerCnt = fs.followerCnt(user_no);
			Integer followingCnt = fs.followingCnt(user_no);
			
			m.addAttribute(userDTO);
			m.addAttribute("follow", follower);
			m.addAttribute("mode", "follower");
			m.addAttribute("stat", "my");
			m.addAttribute("followerCnt", followerCnt);
			m.addAttribute("followingCnt", followingCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return "/mypage/myprofile/followlist";
	}
	
	// 내 팔로잉
	@GetMapping(value = "/mypage/following")
	public String myFollowing(HttpSession session, Model m) {
		Integer user_no = (Integer) session.getAttribute("user_no");
		
		try {
			UserDTO userDTO = us.getUser(user_no);
			List<UserDTO> following = fs.getFollowingList(user_no);
			Integer followerCnt = fs.followerCnt(user_no);
			Integer followingCnt = fs.followingCnt(user_no);
			
			m.addAttribute(userDTO);
			m.addAttribute("follow", following);
			m.addAttribute("mode", "following");
			m.addAttribute("stat", "my");
			m.addAttribute("followerCnt", followerCnt);
			m.addAttribute("followingCnt", followingCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return "/mypage/myprofile/followlist";
	}
	
	//팔로워
	@GetMapping(value = "/profile/follower")
	public String follower(String user, HttpSession session, Model m) {
		
		try {
			Integer user_no = us.getUserNoId(user);
			
			if((session.getAttribute("user_no") != null)
					&& session.getAttribute("user_no") == user_no) {
				user = URLEncoder.encode(user, "UTF-8");
				return "redirect:/mypage/follower?user=" +user;
			}
			
			UserDTO userDTO = us.getUser(user_no);
			List<UserDTO> follower = fs.getFollowerList(user_no);
			Integer followerCnt = fs.followerCnt(user_no);
			Integer followingCnt = fs.followingCnt(user_no);
			
			m.addAttribute(userDTO);
			m.addAttribute("follow", follower);
			m.addAttribute("mode", "follower");
			m.addAttribute("followerCnt", followerCnt);
			m.addAttribute("followingCnt", followingCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return "/mypage/myprofile/followlist";
	}
	
	//팔로잉
	@GetMapping(value = "/profile/following")
	public String following(String user, HttpSession session, Model m) {
		
		try {
			Integer user_no = us.getUserNoId(user);
			
			if((session.getAttribute("user_no") != null)
					&& session.getAttribute("user_no") == user_no) {
				user = URLEncoder.encode(user, "UTF-8");
				return "redirect:/mypage/following?user=" +user;
			}
			
			UserDTO userDTO = us.getUser(user_no);
			List<UserDTO> following = fs.getFollowingList(user_no);
			Integer followerCnt = fs.followerCnt(user_no);
			Integer followingCnt = fs.followingCnt(user_no);
			
			m.addAttribute(userDTO);
			m.addAttribute("follow", following);
			m.addAttribute("mode", "following");
			m.addAttribute("followerCnt", followerCnt);
			m.addAttribute("followingCnt", followingCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return "/mypage/myprofile/followlist";
	}
}
