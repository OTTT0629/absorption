package com.ottt.ottt.controller.mypage.pageVar.record;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class ReviewController {
	
		//myreview 메인 
		@GetMapping(value = "/myreview")
		public String myreview() {
			
			return "/mypage/myprofile/myreview";		
		}
		
		
}
