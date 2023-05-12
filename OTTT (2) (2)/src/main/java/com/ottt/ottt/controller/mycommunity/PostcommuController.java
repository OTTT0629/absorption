package com.ottt.ottt.controller.mycommunity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.service.community.CommunityService;

@Controller
@RequestMapping("/mycommynity")
public class PostcommuController {
	
	@Autowired
	CommunityService communityService;
	@Autowired
	LoginUserDao loginUserDao;

	//내가 작성한 게시글 보기 
	@GetMapping("/postcommu")
	public String postcommu(Model m, HttpServletRequest request, String toURL) {
		//if(!loginCheck(request))
			//return "redirect:/login/login?toURL="+request.getRequestURL();		
	try {
		 List<ArticleDTO> articleList = communityService.showAllPage();
	        m.addAttribute("articleList", articleList);		
	} catch (Exception e) {e.printStackTrace();}
	return "/community/freecommunity/mypost_collection";		
	}





	private boolean loginCheck(HttpServletRequest request) {
		 //1. 세션을 얻어 (false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		 //2. 세션에 id가 있는지 확인, 있으면 true를 반환 
		return session != null && session.getAttribute("id")!=null;
	}

}
