package com.ottt.ottt.controller.login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.user.UserService;


@Controller
public class LoginController {
	
	@Autowired
	UserService us;

	//로그인 페이지
	@GetMapping(value = "/login")
	public String login(String toURL) {
		
	return "/login/loginForm";		
	}
	
	@PostMapping("/login")
	public String login(String user_id, String user_pwd, String toURL, boolean rememberId,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		if(!loginCheck(user_id, user_pwd)) {
		String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다", "utf-8");
		return "redirect:/login?msg="+msg;
		}

		if(rememberId) {
		Cookie cookie = new Cookie("id", user_id);
		response.addCookie(cookie);
		}
		else {
		Cookie cookie = new Cookie("id", user_id);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		}
		
		//3. 세션
		//   객체 얻어오기
		HttpSession session = request.getSession();
		try {
			Integer user_no = us.getUserNo(user_id);
		//   세션 객체에 id를 저장
			session.setAttribute("id", user_id);
			session.setAttribute("user_no", user_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//4. 뷰 이동

		UserDTO userDTO = userDao.select(user_id);		
		HttpSession session = request.getSession();
		session.setAttribute("id", user_id);
		session.setAttribute("admin", userDTO.getAdmin());
		session.setAttribute("no", userDTO.getUser_no());

		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
				
		return "redirect:" +toURL;
	}
	
	//DB꺼 가져와서 CHECK해야함
	private boolean loginCheck(String user_id, String user_pwd) {
		UserDTO user;
		try {
			user = us.getUser(user_id);
			if(user == null) return false;
			return user.getUser_pwd().equals(user_pwd);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	private boolean loginCheck(String id, String pwd) {
		UserDTO user = userDao.select(id);
		if(user == null) return false;
		return user.getUser_pwd().equals(pwd);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
	

}







