package com.ottt.ottt.dto;

import java.util.Date;
import java.util.Objects;

/*
 * message_no 			bigint 		  generated always as identity primary key
	,send_user_no		bigint 		  not null
	,receive_user_no	bigint 		  not null
	,content 			varchar(2000) not null
	,send_date			timestamptz	  not null
 */
public class MessageDTO {

	private Integer message_no;
	private int send_user_no;
	private int receive_user_no;
	private String content;
	private Date send_date;
	
	public MessageDTO() {}

	public Integer getMessage_no() {
		return message_no;
	}

	public void setMessage_no(Integer message_no) {
		this.message_no = message_no;
	}

	public int getSend_user_no() {
		return send_user_no;
	}

	public void setSend_user_no(int send_user_no) {
		this.send_user_no = send_user_no;
	}

	public int getReceive_user_no() {
		return receive_user_no;
	}

	public void setReceive_user_no(int receive_user_no) {
		this.receive_user_no = receive_user_no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, message_no, receive_user_no, send_date, send_user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageDTO other = (MessageDTO) obj;
		return Objects.equals(content, other.content) && Objects.equals(message_no, other.message_no)
				&& receive_user_no == other.receive_user_no && Objects.equals(send_date, other.send_date)
				&& send_user_no == other.send_user_no;
	}

	@Override
	public String toString() {
		return "MessageDTO [message_no=" + message_no + ", send_user_no=" + send_user_no + ", receive_user_no="
				+ receive_user_no + ", content=" + content + ", send_date=" + send_date + "]";
	}
	
	
}
