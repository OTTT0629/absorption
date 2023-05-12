package com.ottt.ottt.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class SettingController {
		
		//마이페이지 프로필 셋팅
		@GetMapping(value = "/setting")
		public String mysetting() {
		return "/mypage/myprofile/mysetting";		
		}
		
		//프로필 변경
		@GetMapping(value = "/setting/myprofile")
		public String myprofile() {
		return "/mypage/myprofile/myprofile";		
		}
		
		//내정보 변경
		@GetMapping(value = "/setting/myinfo")
		public String myinfo() {
		return "/mypage/myprofile/myinfo";		
		}
		//회원탈퇴
}
