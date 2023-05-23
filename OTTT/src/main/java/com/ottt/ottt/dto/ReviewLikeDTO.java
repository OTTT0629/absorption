package com.ottt.ottt.dto;

import java.util.Objects;

/*
 * --리뷰좋아요번호
	review_like_no		bigint			generated always as identity primary key
	--리뷰번호 FK
	,review_no			bigint			not null	
	--프로필번호 FK
	,user_no			bigint			not null
 */
public class ReviewLikeDTO {

	
	private Integer review_no;
	private Integer user_no;

	


	public ReviewLikeDTO() {}



	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(Integer review_no) {
		this.review_no = review_no;
	}

	@Override
	public String toString() {
		return "ReviewLikeDTO [review_no=" + review_no + ", user_no=" + user_no + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(review_no, user_no);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewLikeDTO other = (ReviewLikeDTO) obj;
		return review_no == other.review_no && user_no == other.user_no;
	}



	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}

	

	
	
}
