package com.ottt.ottt.controller.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.domain.NaverLoginBO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.handler.KakaoApiHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	LoginUserDao userDao;
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	/* KakaoHandler*/
	@Autowired
	private KakaoApiHandler kakaoApiHandler;	
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	//로그인 페이지
	@GetMapping(value = "/login")
	public String login(String toURL) {
		System.out.println("==========login=============== toURL : " + toURL);
		
	return "/login/loginForm";		
	}
	
	@PostMapping("/login")
	public String login(String user_id, String user_pwd, String toURL, boolean rememberId,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		if(!loginCheck(user_id, user_pwd)) {
		UserDTO user = userDao.select(user_id);
		if (user != null && user.getBlock_yn()) {
			String msg = URLEncoder.encode("정지된 회원입니다.", "utf-8");
			return "redirect:/login?msg=" + msg;
		}
		String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다", "utf-8");
		return "redirect:/login?msg="+msg;
		}

		if(rememberId) {
		Cookie cookie = new Cookie("id", user_id);
		response.addCookie(cookie);
		}
		else {
		Cookie cookie = new Cookie("id", user_id);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		}

		UserDTO userDTO = userDao.select(user_id);		
		HttpSession session = request.getSession();
		session.setAttribute("id", user_id);
		session.setAttribute("admin", userDTO.getAdmin());
		session.setAttribute("user_no", userDTO.getUser_no());
		session.setAttribute("user_nicknm", userDTO.getUser_nicknm());
		session.setAttribute("user_img", userDTO.getImage());
		
		System.out.println("==========login post=============== toURL : " + toURL);

		toURL = (toURL == null || toURL.equals("") || toURL.equals("null")) ? "/" : toURL;
				
		String encodedURL = URLEncoder.encode(toURL, "UTF-8")
				.replace("%2F", "/")
				.replace("%3A", ":")
				.replace("%3F", "?")
				.replace("%26", "&")
		        .replace("%3D", "=");
		
		System.out.println("==========encode=============== toURL : " + toURL);
		return "redirect:" + encodedURL;
	}
	
	private boolean loginCheck(String id, String pwd) {
		UserDTO user = userDao.select(id);
		if(user == null) return false;
		if (user.getBlock_yn()) return false; 
		return user.getUser_pwd().equals(pwd);
	}
	
	// 로그아웃 +(카카오 로그아웃 추가)
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		String access_token = (String) session.getAttribute("kakaoToken");

		if (!"".equals(access_token) && access_token != "" && access_token != null) {

			logger.info("=== logout > access_token : {}", access_token);

			Map<String, String> map = new HashMap<String, String>();
			map.put("Authorization", "Bearer " + access_token);

			String reqURL = "https://kapi.kakao.com/v1/user/logout";

			try {

				URL url = new URL(reqURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Authorization", "Bearer " + access_token);

				int responseCode = conn.getResponseCode();

				logger.info("카카오 로그아웃 리턴코드 : " + responseCode);

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String result = "";
				String line = "";

				while ((line = br.readLine()) != null) {
					result += line;
				}
				logger.info("카카오 로그아웃 결과 : " + result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 로그인으로 생성한 세션을 다 지운다.
		session.invalidate();
		return "redirect:/";
	}

	// 카카오 로그인 후 콜백 요청URL
	@GetMapping("/kakao_callback")
	// 3.
	public String redirectkakao(@RequestParam String code, HttpServletResponse response, HttpSession session)
			throws Exception {

		logger.info("============================ KakaoController ========================");
		logger.info("code :: {}", code);

		// 접속토큰 get
		String kakaoToken = kakaoApiHandler.getKakaoReturnAccessToken(code);

		// 접속자 정보 get
		Map<String, Object> result = kakaoApiHandler.getKakaoUserInfo(kakaoToken);

		logger.info("result :: {}", result);

		String kakaNo = (String) result.get("id");
		String userName = (String) result.get("nickname");
		String email = (String) result.get("email");
		// String profileImage = (String) result.get("profileImage");
		String userpw = kakaNo;

		// 분기
		UserDTO userDto = new UserDTO();

		System.out.println(userDao.selectKakao(kakaNo));

		// kakaNo로 회원정보 조회시 없으면 회원가입
		if (userDao.selectKakao(kakaNo) == null) {

			logger.info("카카오로 회원가입");
			userDto.setUser_id(email);
			userDto.setUser_pwd(userpw);
			userDto.setUser_nm(userName);
			userDto.setUser_nicknm(userName);
			userDto.setUser_email(email);

			// userDto.setImage(profileImage);
			userDto.setKakao_no(kakaNo);

			userDto.setUser_gen(0); // 임시

			logger.info("===================== insert 전 userDto의 값 == > " + userDto.toString());

			userDao.insert(userDto);
			
			UserDTO userInfo = userDao.selectKakao(kakaNo);

			session.setAttribute("id", userInfo.getUser_id());
			session.setAttribute("admin", userInfo.getAdmin());
			session.setAttribute("user_no", userInfo.getUser_no());
			session.setAttribute("user_nicknm", userInfo.getUser_nicknm());
			session.setAttribute("user_img", userInfo.getImage());
			/* 로그아웃 처리 시, 사용할 토큰 값 */
			session.setAttribute("kakaoToken", kakaoToken);
			
			return "redirect:/signin/addInfo";
			
		}

		// kakaNo로 회원정보 조회시 있으면 로그인 처리
		logger.info("카카오로 로그인");
		UserDTO userInfo = userDao.selectKakao(kakaNo);

		session.setAttribute("id", userInfo.getUser_id());
		session.setAttribute("admin", userInfo.getAdmin());
		session.setAttribute("user_no", userInfo.getUser_no());
		session.setAttribute("user_nicknm", userInfo.getUser_nicknm());
		session.setAttribute("user_img", userInfo.getImage());
		/* 로그아웃 처리 시, 사용할 토큰 값 */
		session.setAttribute("kakaoToken", kakaoToken);

		logger.info("====================== kakaoToken : " + kakaoToken);
		logger.info("member:: " + userInfo.toString());

		return "redirect:/";

	}



	/*
	 * //로그인 첫 화면 요청 메소드
	 * 
	 * @RequestMapping(value = "/naver_login", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String login(Model model, HttpSession session) {
	 * 
	 * 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 String
	 * naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
	 * 
	 * //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***
	 * ************&
	 * //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&
	 * state=e68c269c-5ba9-4c31-85da-54c16c658125 System.out.println("네이버:" +
	 * naverAuthUrl);
	 * 
	 * //네이버 model.addAttribute("url", naverAuthUrl);
	 * 
	 * 생성한 인증 URL을 View로 전달 return "login"; }
	 * 
	 * //네이버 로그인 성공시 callback호출 메소드
	 * 
	 * @RequestMapping(value = "/auth/naver/callback", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String callback(Model model, @RequestParam
	 * String code, @RequestParam String state, HttpSession session) throws
	 * IOException { System.out.println("여기는 callback"); OAuth2AccessToken
	 * oauthToken; oauthToken = naverLoginBO.getAccessToken(session, code, state);
	 * //로그인 사용자 정보를 읽어온다. apiResult = naverLoginBO.getUserProfile(oauthToken);
	 * model.addAttribute("result", apiResult);
	 * 
	 * 네이버 로그인 성공 페이지 View 호출 return "redirect:/"; }
	 */
	
	// 네이버 로그인 첫 화면 요청
	@GetMapping("/naver/login")
	public String naverLogin(HttpSession session) {
		
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		return "redirect:" + naverAuthUrl;
	}
	
	@GetMapping("/auth/naver/callback")
	public String naverCallback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
		
		logger.info("============================ NaverController ========================");
		logger.info("code :: {}", code);
		
		// 접속토근 get
		OAuth2AccessToken naverToken = naverLoginBO.getAccessToken(session, code, state);
		
		// 접속자 정보 get
		Map<String, Object> userInfo = naverLoginBO.getUserProfile(naverToken);
		
		logger.info("userInfo :: {}", userInfo);
		
		if(userInfo != null) {
			String resultCode = (String) userInfo.get("resultcode");
			if("00".equals(resultCode)) {
				Map<String, Object> response = (Map<String, Object>) userInfo.get("response");
				
				// 사용자 정보 가져오기
				String naverId = (String) response.get("id");
				String userName = (String) response.get("name");
				String email = (String) response.get("email");
				

				// naverId로 회원정보 조회시 없으면 회원가입
				UserDTO user = userDao.select(email);
				if(user == null) {
					user = new UserDTO();
					user.setUser_id(email);
					user.setUser_nm(userName);
					user.setUser_nicknm(userName);
					user.setUser_email(email);
					user.setUser_pwd(naverId);
					user.setUser_gen(3);
					
					logger.info("===================== insert 전 userDto의 값 == > " + user.toString());
					
					userDao.insert(user);
					
					logger.info("===================== insert 후 userDto의 값 == > " + user.toString());
					
					user = userDao.select(email);
					
					session.setAttribute("id", user.getUser_id());
					session.setAttribute("admin", user.getAdmin());
					session.setAttribute("user_no", user.getUser_no());
					session.setAttribute("user_nicknm", user.getUser_nicknm());
					session.setAttribute("user_img", user.getImage());
					
					return "redirect:/signin/addInfo";
				}
				
				//naverId로 회원정보 조회시 있으면 로그인 처리
				logger.info("네이버로 로그인");
				
				session.setAttribute("id", user.getUser_id());
				session.setAttribute("admin", user.getAdmin());
				session.setAttribute("user_no", user.getUser_no());
				session.setAttribute("user_nicknm", user.getUser_nicknm());
				session.setAttribute("user_img", user.getImage());
			
				
				logger.info("member:: "+ user.toString());	
			}
			
		}
		
		/* 로그아웃 처리 시, 사용할 토큰 값 */
		session.setAttribute("naverToken", naverToken);
		
		logger.info("============================ naverToken : "+naverToken);
		
		
		return "redirect:/";
	}

}








