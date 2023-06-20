package com.ottt.ottt.dto;

import java.util.Date;
import java.util.Objects;

/*
 * wishlist_no		smallint	generated always as identity primary key
	,user_no		bigint		not null
	,content_no		bigint		not null
 */
public class WishlistDTO {

	private int user_no;
	private int content_no;
	private Date wish_date;
	

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getContent_no() {
		return content_no;
	}

	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}

	public Date getWish_date() {
		return wish_date;
	}

	public void setWish_date(Date wish_date) {
		this.wish_date = wish_date;
	}

	@Override
	public String toString() {
		return "WishlistDTO [user_no=" + user_no + ", content_no=" + content_no + ", wish_date=" + wish_date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content_no, user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishlistDTO other = (WishlistDTO) obj;
		return content_no == other.content_no && user_no == other.user_no;
	}
	
}
