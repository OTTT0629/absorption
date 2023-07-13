package com.ottt.ottt.controller.mypage;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.mypage.FollowService;
import com.ottt.ottt.service.user.UserService;

@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	UserService us;
	@Autowired
	FollowService fs;

	//마이페이지 메인
	@GetMapping(value = "/mypage")
	public String mypage(Model m, String toURL, String user
						, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("==========GET=============== toURL : " + toURL);
		
		if(!loginCheck(request))
			return "redirect:/login?toURL="+toURL;
		
		// 본인인지 확인
		if(!user.equals(session.getAttribute("user_nicknm"))) {
			user = URLEncoder.encode(user, "UTF-8");
			return "redirect:/profile?user="+user;
		}			

		String user_id = (String) session.getAttribute("id");
		
		try {
			UserDTO userDTO = us.getUser(user_id);
			Integer followerCnt = fs.followerCnt((Integer)session.getAttribute("user_no"));
			Integer followingCnt = fs.followingCnt((Integer)session.getAttribute("user_no"));
			
			m.addAttribute(userDTO);
			m.addAttribute("followerCnt", followerCnt);
			m.addAttribute("followingCnt", followingCnt);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return "/mypage/myprofile/mypage";
	}	
	
	@GetMapping("/profile")
	public String profile (String user, HttpSession session, Model m, RedirectAttributes rattr) {
		
		Integer my_no = session.getAttribute("user_no") != null ?
				(Integer) session.getAttribute("user_no") : -1;
		
		try {
			if(us.selectNicknmCnt(user) == 0)
				throw new Exception("No Uesr");
			Integer user_no = us.getUserNoId(user);
			
			if(my_no.equals(user_no)) {
				UserDTO userDTO = us.getUser(my_no);
				String my_nicknm = URLEncoder.encode(userDTO.getUser_nicknm(), "UTF-8");
				return "redirect:/mypage?user="+my_nicknm;
			}
			
			UserDTO userDTO = us.getUser(user_no);
			Integer followerCnt = fs.followerCnt(user_no);
			Integer followingCnt = fs.followingCnt(user_no);
			
			m.addAttribute(userDTO);
			m.addAttribute("followerCnt", followerCnt);
			m.addAttribute("followingCnt", followingCnt);
			
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "NO_USER");
			return "redirect:/";
		}
		
		return "/mypage/profile/profile";
	}

	@PostMapping("/profile")
	public String profile (Integer user_no, HttpSession session, HttpServletRequest request
							, Model m, String toURL, SearchItem sc) {
		
		Integer my_no = (Integer) session.getAttribute("user_no");

		System.out.println("=================================== my_no : " + session.getAttribute("user_no"));
		
		System.out.println("=================================== user_no : " + user_no);
		
		System.out.println("=================================== my_no != null : " + (my_no != null));
		
		System.out.println("=================================== toURL : " + toURL);
					
		
		// 내 프로필인지 아닌지 확인
		if((my_no != null)) {
			if((my_no.equals(user_no))) {
				try {
					UserDTO userDTO = us.getUser(my_no);
					String user = URLEncoder.encode(userDTO.getUser_nicknm(), "UTF-8");
					return "redirect:/mypage?user="+user;
					
				} catch (Exception e) { e.printStackTrace(); }
			}
		}
		
		UserDTO userDTO;
		try {
			userDTO = us.getUser(user_no);
			m.addAttribute(userDTO);
			
			return "/mypage/profile/profile";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:"+toURL;			
		}
	}
	
	// 팔로우 상태 확인
	@PostMapping("/getFollowStatus")
	@ResponseBody
	public boolean getFollowStatus (Integer my_no, Integer user_no) {
		try {
			logger.info("================== my_no : " + my_no);
			logger.info("================== user_no : " + user_no);
			
			if(fs.getFollowStatus(my_no, user_no))
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;		
	}
	
	// 팔로우
	@PostMapping("/startFollow")
	@ResponseBody
	public boolean startFollow (Integer my_no, Integer user_no) {
		logger.info("================== startFollow 진입 : ");
		
		logger.info("================== my_no : " + my_no);
		logger.info("================== user_no : " + user_no);
		
		try {
			fs.startFollow(my_no, user_no);
			
			logger.info("================== status : " + fs.getFollowStatus(my_no, user_no));
			
			if(fs.getFollowStatus(my_no, user_no))
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	// 팔로우 취소
	@PostMapping("/stopFollow")
	@ResponseBody
	public boolean stopFollow (Integer my_no, Integer user_no) {
		logger.info("================== stopFollow 진입 : ");
		
		logger.info("================== my_no : " + my_no);
		logger.info("================== user_no : " + user_no);
		
		try {
			fs.stopFollow(my_no, user_no);
			
			logger.info("================== status : " + fs.getFollowStatus(my_no, user_no));
			
			if(fs.getFollowStatus(my_no, user_no))
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
		
	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어 (false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환 
		return session != null && session.getAttribute("id")!=null;
	}

}
