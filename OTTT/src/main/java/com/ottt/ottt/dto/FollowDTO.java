package com.ottt.ottt.dto;

import java.util.Objects;

/*
	followers_no 	bigint	not null
	,following_no 	bigint	not null
 */
public class FollowDTO {

	private Integer follower_no;
	private Integer following_no;
	
	
	public Integer getFollowers_no() {
		return follower_no;
	}
	public void setFollowers_no(Integer followers_no) {
		this.follower_no = followers_no;
	}
	public Integer getFollowing_no() {
		return following_no;
	}
	public void setFollowing_no(Integer following_no) {
		this.following_no = following_no;
	}
		
	@Override
	public String toString() {
		return "FollowDTO [followers_no=" + follower_no + ", following_no=" + following_no
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(follower_no, following_no);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FollowDTO other = (FollowDTO) obj;
		return Objects.equals(follower_no, other.follower_no) && Objects.equals(following_no, other.following_no);
	}
		
}
