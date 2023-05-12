package com.ottt.ottt.controller.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.bytecode.AccessFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.community.CommunityService;

import jakarta.validation.Valid;

@Controller
public class CommunityController {
	
	@Autowired
	CommunityService communityService;
	@Autowired
	LoginUserDao loginUserDao;

	
	
	//freecommunity 메인
	@GetMapping("/community")
	public String freecommunity(Model m, HttpServletRequest request, String toURL) {
		//if(!loginCheck(request))
			//return "redirect:/login/login?toURL="+request.getRequestURL();		
	try {
		 List<ArticleDTO> list = communityService.showAllPage();
	        m.addAttribute("list", list);		
	} catch (Exception e) {e.printStackTrace();}
	return "/community/freecommunity/community_main";		
	}
	

	@PostMapping("/community")
	public String freecommunity_post(@Valid ArticleDTO articleDTO, HttpServletRequest request, Model m) {
	
		try {
			HttpSession session = request.getSession();
			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
	        	if (userDTO == null) {
	        		throw new RuntimeException("로그인이 필요합니다.");
	        }
	        	articleDTO.setUser_no(userDTO.getUser_no());
	        	communityService.write(articleDTO);
			} catch (Exception e) {e.printStackTrace();}
			return "redirect:/community";
		}

	
	//community 글 자세히보기
	@GetMapping(value = "/community/post")
	public String freecommunityPost(Integer article_no, Model m ) {
		try {
			ArticleDTO articleDTO = communityService.read(article_no);
			m.addAttribute("articleDTO", articleDTO);
			UserDTO userDTO = loginUserDao.selectNo(articleDTO.getUser_no());
			m.addAttribute("userDTO", userDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/community";
			}

			return "/community/freecommunity/community_post";		
	}
	
	
	

	
	

	
	private boolean loginCheck(HttpServletRequest request) {
		 //1. 세션을 얻어 (false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		 //2. 세션에 id가 있는지 확인, 있으면 true를 반환 
		return session != null && session.getAttribute("id")!=null;
	}
	
	
}




	




















