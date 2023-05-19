package com.ottt.ottt.controller.community;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.bytecode.AccessFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.dao.community.communityDao;
import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.community.CommunityService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/community")
public class CommunityController {
	
	@Autowired
	CommunityService communityService;
	@Autowired
	LoginUserDao loginUserDao;


	
	
	//freecommunity 메인
	@GetMapping("/freecommunity")
	public String freecommunity(Model m, HttpServletRequest request, String toURL) {
		//if(!loginCheck(request))
			//return "redirect:/login/login?toURL="+request.getRequestURL();		
	try {
		 List<ArticleDTO> list = communityService.showAllPage();
	        m.addAttribute("list", list);		
	} catch (Exception e) {e.printStackTrace();}
	return "/community/freecommunity/community_main";		
	}
	

	@PostMapping("/freecommunity")
	public String freecommunity_post(@Valid ArticleDTO articleDTO, HttpServletRequest request, Model m) {
		
		try {

			HttpSession session = request.getSession();
			String trimmedContent = articleDTO.getArticle_content();
			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
        	if (userDTO == null) {	   
        		throw new Exception("로그인이 필요합니다.");
	        }
        	if(!trimmedContent.isEmpty()) {
	        	articleDTO.setUser_no(userDTO.getUser_no());
	        	communityService.write(articleDTO);	        		
        	}

		} catch (Exception e) {e.printStackTrace();}
				
		return "redirect:/community/freecommunity";
	}
	
	//community 글 자세히보기
	@GetMapping(value = "/post")
	public String freecommunityPost(Integer article_no, Model m ) {
		
		try {
			ArticleDTO articleDTO = communityService.read(article_no);
			m.addAttribute("articleDTO", articleDTO);
			UserDTO userDTO = loginUserDao.selectNo(articleDTO.getUser_no());
			m.addAttribute("userDTO", userDTO);
			m.addAttribute("mode", "view");
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/community";
			}

			return "/community/freecommunity/community_post";		
	}

	
	//community 글 수정모드로 진입
	@GetMapping(value = "/updatePost")
	public String freecommunityUpdatePost(Integer article_no, Model m ) {

		try {
			ArticleDTO articleDTO = communityService.read(article_no);
			m.addAttribute("articleDTO", articleDTO);
			UserDTO userDTO = loginUserDao.selectNo(articleDTO.getUser_no());
			m.addAttribute("userDTO", userDTO);
			m.addAttribute("mode", "update");
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/community";
		}

		return "/community/freecommunity/community_post";		

	}
	
	//수정하기
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String freecommunitUpdate(ArticleDTO articleDTO, HttpServletRequest request, Model m, Integer article_no, String article_content,RedirectAttributes rattr) {
			
		String returnUrl = "";
		
		try {

			HttpSession session = request.getSession();

			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
        	
			if (userDTO == null) {	   
        		throw new Exception("로그인이 필요합니다.");
	        }
			
        	articleDTO.setUser_no(userDTO.getUser_no());
		
			if(communityService.modify(articleDTO) > 0) {
				returnUrl =  "redirect:/community/post?mode=view&article_no="+articleDTO.getArticle_no();
			}else {
				returnUrl =  "redirect:/community";
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/community";
		}
		
		return returnUrl;
		
	}
	
	
	//삭제하기
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Locale locale, Model m, Integer article_no) throws Exception{

		//정상적으로 수정 및 삭제를하면 마이바티스에서 1을 반환한다. 
		if(communityService.remove(article_no) == 1) {	//숫자 1이면 정상처리
			return "redirect:/community/freecommunity";
		}else {
			return "redirect:/community/freecommunity";
		}

	}
	
	

	
	private boolean loginCheck(HttpServletRequest request) {
		 //1. 세션을 얻어 (false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		 //2. 세션에 id가 있는지 확인, 있으면 true를 반환 
		return session != null && session.getAttribute("id")!=null;
	}
	
	
}




	




















