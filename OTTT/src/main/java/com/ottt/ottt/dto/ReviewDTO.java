package com.ottt.ottt.dto;

import java.util.Date;
import java.util.Objects;

/*
 * --리뷰번호
	review_no			bigint 			generated always as identity primary key
	--영상번호 FK
	,content_no			BIGINT			not null
	--작성자(프로필번호) FK
	,user_no			BIGINT			not null
	--별점
	,rating			 	float				not null
	--내용
	,review_content		varchar(65535)	not null
	--등록날짜
	
 */
public class ReviewDTO {

	private Integer review_no;
	private int content_no;			//이건 작품 번호임
	private float rating;
	private Integer user_no;
	private String review_content;
	private Date review_create_dt;
	
	private String user_nicknm;
	private UserDTO userDTO;
	public Integer getReview_no() {
		return review_no;
	}
	public void setReview_no(Integer review_no) {
		this.review_no = review_no;
	}
	public int getContent_no() {
		return content_no;
	}
	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public Integer getUser_no() {
		return user_no;
	}
	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Date getReview_create_dt() {
		return review_create_dt;
	}
	public void setReview_create_dt(Date review_create_dt) {
		this.review_create_dt = review_create_dt;
	}
	public String getUser_nicknm() {
		return user_nicknm;
	}
	public void setUser_nicknm(String user_nicknm) {
		this.user_nicknm = user_nicknm;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	@Override
	public String toString() {
		return "ReviewDTO [review_no=" + review_no + ", content_no=" + content_no + ", rating=" + rating + ", user_no="
				+ user_no + ", review_content=" + review_content + ", review_create_dt=" + review_create_dt
				+ ", user_nicknm=" + user_nicknm + ", userDTO=" + userDTO + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(content_no, rating, review_content, review_create_dt, review_no, userDTO, user_nicknm,
				user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewDTO other = (ReviewDTO) obj;
		return content_no == other.content_no && Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating)
				&& Objects.equals(review_content, other.review_content)
				&& Objects.equals(review_create_dt, other.review_create_dt)
				&& Objects.equals(review_no, other.review_no) && Objects.equals(userDTO, other.userDTO)
				&& Objects.equals(user_nicknm, other.user_nicknm) && Objects.equals(user_no, other.user_no);
	}

	
}