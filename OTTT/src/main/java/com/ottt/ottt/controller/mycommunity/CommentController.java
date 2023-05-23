package com.ottt.ottt.controller.mycommunity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mycommynity")
public class CommentController {

	//내가 쓴 댓글 보기 
	@GetMapping(value = "/comment")
	public String mycomment() {
	return "/community/freecommunity/comment_collection";		
	}
}
