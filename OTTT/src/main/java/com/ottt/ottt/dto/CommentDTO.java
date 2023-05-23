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
	private Integer	user_no;
	private Integer	article_no;
	private Integer	review_no;
	private String	cmm_content;
	private String	cmm_writer;
	private Date	cmt_dt;
	private Date	cmt_mod_dt;
	private Integer	cmt_like_count;
	private Integer	report_cnt;
	
	
	public CommentDTO() {}


	public Integer getCmt_no() {
		return cmt_no;
	}


	public void setCmt_no(Integer cmt_no) {
		this.cmt_no = cmt_no;
	}


	public Integer getUser_no() {
		return user_no;
	}


	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}


	public Integer getArticle_no() {
		return article_no;
	}


	public void setArticle_no(Integer article_no) {
		this.article_no = article_no;
	}


	public Integer getReview_no() {
		return review_no;
	}


	public void setReview_no(Integer review_no) {
		this.review_no = review_no;
	}


	public String getCmm_content() {
		return cmm_content;
	}


	public void setCmm_content(String cmm_content) {
		this.cmm_content = cmm_content;
	}


	public String getCmm_writer() {
		return cmm_writer;
	}


	public void setCmm_writer(String cmm_writer) {
		this.cmm_writer = cmm_writer;
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


	public Integer getCmt_like_count() {
		return cmt_like_count;
	}


	public void setCmt_like_count(Integer cmt_like_count) {
		this.cmt_like_count = cmt_like_count;
	}


	public Integer getReport_cnt() {
		return report_cnt;
	}


	public void setReport_cnt(Integer report_cnt) {
		this.report_cnt = report_cnt;
	}


	@Override
	public String toString() {
		return "CommentDTO [cmt_no=" + cmt_no + ", user_no=" + user_no + ", article_no=" + article_no + ", review_no="
				+ review_no + ", cmm_content=" + cmm_content + ", cmm_writer=" + cmm_writer + ", cmt_dt=" + cmt_dt
				+ ", cmt_mod_dt=" + cmt_mod_dt + ", cmt_like_count=" + cmt_like_count + ", report_cnt=" + report_cnt
				+ "]";
	}
	
	
}
