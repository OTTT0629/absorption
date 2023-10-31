package com.ottt.ottt.service.mypage;

import java.util.List;

import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.NotificationDTO;

public interface NotificationService {

	List<NotificationDTO> getNotiList(Integer noti_no) throws Exception;
	
	int putReviewLike(NotificationDTO notificationDTO) throws Exception;
	int putReviewCmt(NotificationDTO notificationDTO) throws Exception;
	int putArticleLike(NotificationDTO notificationDTO) throws Exception;
	int putArticleCmt(NotificationDTO notificationDTO) throws Exception;
	int putMessage(NotificationDTO notificationDTO) throws Exception;
	int putQna(NotificationDTO notificationDTO) throws Exception;
	int removeNoti(Integer noti_no, Integer target_user_no) throws Exception;
	int notificationCnt(Integer target_user_no) throws Exception;
	int getSelectCheck(Integer target_user_no) throws Exception;
	int checkYes(NotificationDTO notificationDTO) throws Exception;
	NotificationDTO pickOneNoti(Integer noti_no) throws Exception;
}
