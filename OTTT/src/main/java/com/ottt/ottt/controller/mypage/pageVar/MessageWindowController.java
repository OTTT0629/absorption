package com.ottt.ottt.controller.mypage.pageVar;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dto.MessageDTO;
import com.ottt.ottt.dto.NotificationDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.message.MessageService;
import com.ottt.ottt.service.mypage.NotificationService;

import software.amazon.ion.apps.PrintApp;

@Controller
@RequestMapping("/messagewindow")
public class MessageWindowController {
	
	@Autowired
	LoginUserDao loginUserDao;
	@Autowired
	MessageService messageService;
	@Autowired
	NotificationService notificationService;

	
	@GetMapping(value = "/open")
	public String open(Integer send_user_no, Integer user_no, Model m) {
		if(send_user_no != null) {
			UserDTO userDTO = loginUserDao.selectNo(send_user_no);
			m.addAttribute("userDTO", userDTO);
		} else {
			UserDTO userDTO = loginUserDao.selectNo(user_no);
			m.addAttribute("userDTO", userDTO);
		}
		return "/mypage/myprofile/messagewindow";
	}
	
	@PostMapping(value = "/send")
	@ResponseBody
	public ResponseEntity<String> writeMsg(@RequestParam("sendUserNo") int userNo,
											@RequestParam("content") String content,
											MessageDTO messageDTO, HttpSession session) {
		String writer = (String)session.getAttribute("id");
		UserDTO userDTO = loginUserDao.select(writer);

		messageDTO.setSend_user_no(userDTO.getUser_no());
		messageDTO.setContent(content);
		messageDTO.setReceive_user_no(userNo);

		messageDTO.setDelete_by_receiver(false);
		messageDTO.setDelete_by_sender(false);
		
		System.out.println("================================== setSend_user_no : " + userDTO.getUser_no() );
		System.out.println("================================== content : " + content );
		System.out.println("================================== setReceive_user_no : " + userNo);

		System.out.println("================================== messageDTO.getReceive_user_no() : " + messageDTO.getReceive_user_no() );
		System.out.println("================================== messageDTO.getSend_user_no() : " + messageDTO.getSend_user_no() );
		System.out.println("================================== messageDTO.getContent() : " + messageDTO.getContent());		
		
		try {			
			if(messageService.writeMsg(messageDTO) != 1) {
				throw new Exception("Send failed");
			}
			
			//알림함에 알림 집어넣기
		    NotificationDTO notificationDTO = new NotificationDTO();
		    notificationDTO.setUser_no(messageDTO.getSend_user_no());
		    notificationDTO.setTarget_user_no(messageDTO.getReceive_user_no());
		    messageDTO.setUser_nicknm(userDTO.getUser_nicknm());
		    
	    System.out.println("========================================================= setUser_nicknm: " + messageDTO.getUser_nicknm());
		    notificationService.putMessage(notificationDTO);
			return new ResponseEntity<String>("Send_OK", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Send_ERR", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/send2")
	@ResponseBody
	public ResponseEntity<String> writeMsg2(@RequestParam("userNo") int userNo,
											@RequestParam("content") String content,
											MessageDTO messageDTO, HttpSession session) {
		String writer = (String)session.getAttribute("id");
		UserDTO userDTO = loginUserDao.select(writer);

		messageDTO.setSend_user_no(userDTO.getUser_no());
		messageDTO.setContent(content);
		messageDTO.setReceive_user_no(userNo);

		messageDTO.setDelete_by_receiver(false);
		messageDTO.setDelete_by_sender(false);
		
		System.out.println("================================== setSend_user_no : " + userDTO.getUser_no() );
		System.out.println("================================== content : " + content );
		System.out.println("================================== setReceive_user_no : " + userNo);

		System.out.println("================================== messageDTO.getReceive_user_no() : " + messageDTO.getReceive_user_no() );
		System.out.println("================================== messageDTO.getSend_user_no() : " + messageDTO.getSend_user_no() );
		System.out.println("================================== messageDTO.getContent() : " + messageDTO.getContent());		
		
		try {			
			if(messageService.writeMsg(messageDTO) != 1) {
				throw new Exception("Send failed");
			}
			
			//알림함에 알림 집어넣기
		    NotificationDTO notificationDTO = new NotificationDTO();
		    notificationDTO.setUser_no(messageDTO.getSend_user_no());
		    notificationDTO.setTarget_user_no(messageDTO.getReceive_user_no());
		    
		    System.out.println("========================messageDTO.getMessage_no(): " + messageDTO.getMessage_no());
		    messageDTO.setUser_nicknm(userDTO.getUser_nicknm());

		    notificationService.putMessage(notificationDTO);
			
			return new ResponseEntity<String>("Send_OK", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Send_ERR", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
}
