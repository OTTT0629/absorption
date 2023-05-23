package com.ottt.ottt.controller.workDetailPage;

<<<<<<< HEAD
=======
import java.sql.Timestamp;
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
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
<<<<<<< HEAD
=======
import com.ottt.ottt.dto.ReviewLikeDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.review.ReviewLikeService;
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
import com.ottt.ottt.service.review.ReviewService;

@Controller
public class DetailController {
	@Autowired
	private ReviewService reviewService;
<<<<<<< HEAD
	
	@GetMapping(value = "/detailPage")
	public String workDetailPage(Model m, HttpServletRequest request) {
		
		try {
			List<ReviewDTO> list = reviewService.getReview();
			int count = reviewService.getCount();
			
			m.addAttribute("list", list);
			m.addAttribute("count", count);
			
=======
	private ReviewLikeService reviewLikeService;
	
	
	@GetMapping(value = "/detailPage")
	public String workDetailPage(Model m, HttpServletRequest request, HttpSession session, Integer review_no, Integer user_no) {         //, Integer content_no) 

		
		
		
		ReviewLikeDTO like = new ReviewLikeDTO();
		
		like.setReview_no(review_no);
		like.setUser_no(user_no);
		
		
		user_no = (Integer) session.getAttribute("user_no");
			
		try {
			
			List<ReviewDTO> list = reviewService.getReview();

			int count = reviewService.getCount();
			
			
			
			
			m.addAttribute("list", list);
			m.addAttribute("count", count);
			m.addAttribute("like", reviewLikeService.getReviewLikeYN(review_no, user_no));
			m.addAttribute("getLike", reviewLikeService.getReviewCount(review_no));
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
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
<<<<<<< HEAD
=======
			
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
			if(reviewService.writeReview(reviewDTO)!=1) {
				throw new Exception("error");
			}
			attr.addFlashAttribute("msg", "fail");
			
			return "redirect:/detailPage"; 
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "ok");
<<<<<<< HEAD
			return "/workDetailPage/workdetailpage";
=======
			
			
			return "/workDetailPage/workdetailpage";
			
			
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		}
		
		
	}
	
	
<<<<<<< HEAD
=======
	@PostMapping("/remove")
	public String remove(Integer review_no,RedirectAttributes rattr, HttpSession session, Model m) {
		int user_no = (int) session.getAttribute("user_no");
		
		
		String msg = "DEL_OK";
		
		try {
			if(reviewService.removeReview(review_no, user_no) !=1)
			throw new Exception("Delete failed.");
		} catch (Exception e) {
			e.printStackTrace();
			msg = "DEL_ERR";
		}

		rattr.addFlashAttribute("msg", msg);
		
		
		
		return "redirect:/detailPage";
	}
	
	
	@GetMapping("/like")
	public String getReviewLikeCnt(Integer review_no, Integer user_no, Model m) {
		reviewLikeService.getReviewLikeYN(review_no, user_no);

		

		
		
	        
			m.addAttribute("Detail", reviewLikeService.getReviewLikeYN(review_no, user_no));
			m.addAttribute("getLike", reviewLikeService.getReviewCount(review_no));

			
			
		return "/detailPage";
	}
	
	
	
	@PostMapping("/detailPage/likeUp")
	public void likeUp(Integer review_no, Integer user_no, Model m) {
		reviewLikeService.addLike(review_no, user_no);
		m.addAttribute("likeUp", reviewLikeService.addLike(review_no, user_no));
		
		
	}
	
	
	@PostMapping("/detailPage/likeDown")
	public void likeDown(Integer review_no, Integer user_no, Model m) {
		reviewLikeService.removeLike(review_no, user_no);
		m.addAttribute("likeDown", reviewLikeService.removeLike(review_no, user_no));
		
	}
	
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
	
	
	
	
	

	
	
}
