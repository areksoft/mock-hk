package com.demo.dto;

public class Posts {

	public Long id;
	public Long userId;
	public String title;
	public String body;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Posts [id=").append(id).append(", userId=").append(userId).append(", title=").append(title)
				.append(", body=").append(body).append("]");
		return builder.toString();
	}
}
