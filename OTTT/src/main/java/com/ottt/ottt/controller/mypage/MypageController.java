package com.ottt.ottt.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

	//마이페이지 메인
	@GetMapping(value = "/mypage")
	public String mypage() {
	return "/mypage/myprofile/mypage";		
	}
		
}
