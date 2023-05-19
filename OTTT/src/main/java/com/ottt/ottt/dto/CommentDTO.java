package com.ottt.ottt.dto;

import java.util.Date;
import java.util.Objects;

/* 댓글
 * 	cmt_no				bigint			generated always as identity primary key
	, user_no			bigint			not null	
	, article_no		bigint
	, review_no			bigint
	, cmt_content		varchar(3000)	not null
	, cmt_writer		varchar(50)		not null
	, cmt_dt			timestamptz		not null
	, cmt_mod_dt		timestamptz		not null
	, cmt_like_count	int				not null
	, report_cnt		int				not null
 */

public class CommentDTO {
	
	private	Integer	cmt_no;
	private int		user_no;
	private int		article_no;
	private int 	review_no;
	private String	cmt_content;
	private String	cmt_writer;
	private Date	cmt_dt;
	private Date	cmt_mod_dt;
	private int		cmt_like_count;
	private int		report_cnt;
	
	
	public CommentDTO() {}


	public Integer getCmt_no() {
		return cmt_no;
	}


	public void setCmt_no(Integer cmt_no) {
		this.cmt_no = cmt_no;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public int getArticle_no() {
		return article_no;
	}


	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}

	
	
	public int getReview_no() {
		return review_no;
	}


	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}


	public String getCmm_content() {
		return cmt_content;
	}


	public void setCmm_content(String cmm_content) {
		this.cmt_content = cmm_content;
	}


	public String getCmm_writer() {
		return cmt_writer;
	}


	public void setCmm_writer(String cmm_writer) {
		this.cmt_writer = cmm_writer;
	}


	public Date getCmt_dt() {
		return cmt_dt;
	}


	public void setCmt_dt(Date cmt_dt) {
		this.cmt_dt = cmt_dt;
	}


	public Date getCmt_mod_dt() {
		return cmt_mod_dt;
	}


	public void setCmt_mod_dt(Date cmt_mod_dt) {
		this.cmt_mod_dt = cmt_mod_dt;
	}


	public int getCmt_like_count() {
		return cmt_like_count;
	}


	public void setCmt_like_count(int cmt_like_count) {
		this.cmt_like_count = cmt_like_count;
	}


	public int getReport_cnt() {
		return report_cnt;
	}


	public void setReport_cnt(int report_cnt) {
		this.report_cnt = report_cnt;
	}


	@Override
	public int hashCode() {
		return Objects.hash(article_no, cmt_content, cmt_writer, cmt_no, user_no);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		return article_no == other.article_no && Objects.equals(cmt_content, other.cmt_content)
				&& Objects.equals(cmt_writer, other.cmt_writer) && Objects.equals(cmt_no, other.cmt_no)
				&& user_no == other.user_no;
	}


	@Override
	public String toString() {
		return "CommentDTO [cmt_no=" + cmt_no + ", user_no=" + user_no + ", article_no=" + article_no
				+ ", cmm_content=" + cmt_content + ", cmm_writer=" + cmt_writer + ", cmt_dt=" + cmt_dt + ", cmt_mod_dt="
				+ cmt_mod_dt + ", cmt_like_count=" + cmt_like_count + ", report_cnt=" + report_cnt + "]";
	}
	
	
	
	
	
	
	

}
