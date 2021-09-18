/**
 * 
 */
package com.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.AuthUser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/**
 * @author hgouramoni
 *
 */

@RestController
public class AuthController {

	/**
	 * authUser method to authorize the user and generate the JWT token,
	 *  if not expired or available
	 * @param username
	 * @param pwd
	 * @return
	 */
	@PostMapping("authuser")
	public AuthUser authUser(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		System.out.println("Inside AuthController ## login method...");
		String token = getJWTToken(username);
		AuthUser user = new AuthUser();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}
	
	/**
	 * Method to get the JWT Token
	 * @param username
	 * @return
	 */
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("hariJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
