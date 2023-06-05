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

import com.ottt.ottt.dao.user.UserDao;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ContentDTO;
import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.content.ContentService;
import com.ottt.ottt.service.review.ReviewLikeService;
import com.ottt.ottt.service.review.ReviewService;

@Controller
public class DetailController {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	ReviewLikeService reviewLikeService;
	@Autowired
	UserDao userDAO;
	@Autowired
	ContentService cs;
	
	
	@GetMapping(value = "/detailPage")
	public String workDetailPage(Model m, HttpSession session, HttpServletRequest request
									, SearchItem sc, Integer content_no) {
		
		Integer user_no = (Integer) session.getAttribute("user_no");
		
		if(user_no != null) {
			UserDTO userDTO;
			try {
				userDTO = userDAO.select(user_no);
				m.addAttribute(userDTO);
				
			} catch (Exception e) { e.printStackTrace(); } 
		}
			
		try {
			
			List<ReviewDTO> list = reviewService.getReview();

			int count = reviewService.getCount();
			double rating = reviewService.getRatingAvg();
			
			m.addAttribute("rating", rating);
	        request.setAttribute("rating", rating);
	        System.out.println(rating);
			ReviewDTO myReview = reviewService.getReviewNo(1, user_no);		
			
			m.addAttribute("list", list);
			m.addAttribute("count", count);
			m.addAttribute("myReview", myReview);
		} catch (Exception e) {
						
			e.printStackTrace();
		}
		
		try {
			
			ContentDTO contentDTO = cs.getContent(content_no);
			m.addAttribute(contentDTO);
		  
		  } catch (Exception e) {
			  
			  e.printStackTrace();
			  return "redirect:/";
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
	
	
	@PostMapping("/modify")
	   public String modifyReview(ReviewDTO reviewDTO, RedirectAttributes rattr, Model m, HttpSession session) {
	      Integer user_no = (Integer) session.getAttribute("user_no");
	      
	      
	      
	      
	      try {
	         Integer review_no = reviewDTO.getReview_no();
	               //reviewService.getReviewNo(reviewDTO);
	         //Integer review_no = reviewno.getReview_no();
	         m.addAttribute("review_no", review_no);
	         m.addAttribute("user_no",user_no);
	         if(reviewService.modifyReview(reviewDTO) != 1)
	            throw new Exception("Modify failed");
	         
	         
	         rattr.addFlashAttribute("msg", "MOD_OK");
	         return "redirect:/detailPage";
	      } catch (Exception e) {
	         e.printStackTrace();
	         m.addAttribute("reviewDTO", reviewDTO);
	         m.addAttribute("msg", "MOD_ERR");
	         return "redirect:/detailPage";
	      }
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
	
	
	
	
	
	

	
	
}
