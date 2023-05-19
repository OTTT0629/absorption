package com.ottt.ottt.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class NoticeController {
	//notice
	@GetMapping(value = "/notice")
	public String notice() {
			return "/community/notice/notice";		
	}
		
}
