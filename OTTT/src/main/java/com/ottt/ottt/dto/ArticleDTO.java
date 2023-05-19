package com.ottt.ottt.dto;
import java.util.Date;
/*게시글
 * 	article_no				bigint			generated always as identity primary key
	,user_no				bigint			not null
	,article_index_no		char(1)			not null
	,article_content_no		bigint			not null	
	,article_title			varchar(255)
	,article_create_dt		timestamptz		not null
	,article_mod_dt			timestamptz
	,article_like_count		int	
	,report_cnt				int
 */
import java.util.Objects;

public class ArticleDTO {
	
	private	Integer	article_no;
	private int		user_no;
	private char	article_index_no;
	private String	article_content;
	private String  article_image;
	private String	article_title;
	private Date	article_create_dt;
	private Date	article_mod_dt;
	private int		article_like_count;
	private int		report_cnt;
	private String  user_nicknm;
	
	public String getUser_nicknm() {
		return user_nicknm;
	}

	public void setUser_nicknm(String user_nicknm) {
		this.user_nicknm = user_nicknm;
	}

	private UserDTO userDTO;
	
	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public ArticleDTO() {}
	
	public ArticleDTO(String article_content, int user_no) {
		this.article_content = article_content;
		this.user_no = user_no;
	}


	public Integer getArticle_no() {
		return article_no;
	}


	public void setArticle_no(Integer article_no) {
		this.article_no = article_no;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public char getArticle_index_no() {
		return article_index_no;
	}


	public void setArticle_index_no(char article_index_no) {
		this.article_index_no = article_index_no;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_image() {
		return article_image;
	}

	public void setArticle_image(String article_image) {
		this.article_image = article_image;
	}

	public String getArticle_title() {
		return article_title;
	}


	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}


	public Date getArticle_create_dt() {
		return article_create_dt;
	}


	public void setArticle_create_dt(Date article_create_dt) {
		this.article_create_dt = article_create_dt;
	}


	public Date getArticle_mod_dt() {
		return article_mod_dt;
	}


	public void setArticle_mod_dt(Date article_mod_dt) {
		this.article_mod_dt = article_mod_dt;
	}


	public int getArticle_like_count() {
		return article_like_count;
	}


	public void setArticle_like_count(int article_like_count) {
		this.article_like_count = article_like_count;
	}


	public int getReport_cnt() {
		return report_cnt;
	}


	public void setReport_cnt(int report_cnt) {
		this.report_cnt = report_cnt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(article_content, article_image, article_index_no, article_no, article_title, user_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleDTO other = (ArticleDTO) obj;
		return Objects.equals(article_content, other.article_content)
				&& Objects.equals(article_image, other.article_image) && article_index_no == other.article_index_no
				&& Objects.equals(article_no, other.article_no) && Objects.equals(article_title, other.article_title)
				&& user_no == other.user_no;
	}

	@Override
	public String toString() {
		return "ArticleDTO [article_no=" + article_no + ", user_no=" + user_no + ", article_index_no="
				+ article_index_no + ", article_content=" + article_content + ", article_image=" + article_image
				+ ", article_title=" + article_title + ", article_create_dt=" + article_create_dt + ", article_mod_dt="
				+ article_mod_dt + ", article_like_count=" + article_like_count + ", report_cnt=" + report_cnt + "]";
	}



	
	
	
	

}
