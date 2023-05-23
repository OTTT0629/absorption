package com.ottt.ottt.dto;

import java.util.Objects;

/*게시글 좋아요
 * 	article_like_no		bigint	generated always as identity primary key
	,article_no			bigint	not null
 */

public class ArticleLikeDTO {
	
	private Integer	article_like_no;
	private Integer	article_no;
	private Integer user_no;
	
	


	public ArticleLikeDTO() {}




	public Integer getArticle_like_no() {
		return article_like_no;
	}




	public void setArticle_like_no(Integer article_like_no) {
		this.article_like_no = article_like_no;
	}




	public Integer getArticle_no() {
		return article_no;
	}




	public void setArticle_no(Integer article_no) {
		this.article_no = article_no;
	}




	public Integer getUser_no() {
		return user_no;
	}




	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}




	@Override
	public int hashCode() {
		return Objects.hash(article_like_no, article_no, user_no);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleLikeDTO other = (ArticleLikeDTO) obj;
		return Objects.equals(article_like_no, other.article_like_no) && Objects.equals(article_no, other.article_no)
				&& Objects.equals(user_no, other.user_no);
	}




	@Override
	public String toString() {
		return "ArticleLikeDTO [article_like_no=" + article_like_no + ", article_no=" + article_no + ", user_no="
				+ user_no + "]";
	}


	

}
