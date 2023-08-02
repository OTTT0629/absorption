package com.ottt.ottt.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.domain.PageResolver;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.CommentDTO;
import com.ottt.ottt.dto.ReviewDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.admin.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;

	//유저 정보 목록
	@GetMapping("/admin")
	public String mainAdmin(Model m, HttpServletRequest request, HttpSession session, SearchItem sc) {
		
		 try {
			int totalCnt = adminService.getCount(sc);
			m.addAttribute("totalCnt", totalCnt);
				
			PageResolver pageResolver =  new PageResolver(totalCnt, sc);
			List<UserDTO> userInfoList = adminService.getUserInfo(sc);
			m.addAttribute("userInfoList", userInfoList);
			m.addAttribute("pr", pageResolver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/admin/admin_user";
	}
	
	@PostMapping("/admin/user/block")
	public ResponseEntity<String> userBlock(@RequestParam("user_no") Integer user_no) {
	    try {
	        // userNo를 사용하여 필요한 로직을 수행
	    	if(adminService.blockUser(user_no) != 1)
	    		throw new Exception("Block failed");
	        // 처리가 성공한 경우
	        return ResponseEntity.ok("Block_OK");
	    } catch (Exception e) {
	        // 처리가 실패한 경우
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Block_ERR");
	    }
	}
	
	//유저 신고 목록
	@GetMapping("/admin/user")
	public String adminUser(Model m, HttpServletRequest request, HttpSession session, SearchItem sc) {
		 try {
			int totalCnt = adminService.getCount(sc);
			m.addAttribute("totalCnt", totalCnt);
				
			PageResolver pageResolver =  new PageResolver(totalCnt, sc);
			List<UserDTO> userReportList = adminService.getUserReport(sc);
			m.addAttribute("userReportList", userReportList);
			m.addAttribute("pr", pageResolver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/admin/admin_user_report";
	}
	
	//리뷰 신고 목록
	@GetMapping("/admin/review")
	public String AdminReview(Model m, HttpServletRequest request, HttpSession session, SearchItem sc) {
		
		 try {
			int totalCnt = adminService.getReviewCount(sc);
			m.addAttribute("totalCnt", totalCnt);
				
			PageResolver pageResolver =  new PageResolver(totalCnt, sc);
			List<ReviewDTO> reviewList = adminService.getReview(sc);
		 	m.addAttribute("reviewList", reviewList);
			m.addAttribute("pr", pageResolver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/admin/admin_review";
	}
	
	//리뷰 강제 삭제	
	@PostMapping("/admin/review/reviewDelete")
	public ResponseEntity<String> ReviewDEL(@RequestParam("review_no") Integer review_no) {
	    try {
	        // userNo를 사용하여 필요한 로직을 수행
	    	if(adminService.removeReview(review_no) != 1)
	    		throw new Exception("DEL failed");
	        // 처리가 성공한 경우
	        return ResponseEntity.ok("DEL_OK");
	    } catch (Exception e) {
	        // 처리가 실패한 경우
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DEL_ERR");
	    }
	}
	
	
	//게시글 신고 목록
	@GetMapping("/admin/article")
	public String AdminArticle(Model m, HttpServletRequest request, HttpSession session, SearchItem sc) {
		
		 try {
			int totalCnt = adminService.getArticleCount(sc);
			m.addAttribute("totalCnt", totalCnt);
				
			PageResolver pageResolver =  new PageResolver(totalCnt, sc);
			List<ArticleDTO> articleList = adminService.getArticle(sc);
			m.addAttribute("articleList", articleList);
			m.addAttribute("pr", pageResolver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/admin/admin_article";
	}
	
	//게시글 강제 삭제
	@PostMapping("/admin/article/articleDelete")
	public ResponseEntity<String> ArticleDEL(@RequestParam("article_no") Integer article_no) {
	    try {
	        // userNo를 사용하여 필요한 로직을 수행
	    	if(adminService.removeArticle(article_no) != 1)
	    		throw new Exception("DEL failed");
	        // 처리가 성공한 경우
	        return ResponseEntity.ok("DEL_OK");
	    } catch (Exception e) {
	        // 처리가 실패한 경우
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DEL_ERR");
	    }
	}
	
	
	//댓글 신고 목록
	@GetMapping("/admin/comment")
	public String AdminComment(Model m, HttpServletRequest request, HttpSession session, SearchItem sc) {
		
		 try {
			int totalCnt = adminService.getCommnetCount(sc);
			m.addAttribute("totalCnt", totalCnt);
				
			PageResolver pageResolver =  new PageResolver(totalCnt, sc);
			List<CommentDTO> commentList = adminService.getComment(sc);
			m.addAttribute("commentList", commentList);
			m.addAttribute("pr", pageResolver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/admin/admin_comment";
	}
	
	//댓글 강제 삭제
	@PostMapping("/admin/comment/commentDelete")
	public ResponseEntity<String> CommentDEL(@RequestParam("cmt_no") Integer cmt_no) {
	    try {
	        // userNo를 사용하여 필요한 로직을 수행
	    	if(adminService.removeComment(cmt_no) != 1)
	    		throw new Exception("DEL failed");
	        // 처리가 성공한 경우
	        return ResponseEntity.ok("DEL_OK");
	    } catch (Exception e) {
	        // 처리가 실패한 경우
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DEL_ERR");
	    }
	}
	
}
