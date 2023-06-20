package com.ottt.ottt.controller.mypage.pageVar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.service.user.UserService;

@Controller
@RequestMapping("/mypage")
public class WishController {
	
	@Autowired
	UserService us;

		//wishlist 메인 
		@GetMapping(value = "/wishlist")
		public String wishlist(String user, SearchItem sc, HttpSession session) {
			try {
				Integer user_no = us.getUserNoId(user);
				sc.setPageSize(12);
				sc.setUser(user);
				sc.setUser_no(user_no);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
		return "/mypage/myprofile/wishlist";
		}
		

}
