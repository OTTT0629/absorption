package com.ottt.ottt.controller.mypage.pageVar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.domain.MessageSearchItem;
import com.ottt.ottt.dto.MessageDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.message.MessageService;
import com.ottt.ottt.service.message.MessageServiceImpl;

@Controller
@RequestMapping("/messagewindow")
public class MessageWindowController {
	
	@Autowired
	LoginUserDao loginUserDao;
	MessageService messageService;
	MessageServiceImpl messageServiceImpl;
	
	
	@GetMapping(value = "/open")
	public String open(MessageSearchItem msc, Model m, HttpSession session) {
		UserDTO userDTO = loginUserDao.select((String) session.getAttribute("id"));
		m.addAttribute("userDTO", userDTO);
		msc.setUser_no(userDTO.getUser_no());
		
		return "/mypage/myprofile/messagewindow";
	}
	
	@PostMapping(value = "/open")
	public String writeMsg(MessageDTO messageDTO, RedirectAttributes rattr, Model m, HttpSession session) {
		String writer = (String)session.getAttribute("id");
		UserDTO userDTO = loginUserDao.select(writer);
		messageDTO.setSend_user_no(userDTO.getUser_no());
		
		try {
			if(messageServiceImpl.writeMsg(messageDTO) != 1) {
				throw new Exception("Send failed");
			}
			rattr.addFlashAttribute("msg", "SEND_OK");
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("messageDTO", messageDTO);	//등록하려던 내용을 보여줘야함
			m.addAttribute("msg", "SEND_ERROR");
			return "/mypage/myprofile/messagewindow";
		}
	}
}
