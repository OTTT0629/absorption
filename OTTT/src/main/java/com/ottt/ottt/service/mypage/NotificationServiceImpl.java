package com.ottt.ottt.service.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.mypage.NotificationDao;
import com.ottt.ottt.dto.NotificationDTO;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationDao notificationDao;
	
	@Override
	public List<NotificationDTO> getNotiList(Integer noti_no) throws Exception {
		return notificationDao.selectNoti(noti_no);
	}

	@Override
	public int putReviewLike(NotificationDTO notificationDTO) throws Exception {
		return notificationDao.insertReviewLike(notificationDTO);
	}

	@Override
	public int putReviewCmt(NotificationDTO notificationDTO) throws Exception {
		return notificationDao.insertReviewCmt(notificationDTO);
	}

	@Override
	public int putArticleLike(NotificationDTO notificationDTO) throws Exception {
		return notificationDao.insertArticleLike(notificationDTO);
	}

	@Override
	public int putArticleCmt(NotificationDTO notificationDTO) throws Exception {
		return notificationDao.insertArticleCmt(notificationDTO);
	}

	@Override
	public int putMessage(NotificationDTO notificationDTO) throws Exception {
		return notificationDao.insertMessage(notificationDTO);
	}

	@Override
	public int putQna(NotificationDTO notificationDTO) throws Exception {
		return notificationDao.insertQna(notificationDTO);
	}

	@Override
	public int removeNoti(Integer noti_no, Integer target_user_no) throws Exception {
		return notificationDao.deleteNoti(noti_no, target_user_no);
	}

	@Override
	public int notificationCnt(Integer target_user_no) throws Exception {
		return notificationDao.notiCnt(target_user_no);
	}

}
