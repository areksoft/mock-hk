package com.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import com.demo.filter.JWTAuthFilter;
import com.demo.services.CommentsService;
import com.demo.services.PostsService;
import com.demo.services.UserService;
import com.demo.services.impl.CommentsServiceImpl;
import com.demo.services.impl.PostsServiceImpl;
import com.demo.services.impl.UserServiceImpl;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	public UserService userService() {
	    return new UserServiceImpl();
	}
	
	@Bean
	public PostsService postsService() {
	    return new PostsServiceImpl();
	}
	
	@Bean
	public CommentsService commentsService() {
	    return new CommentsServiceImpl();
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
	    factory.setConnectTimeout(3000);
	    factory.setReadTimeout(3000);
	    return new RestTemplate(factory);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/authuser").permitAll()
				.anyRequest().authenticated();
		}
	}
	 
}
