package com.ottt.ottt.controller.mypage.pageVar.record;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ottt.ottt.dao.user.UserDao;
import com.ottt.ottt.domain.PageResolver;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.MyDiaryDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.mypage.MyDiaryService;

@Controller
@RequestMapping("/mypage")
public class DiaryController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MyDiaryService ds;
	
	
	//mydiary 메인 
	@GetMapping(value = "/mydiary")
	public String mydiary(SearchItem sc, Model m, HttpSession session) {
		Integer user_no = (Integer) session.getAttribute("user_no");
		
		try {
			UserDTO userDTO = userDao.select(user_no);
			
			sc.setPageSize(3);
			sc.setUser(userDTO.getUser_nicknm());
			sc.setUser_no(user_no);
			
			int myDiaryCnt = ds.myDiaryCnt(sc);
			m.addAttribute("myDiaryCnt", myDiaryCnt);
			
			PageResolver pageResolver = new PageResolver(myDiaryCnt,sc);
			
			List<MyDiaryDTO> list = ds.getMyDiary(sc);
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);			
			
		} catch (Exception e) { e.printStackTrace(); }		
		
		return "/mypage/myprofile/mydiary";		
	}
	
	//mydiary 클릭 시(작성글 보기)
	@PostMapping(value = "/mydiary/diary")
	public String readdiary() {
		
		
		
	return "/mypage/myprofile/diary";		
	}
	
	//mydiary 글작성
	@GetMapping(value = "/mydiary/create")
	public String diarycreate() {
	return "/mypage/myprofile/diary2";		
	}
}
