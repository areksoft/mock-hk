/**
 * 
 */
package com.demo.dto;

/**
 * @author hgouramoni
 *
 */
public class AuthUser {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthUser [user=").append(user).append(", token=").append(token).append("]");
		return builder.toString();
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String user;
	public String token;
}
