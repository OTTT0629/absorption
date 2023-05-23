package com.ottt.ottt.controller.workDetailPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailReplyController {

	@GetMapping(value = "/detailPage/reply")
	public String reviewReply() {
			return "/workDetailPage/reply";		
	}
	
}
