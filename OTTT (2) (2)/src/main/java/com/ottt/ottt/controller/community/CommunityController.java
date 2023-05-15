package com.ottt.ottt.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {
	//freecommunity 메인
	@GetMapping(value = "/community")
	public String freecommunity() {
			return "/community/freecommunity/community_main";		
	}
	
	//community 글 자세히보기
	@GetMapping(value = "/community/post")
	public String freecommunityPost() {
			return "/community/freecommunity/community_post";		
	}
}

























