package com.ottt.ottt.controller.mypage.pageVar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dto.NotificationDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.mypage.NotificationService;

@Controller
@RequestMapping("/mypage")
public class NotificationController {

	@Autowired
	NotificationService notificationService;
	@Autowired
	LoginUserDao loginUserDao;

	@GetMapping(value = "/alarm")
	public String alarm(Model m, HttpSession session) {
		String userId = (String) session.getAttribute("id");
		UserDTO userDTO = loginUserDao.select(userId);
		m.addAttribute("userDTO", userDTO);

		try {
			List<NotificationDTO> list = notificationService.getNotiList(userDTO.getUser_no());
			int notiCnt = notificationService.notificationCnt(userDTO.getUser_no());

			m.addAttribute("notiCnt", notiCnt);
			m.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/mypage/myprofile/notification";
	}
	
	@PostMapping(value = "/deleteNotification")
	public ResponseEntity<Map<String, Object>> deleteNotification(@RequestParam("notiNo") int notiNo, HttpSession session, Model m) {
	    Map<String, Object> result = new HashMap<>();
	    UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));

	    if (userDTO != null) {
	    	
	        try {
	            int rowCnt = notificationService.removeNoti(notiNo, userDTO.getUser_no());

	            if (rowCnt > 0) {
	                result.put("success", true);
	                result.put("message", "알림이 삭제되었습니다.");
	                return ResponseEntity.ok(result);
	            } else {
	                result.put("success", false);
	                result.put("message", "알림 삭제에 실패했습니다.");
	                return ResponseEntity.badRequest().body(result);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else {
	        result.put("success", false);
	        result.put("message", "로그인이 필요합니다.");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
	    }
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}
	
	
}