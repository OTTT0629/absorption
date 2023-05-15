package com.ottt.ottt.controller.workDetailPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.service.review.ReviewService;

@Controller
public class DetailReviewController {

	@Autowired
	ReviewService reviewService;
	
	@GetMapping(value = "/detailPage/review")
	public String workReview(Model m, HttpServletRequest request) {
		
		try {
			List<ReviewDTO> list = reviewService.getReview();
			int count = reviewService.getCount();
			m.addAttribute("list", list);
			m.addAttribute("count", count);
		} catch (Exception e) {	e.printStackTrace();}
		
			return "/workDetailPage/review";		
	}
	
	@PostMapping("/detailPage/review/write")
	public String writeReview(ReviewDTO reviewDTO, RedirectAttributes rattr,
							Model m, HttpSession session) {		
		try {
			if(reviewService.writeReview(reviewDTO) != 1) {
				throw new Exception("Write failed");
			}
			return "redirect:/detailPage/review";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "workDetailPagereview";
		}
	
	
	}
	
}
