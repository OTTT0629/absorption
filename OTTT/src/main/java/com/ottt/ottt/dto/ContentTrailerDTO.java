package com.ottt.ottt.dto;

import java.util.Objects;

public class ContentTrailerDTO {
	private Integer content_no;
	private String thumbnail;
	private String trailer;
	public Integer getContent_no() {
		return content_no;
	}
	public void setContent_no(Integer content_no) {
		this.content_no = content_no;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	@Override
	public String toString() {
		return "ContentTrailerDTO [content_no=" + content_no + ", thumbnail=" + thumbnail + ", trailer=" + trailer
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(content_no, thumbnail, trailer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentTrailerDTO other = (ContentTrailerDTO) obj;
		return Objects.equals(content_no, other.content_no) && Objects.equals(thumbnail, other.thumbnail)
				&& Objects.equals(trailer, other.trailer);
	}
	
}
