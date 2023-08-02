package com.ottt.ottt.dao.mypage;

import java.util.List;

import com.ottt.ottt.dto.NotificationDTO;

public interface NotificationDao {

	//알림 리스트 불러오기
	List<NotificationDTO> selectNoti(Integer noti_no) throws Exception;
	
	//리뷰 좋아요
	int insertReviewLike(NotificationDTO notificationDTO) throws Exception;
	
	//리뷰 댓글
	int insertReviewCmt(NotificationDTO notificationDTO) throws Exception;
	
	//게시글 좋아요
	int insertArticleLike(NotificationDTO notificationDTO) throws Exception;
	
	//게시글 댓글
	int insertArticleCmt(NotificationDTO notificationDTO) throws Exception;
	
	//쪽지 보냄
	int insertMessage(NotificationDTO notificationDTO) throws Exception;
	
	//큐앤에이 댓글
	int insertQna(NotificationDTO notificationDTO) throws Exception;
	
	//알림 삭제
	int deleteNoti(Integer noti_no, Integer target_user_no) throws Exception;
	
	//알림 총 개수 세기
	int notiCnt(Integer target_user_no) throws Exception;

}
