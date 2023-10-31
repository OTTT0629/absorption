package com.ottt.ottt.dto;

import java.util.Objects;

public class ContentPosterDTO {
	private Integer content_no;
	private String poster;
	@Override
	public int hashCode() {
		return Objects.hash(content_no, poster);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentPosterDTO other = (ContentPosterDTO) obj;
		return Objects.equals(content_no, other.content_no) && Objects.equals(poster, other.poster);
	}
	@Override
	public String toString() {
		return "ContentPosterDTO [content_no=" + content_no + ", poster=" + poster + "]";
	}
	public Integer getContent_no() {
		return content_no;
	}
	public void setContent_no(Integer content_no) {
		this.content_no = content_no;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
}
