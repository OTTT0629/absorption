package com.ottt.ottt.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ottt.ottt.dto.ContentCategoryDTO;
import com.ottt.ottt.dto.ContentDTO;
import com.ottt.ottt.service.home.ContentCategoryService;
import com.ottt.ottt.service.home.ContentCategoryServiceImpl;
import com.ottt.ottt.service.home.ContentService;
import com.ottt.ottt.service.home.ContentServiceImpl;



@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired 
	ContentServiceImpl contentServiceImpl;
	@Autowired
	ContentCategoryServiceImpl categoryServiceImpl;

	@GetMapping(value = "/")
	public String home(Model m) {	
		
		try {
			List<ContentDTO> list = contentServiceImpl.getRating();
			m.addAttribute("list", list);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return "home";
	}
}