package com.ottt.ottt.dto;

import java.util.Objects;

/*
 * content_no		bigint	not null
	,ott_no			bigint	not null
 */
public class ContentOTTDTO {

	private Integer content_no;
	private Integer ott_no;
	
	public ContentOTTDTO() {}

	public Integer getContent_no() {
		return content_no;
	}

	public void setContent_no(Integer content_no) {
		this.content_no = content_no;
	}

	public Integer getOtt_no() {
		return ott_no;
	}

	public void setOtt_no(Integer ott_no) {
		this.ott_no = ott_no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content_no, ott_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentOTTDTO other = (ContentOTTDTO) obj;
		return Objects.equals(content_no, other.content_no) && Objects.equals(ott_no, other.ott_no);
	}

	@Override
	public String toString() {
		return "ContentOTTDTO [content_no=" + content_no + ", ott_no=" + ott_no + "]";
	}
	
	
}
