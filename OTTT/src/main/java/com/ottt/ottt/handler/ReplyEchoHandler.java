package com.ottt.ottt.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
//영상 파일을 지속적으로 올리려면(지속적으로 스트리밍해서 보려면 바이너리
//우리는 채팅 목적이는 text

import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.dao.login.LoginUserDao;


public class ReplyEchoHandler extends TextWebSocketHandler {
	@Autowired
	LoginUserDao loginUserDao;
	//로그인한 전체
	List<WebSocketSession> sessions = new ArrayList<>();
	//1 대 1 <-???먼데
	Map<String, WebSocketSession> userSessions = new HashMap<String, WebSocketSession>();
	
	
	//클라이언트가 서버에 접속했을 때 
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished: " + session);
		
		
		sessions.add(session);
		String sendUserId = getId(session);
		userSessions.put(sendUserId, session);
	}
	
	private String getId(WebSocketSession session) {
	    Map<String, Object> httpsession = session.getAttributes();
	    UserDTO loginUserId = loginUserDao.select((String) httpsession.get("id"));
	    
	    if(loginUserId == null) {
	    	return session.getId();
	    } else {
		    return loginUserId.getUser_id();
	    }
	}

	//소켓에 어떤 메세지를 보냈을 때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage: " + session + " :: " + message);
		
		
	}
	
	//연결이 닫혔을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		System.out.println("afterConnectionClosed: " + session + " :: " + status);
	}
	
}
