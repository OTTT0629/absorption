package com.ottt.ottt.service.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.message.MessageDao;
import com.ottt.ottt.domain.MessageSearchItem;
import com.ottt.ottt.dto.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageDao messageDao;
	
	@Override
	public MessageDTO read(Integer message_no) throws Exception {
		return messageDao.selectMsg(message_no);
	}

	@Override
	public List<MessageDTO> loadRecvList(MessageSearchItem msc) throws Exception {
		return messageDao.selectRecv(msc);
	}

	@Override
	public List<MessageDTO> loadSendList(MessageSearchItem msc) throws Exception {
		return messageDao.selectSend(msc);
	}

	@Override
	public int writeMsg(MessageDTO messageDTO) throws Exception {
		return messageDao.insert(messageDTO);
	}

	//하나 삭제랑 전체 삭제랑 뭘..멀 다르게..
	@Override
	public int removeMsg(Integer message_no, String user_no) throws Exception {
		return messageDao.delete(message_no, user_no);
	}

//	@Override
//	public int removeMsgAll(String user_no) throws Exception {
//		return 0;
//	}

	@Override
	public int getSendResultCnt(MessageSearchItem msc) throws Exception {
		return messageDao.sendResultCnt(msc);
	}
	
	@Override
	public int getRecvResultCnt(MessageSearchItem msc) throws Exception {
		return messageDao.recvResultCnt(msc);
	}

	@Override
	public List<MessageDTO> getSelectPage(MessageSearchItem msc) throws Exception {
		return messageDao.selectPage(msc);
	}

}
