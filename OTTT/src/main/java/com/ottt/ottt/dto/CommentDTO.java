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
<<<<<<< HEAD
	private int		user_no;
	private int		article_no;
	private int 	review_no;
=======
	private Integer	user_no;
	private Integer	article_no;
	private Integer	review_no;
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
	private String	cmm_content;
	private String	cmm_writer;
	private Date	cmt_dt;
	private Date	cmt_mod_dt;
<<<<<<< HEAD
	private int		cmt_like_count;
	private int		report_cnt;
=======
	private Integer	cmt_like_count;
	private Integer	report_cnt;
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
	
	
	public CommentDTO() {}


	public Integer getCmt_no() {
		return cmt_no;
	}


	public void setCmt_no(Integer cmt_no) {
		this.cmt_no = cmt_no;
	}


<<<<<<< HEAD
	public int getUser_no() {
=======
	public Integer getUser_no() {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		return user_no;
	}


<<<<<<< HEAD
	public void setUser_no(int user_no) {
=======
	public void setUser_no(Integer user_no) {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		this.user_no = user_no;
	}


<<<<<<< HEAD
	public int getArticle_no() {
=======
	public Integer getArticle_no() {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		return article_no;
	}


<<<<<<< HEAD
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}

	
	
	public int getReview_no() {
=======
	public void setArticle_no(Integer article_no) {
		this.article_no = article_no;
	}


	public Integer getReview_no() {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		return review_no;
	}


<<<<<<< HEAD
	public void setReview_no(int review_no) {
=======
	public void setReview_no(Integer review_no) {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
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


<<<<<<< HEAD
	public int getCmt_like_count() {
=======
	public Integer getCmt_like_count() {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		return cmt_like_count;
	}


<<<<<<< HEAD
	public void setCmt_like_count(int cmt_like_count) {
=======
	public void setCmt_like_count(Integer cmt_like_count) {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		this.cmt_like_count = cmt_like_count;
	}


<<<<<<< HEAD
	public int getReport_cnt() {
=======
	public Integer getReport_cnt() {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		return report_cnt;
	}


<<<<<<< HEAD
	public void setReport_cnt(int report_cnt) {
=======
	public void setReport_cnt(Integer report_cnt) {
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
		this.report_cnt = report_cnt;
	}


	@Override
<<<<<<< HEAD
	public int hashCode() {
		return Objects.hash(article_no, cmm_content, cmm_writer, cmt_no, user_no);
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
		return article_no == other.article_no && Objects.equals(cmm_content, other.cmm_content)
				&& Objects.equals(cmm_writer, other.cmm_writer) && Objects.equals(cmt_no, other.cmt_no)
				&& user_no == other.user_no;
	}


	@Override
	public String toString() {
		return "CommentDTO [cmt_no=" + cmt_no + ", user_no=" + user_no + ", article_no=" + article_no
				+ ", cmm_content=" + cmm_content + ", cmm_writer=" + cmm_writer + ", cmt_dt=" + cmt_dt + ", cmt_mod_dt="
				+ cmt_mod_dt + ", cmt_like_count=" + cmt_like_count + ", report_cnt=" + report_cnt + "]";
	}
	
	
	
	
	
	
	

=======
	public String toString() {
		return "CommentDTO [cmt_no=" + cmt_no + ", user_no=" + user_no + ", article_no=" + article_no + ", review_no="
				+ review_no + ", cmm_content=" + cmm_content + ", cmm_writer=" + cmm_writer + ", cmt_dt=" + cmt_dt
				+ ", cmt_mod_dt=" + cmt_mod_dt + ", cmt_like_count=" + cmt_like_count + ", report_cnt=" + report_cnt
				+ "]";
	}
	
	
>>>>>>> 7c5f8d98bb08e6ee1d7eaeaf01c0c8ee7140c260
}
