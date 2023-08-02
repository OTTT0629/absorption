package com.ottt.ottt.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ottt.ottt.controller.community.CommunityController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KakaoApiHandler {
	
	private static final Logger log = LoggerFactory.getLogger(CommunityController.class);
	
	//콜백 리턴 주소
    @Value("${kakao.callback.redirectUri}")
    private String KAKAO_REDIRECT_URI;
    //통신을 하기위한 개발자센터에서 발급받은 REST API KEY
    @Value("${kakao.api.restKey}")
    private String KAKAO_REST_KEY;
	// 4.
	// 카카오 회원정보 요청을 위한 access_token키 발급
	public String getKakaoReturnAccessToken(String code) {

		String access_token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// HttpURLConnection 설정 값 셋팅
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// POST 파라미터 설정 rest key 입력
			String parameters = String.format(
					"grant_type=authorization_code&client_id=" + KAKAO_REST_KEY + "&redirect_uri=" + KAKAO_REDIRECT_URI + "&code=%s",
					code);

			// 요청 전송
			conn.getOutputStream().write(parameters.getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			// 응답 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String result = br.lines().collect(Collectors.joining());
			br.close();

			// 토큰 값 저장 및 리턴
			JsonElement element = JsonParser.parseString(result);
			access_token = element.getAsJsonObject().get("access_token").getAsString();

			log.info(" ■■■kakao■■■ access_token : {}", access_token);

			conn.disconnect();

		} catch (IOException e) {
		
			e.printStackTrace();
		
		}

		return access_token;
	}

	// 5.
	// access_token키로 회원정보 요청
	public Map<String, Object> getKakaoUserInfo(String access_token) {
		Map<String, Object> resultMap = new HashMap<>();

		String reqURL = "https://kapi.kakao.com/v2/user/me";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_token);

			int responseCode = conn.getResponseCode();
			log.info(" ■■■kakao■■■ responseCode : {} ", responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			String result = br.lines().collect(Collectors.joining());
			log.info("response : {}", result);

			JsonElement element = JsonParser.parseString(result);
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			String id = element.getAsJsonObject().get("id").getAsString();
			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
			// String profileImageUrl =
			// properties.getAsJsonObject().get("profile_image").getAsString();

			log.info(" ■■■kakao■■■ id : {}", id);
			log.info(" ■■■kakao■■■ email : {}", email);
			log.info(" ■■■kakao■■■ nickname : {}", nickname);
			// log.info(" ■■■kakao■■■ profileImageUrl : {}", profileImageUrl);

			resultMap.put("id", id);
			resultMap.put("email", email);
			resultMap.put("nickname", nickname);
			// resultMap.put("profileImage", profileImageUrl);

			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultMap;
	}

}
