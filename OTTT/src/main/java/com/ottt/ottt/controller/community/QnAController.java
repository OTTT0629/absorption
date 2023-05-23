package com.ottt.ottt.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class QnAController {
	//QnA
		@GetMapping(value = "/QnA")
		public String QnA() {
				return "/community/QnA/QnA";		
		}

	//QnA
		@GetMapping(value = "/QnA/create")
		public String createQnA() {
		return "/community/QnA/QnA create";		
		}
}
