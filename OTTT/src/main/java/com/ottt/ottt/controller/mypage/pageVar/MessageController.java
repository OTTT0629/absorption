package com.ottt.ottt.controller.mypage.pageVar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.dao.user.UserDao;
import com.ottt.ottt.domain.MessagePageResolver;
import com.ottt.ottt.domain.MessageSearchItem;
import com.ottt.ottt.dto.MessageDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.message.MessageService;

@Controller
@RequestMapping("/mypage")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	@Autowired
	LoginUserDao loginUserDao;
	
	@GetMapping(value = "/message")
	public String message(MessageSearchItem msc, Model m, HttpSession session) {
		try {
			
			UserDTO userDTO = loginUserDao.select((String) session.getAttribute("id"));
			m.addAttribute("userDTO", userDTO);
			msc.setUser_no(userDTO.getUser_no());
			
			int totalCnt = messageService.getRecvResultCnt(msc);
			
			m.addAttribute("totalCnt", totalCnt);
			MessagePageResolver msgPageResolver = new MessagePageResolver(totalCnt, msc);
			
			List<MessageDTO> list = messageService.loadRecvList(msc);
			
			m.addAttribute("list", list);
			m.addAttribute("mpr", msgPageResolver);

		} catch (Exception e) {e.printStackTrace();}
		return "/mypage/myprofile/message";
	}

//	쪽지함에 넣음
//	@GetMapping(value = "/message/recv")
//	public String recvMessage(MessageSearchItem msc, Model m, HttpSession session) {
//		try {
//			
//			UserDTO userDTO = loginUserDao.select((String) session.getAttribute("id"));
//			m.addAttribute("userDTO", userDTO);
//			msc.setUser_no(userDTO.getUser_no());
//			
//			int totalCnt = messageService.getSearchResultCnt(msc);
//			
//			m.addAttribute("totalCnt", totalCnt);
//			MessagePageResolver msgPageResolver = new MessagePageResolver(totalCnt, msc);
//			
//			List<MessageDTO> list = messageService.loadRecvList(msc);
//			
//			m.addAttribute("list", list);
//			m.addAttribute("mpr", msgPageResolver);
//
//		} catch (Exception e) {e.printStackTrace();}
//		return "/mypage/myprofile/message";
//	}
	
	@GetMapping(value = "/message/send")
	public String sendMessage(MessageSearchItem msc, Model m, HttpSession session) {
		try {
			UserDTO userDTO = loginUserDao.select((String)session.getAttribute("id"));
			m.addAttribute("userDTO", userDTO);
			msc.setUser_no(userDTO.getUser_no());
			
			int totalCnt = messageService.getSendResultCnt(msc);
			
			m.addAttribute("totalCnt", totalCnt);
			MessagePageResolver msgPageResolver = new MessagePageResolver(totalCnt, msc);
			
			List<MessageDTO> list = messageService.loadSendList(msc);
			
			m.addAttribute("list", list);
			m.addAttribute("mpr", msgPageResolver);
			
		} catch (Exception e) {e.printStackTrace();}
		return "/mypage/myprofile/message";
	}
	
	
	
	//쪽지 삭제(해당 쪽지)
	@PostMapping("/message/remove")
	public String removeMsg() {
		
		return null;
	}
	
	//쪽지 전체 삭제
	@PostMapping("/message/removeall")
	public String removeMsgAll() {
		
		return null;
	}
	
	//유저 프로필 선택 시 그 사람 마이페이지로 넘어가게 하는 ?? 기능??

	//쪽지함 환경설정
	@GetMapping(value = "/messagesetting")
	public String messagesetting() {
		return "/mypage/myprofile/message_set";
	}
	
}
