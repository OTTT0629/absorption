package com.ottt.ottt.controller.mycommunity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mycommynity")
public class PostcommuController {

	//내가 작성한 게시글 보기 
	@GetMapping(value = "/postcommu")
	public String postcommu() {
	return "/community/freecommunity/mypost_collection";		
	}
}
