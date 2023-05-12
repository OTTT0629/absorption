package com.ottt.ottt.controller.mycommunity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mycommynity")
public class LikecommuController {

	//내가 좋아요누른 글 보기 
	@GetMapping(value = "/likecommunity")
	public String likecommu() {
	return "/community/freecommunity/like_collection";		
	}
}
