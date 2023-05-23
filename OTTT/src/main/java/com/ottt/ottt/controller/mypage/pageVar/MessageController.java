package com.ottt.ottt.controller.mypage.pageVar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MessageController {

	//쪽지함 메인 
	@GetMapping(value = "/message")
	public String message() {
	return "/mypage/myprofile/message";		
	}
	
	//쪽지함 셋팅
	@GetMapping(value = "/messagesetting")
	public String messagesetting() {
	return "/mypage/myprofile/message_set";		
	}
}
