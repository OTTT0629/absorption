package com.ottt.ottt.controller.workDetailPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.service.review.ReviewService;

@Controller
public class DetailController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping(value = "/detailPage")
	public String workDetailPage(Model m, HttpServletRequest request) {
		
		try {
			List<ReviewDTO> list = reviewService.getReview();
			int count = reviewService.getCount();
			
			m.addAttribute("list", list);
			m.addAttribute("count", count);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return "/workDetailPage/workdetailpage";
	}
	
//	@GetMapping(value = "/detailPage/review")
//	public String workReview() {
//			return "/workDetailPage/review";		
//	}
//	

	@PostMapping(value = "/detailPage")
	public String write(ReviewDTO reviewDTO, Model m, RedirectAttributes attr, HttpSession session) {
	    
		try {
			if(reviewService.writeReview(reviewDTO)!=1) {
				throw new Exception("error");
			}
			attr.addFlashAttribute("msg", "fail");
			
			return "redirect:/detailPage"; 
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "ok");
			return "/workDetailPage/workdetailpage";
		}
		
		
	}
	
	
	
	
	
	
	

	
	
}
