package com.demo.dto;

public class Comments {

	public Long id;
	public Long postId;
	public String name;
	public String email;
	public String body;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		builder.append("Comments [id=").append(id).append(", postId=").append(postId).append(", name=").append(name)
				.append(", email=").append(email).append(", body=").append(body).append("]");
		return builder.toString();
	}
}
