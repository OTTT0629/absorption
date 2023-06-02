package com.ottt.ottt.dto;

import java.util.Objects;

/*게시글 좋아요
 * 	article_like_no		bigint	generated always as identity primary key
	,article_no			bigint	not null
 */

public class ArticleLikeDTO {
	
	private Integer	article_like_no;
	private int		article_no;
	
	
	public ArticleLikeDTO() {}


	public Integer getArticle_like_no() {
		return article_like_no;
	}


	public void setArticle_like_no(Integer article_like_no) {
		this.article_like_no = article_like_no;
	}


	public int getArticle_no() {
		return article_no;
	}


	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}


	@Override
	public int hashCode() {
		return Objects.hash(article_like_no, article_no);
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
		return Objects.equals(article_like_no, other.article_like_no) && article_no == other.article_no;
	}


	@Override
	public String toString() {
		return "ArticleLikeDTO [article_like_no=" + article_like_no + ", article_no=" + article_no + "]";
	}


}
