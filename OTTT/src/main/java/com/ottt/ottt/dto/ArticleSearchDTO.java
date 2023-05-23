package com.ottt.ottt.dto;

public class ArticleSearchDTO {
	
	private	Integer	offset;
	private String schTxt;
	private Integer user_no;
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public String getSchTxt() {
		return schTxt;
	}
	public void setSchTxt(String schTxt) {
		this.schTxt = schTxt;
	}
	public Integer getUser_no() {
		return user_no;
	}
	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "ArticleSearchDTO [offset=" + offset + ", schTxt=" + schTxt + ", user_no=" + user_no
				+ "]";
	}

}
