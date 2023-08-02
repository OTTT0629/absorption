package com.ottt.ottt.dao.mypage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.NotificationDTO;

@Repository
public class NotificationDaoImpl implements NotificationDao {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.ottt.ottt.dao.mypage.NotificationMapper.";
	
	@Override
	public List<NotificationDTO> selectNoti(Integer noti_no) throws Exception {
		return session.selectList(namespace + "selectNoti", noti_no);
	}
	
	@Override
	public int insertReviewLike(NotificationDTO notificationDTO) throws Exception {
		return session.insert(namespace + "insertReviewLike", notificationDTO);
	}
	
	@Override
	public int insertReviewCmt(NotificationDTO notificationDTO) throws Exception {
		return session.insert(namespace + "insertReviewCmt", notificationDTO);
	}
	
	@Override
	public int insertArticleLike(NotificationDTO notificationDTO) throws Exception {
		return session.insert(namespace + "insertArticleLike", notificationDTO);
	}
	
	@Override
	public int insertArticleCmt(NotificationDTO notificationDTO) throws Exception {
		return session.insert(namespace + "insertArticleCmt", notificationDTO);
	}
	
	@Override
	public int insertMessage(NotificationDTO notificationDTO) throws Exception {
		return session.insert(namespace + "insertMessage", notificationDTO);
	}
	
	@Override
	public int insertQna(NotificationDTO notificationDTO) throws Exception {
		return session.insert(namespace + "insertQna", notificationDTO);
	}
	
	@Override
	public int deleteNoti(Integer noti_no, Integer target_user_no) throws Exception {
		Map map = new HashMap();
		map.put("noti_no", noti_no);
		map.put("target_user_no", target_user_no);
		return session.delete(namespace  + "deleteNoti" , map);
	}

	@Override
	public int notiCnt(Integer target_user_no) throws Exception {
		return session.selectOne(namespace + "notiCnt", target_user_no);
	}
	
}
