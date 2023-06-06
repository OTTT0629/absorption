package com.ottt.ottt.controller.mypage.pageVar.record;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ottt.ottt.dao.user.UserDao;
import com.ottt.ottt.domain.PageResolver;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.review.ReviewService;

@Controller
@RequestMapping("/mypage")
public class ReviewController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ReviewService rs;
	
	//myreview 메인 
	@GetMapping(value = "/myreview")
	public String myreview(SearchItem sc, Model m, HttpSession session) {
		Integer user_no = (Integer) session.getAttribute("user_no");
		
		try {
			UserDTO userDTO = userDao.select(user_no);
			
			sc.setPageSize(3);
			sc.setUser(userDTO.getUser_nicknm());
			sc.setUser_no(user_no);
			
			int myReviewCnt = rs.myReviewCnt(sc);
			m.addAttribute("myReviewCnt", myReviewCnt);
			
			PageResolver pageResolver = new PageResolver(myReviewCnt,sc);
			
			List<ReviewDTO> list = rs.getMyReview(sc);
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);			
			
		} catch (Exception e) { e.printStackTrace(); }		
		
		
	return "/mypage/myprofile/myreview";		
	}
		
		
}
