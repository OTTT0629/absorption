package com.ottt.ottt.controller.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.CommentDTO;
import com.ottt.ottt.dto.NotificationDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.community.freecomuity.CommentService;
import com.ottt.ottt.service.community.freecomuity.CommunityService;
import com.ottt.ottt.service.mypage.NotificationService;


@RestController
//@RestController란? 비동기 통신용 컨트롤러, model OR view를 리턴하지 않는다.
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommunityService communityService;
	
	@Autowired
	CommentService commentService;

	@Autowired
	LoginUserDao loginUserDao;
	
	@Autowired
	NotificationService notificationService;

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	//댓글 목록 조회
	@PostMapping("/getCommentList")
	public List<CommentDTO> getCommentList(CommentDTO dto, HttpSession session) throws Exception {
		
		logger.info("/comment/getCommentList >>>>>> 호출 ");
		UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
		if(userDTO != null) {
			dto.setUser_no(userDTO.getUser_no());
		}
		return commentService.getCommentList(dto);
	}
	
	//댓글 저장
	@PostMapping("/insertComment")
	public Map<String,Object> insertComment(CommentDTO dto, HttpSession session, Integer user_no) throws Exception {
		
		logger.info("/comment/insertComment >>>>>> 호출 ");
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));

		if(userDTO != null) {
			dto.setUser_no(userDTO.getUser_no());
			dto.setCmt_writer(userDTO.getUser_nicknm());
		}else {
			logger.info("로그인이 필요합니다.");	//추후 예외처리
		}
		
		if(commentService.insertComment(dto) > 0) {
			result.put("result", 1);
			result.put("message", "댓글이 등록되었습니다.");
		}else {
			result.put("result", 0);
			result.put("message", "댓글등록에 실패했습니다. 다시 시도해주세요.");			
		}
		
		//알림함에 알림 집어넣기
		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setArticle_no(dto.getArticle_no());
		
		System.out.println("======================user_no: " + user_no);
		System.out.println("======================(Integer)session.getAttribute(\"user_no\"): " + (Integer)session.getAttribute("user_no"));
		if(!user_no.equals(session.getAttribute("user_no"))) {
			ArticleDTO articleNo = communityService.select(articleDTO);
			if(articleDTO != null) {
				NotificationDTO notificationDTO = new NotificationDTO();
				notificationDTO.setUser_no(dto.getUser_no());
				notificationDTO.setArticle_no(articleDTO.getArticle_no());
				notificationDTO.setTarget_user_no(articleNo.getUser_no());
				
			    String currentURL = "/community/post?article_no=" + dto.getArticle_no();
			    notificationDTO.setNoti_url(currentURL);
				
				notificationService.putArticleCmt(notificationDTO);
			}
		}
		return result;
	}
	
	//댓글 삭제
	@PostMapping("/deleteComment")
	public Map<String,Object> deleteComment(CommentDTO dto, HttpSession session) throws Exception {

		logger.info("/comment/deleteComment >>>>>> 호출 ");
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		if(commentService.deleteComment(dto.getCmt_no()) > 0) {
			result.put("result", 1);
			result.put("message", "삭제되었습니다.");
		}else {
			result.put("result", 0);
			result.put("message", "삭제되지 않았습니다. 다시 시도해주세요.");			
		}
		
		return result;
	}

	//댓글 수정
	@PostMapping("/updateComment")
	public Map<String,Object> updateComment(CommentDTO dto, HttpSession session) throws Exception {
		
		logger.info("/comment/updateComment >>>>>> 호출 ");
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));

		if(userDTO != null) {
			dto.setUser_no(userDTO.getUser_no());
			dto.setCmt_writer(userDTO.getUser_nicknm());
		}else {
			logger.info("로그인이 필요합니다.");	//추후 예외처리
		}
		
		if(commentService.updateComment(dto) > 0) {
			result.put("result", 1);
			result.put("message", "수정되었습니다.");
		}else {
			result.put("result", 0);
			result.put("message", "댓글수정에 실패했습니다. 다시 시도해주세요.");			
		}
		return result;
	}
	
}
