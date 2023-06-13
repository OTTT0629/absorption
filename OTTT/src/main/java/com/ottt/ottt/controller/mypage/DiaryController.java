package com.ottt.ottt.controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.dao.user.UserDao;
import com.ottt.ottt.domain.PageResolver;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.MyDiaryDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.mypage.MyDiaryService;

@Controller
@RequestMapping("/mypage")
public class DiaryController {

	@Autowired
	UserDao userDao;

	@Autowired
	MyDiaryService ds;

	// mydiary 메인
	@GetMapping(value = "/mydiary")
	public String mydiary(SearchItem sc, Model m, HttpSession session, HttpServletRequest request) {

		if (!loginCheck(request))
			return "redirect:/login";

		Integer user_no = (Integer) session.getAttribute("user_no");

		try {
			UserDTO userDTO = userDao.select(user_no);

			sc.setPageSize(3);
			sc.setUser(userDTO.getUser_nicknm());
			sc.setUser_no(user_no);

			int myDiaryCnt = ds.myDiaryCnt(sc);
			m.addAttribute("myDiaryCnt", myDiaryCnt);

			PageResolver pageResolver = new PageResolver(myDiaryCnt, sc);

			List<MyDiaryDTO> list = ds.getMyDiary(sc);
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/mypage/myprofile/mydiary";
	}

	// mydiary 클릭 시(작성글 보기)
	@PostMapping(value = "/mydiary/diary")
	public String readdiary(Integer content_no, Integer user_no, SearchItem sc
							, HttpSession session, Model m, RedirectAttributes rattr) {
		
		Integer my_no = (Integer) session.getAttribute("user_no");
		
		sc.setPageSize(3);

		try {
			MyDiaryDTO myDiaryDTO = ds.getDiary(content_no, user_no);
			m.addAttribute(myDiaryDTO);
			char pub_stat = myDiaryDTO.getPublic_yn_cd();

			if (!my_no.equals(user_no) && pub_stat != '1')
				rattr.addFlashAttribute("msg", "READ_ERR");			

			return "/mypage/myprofile/diary";

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/mypage/mydiary";
		}
	}

	@PostMapping("/mydiary/modify")
	public String modDiary(MyDiaryDTO myDiaryDTO, SearchItem sc
						, RedirectAttributes rattr, Model m, HttpSession session) {
		
		sc.setPageSize(3);

		Integer user_no = (Integer) session.getAttribute("user_no");
		myDiaryDTO.setUser_no(user_no);

		try {

			if (ds.modDiary(myDiaryDTO) != 1)
				throw new Exception("Modify failed");

			rattr.addFlashAttribute("msg", "MOD_OK");
			//return "redirect:/mypage/mydiary/diary"+sc.getString();
			return "forward:/mypage/mydiary/diary"+sc.getString();

		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("myDiaryDTO", myDiaryDTO);
			m.addAttribute("page", sc.getPage());
			m.addAttribute("pageSize", sc.getPageSize());
			m.addAttribute("user", sc.getUser());
			m.addAttribute("msg", "MOD_ERR");
			return "/mypage/myprofile/mydiary";
		}

	}
	
	@PostMapping("/mydiary/remove")
	public String rmvDiary (MyDiaryDTO myDiaryDTO, SearchItem sc
			, RedirectAttributes rattr, Model m, HttpSession session) {
		Integer user_no = (Integer) session.getAttribute("user_no");
		System.out.println("====================================== remove 진입 ");
		System.out.println("====================================== myDiaryDTO.toString() : " + myDiaryDTO.toString());
		System.out.println("====================================== user_no " + user_no);
		System.out.println("====================================== myDiaryDTO.getUser_no() " + myDiaryDTO.getUser_no());
		
		if(user_no.equals(myDiaryDTO.getUser_no()) ) {
			System.out.println("====================================== if 진입 ");
			try {
				if(ds.remove(myDiaryDTO.getContent_no(), user_no) != 1)
					throw new Exception("Delete failed");	
				
			} catch (Exception e) {
				e.printStackTrace();
				rattr.addFlashAttribute("msg", "DEL_ERR");
				return "forward:/mypage/mydiary/diary"+sc.getString();
			}
			
			rattr.addAttribute("page", sc.getPage());
			rattr.addAttribute("pageSize", sc.getPageSize());
			rattr.addFlashAttribute("msg", "DEL_OK");
		}
		
		return "redirect:/mypage/mydiary";
	}

	// mydiary 글작성
	@GetMapping(value = "/mydiary/create")
	public String diarycreate() {
		return "/mypage/myprofile/diary2";
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어 (false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환
		return session != null && session.getAttribute("id") != null;
	}
}
