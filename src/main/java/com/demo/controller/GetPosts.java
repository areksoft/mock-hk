/**
 * 
 */
package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Posts;
import com.demo.services.PostsService;

/**
 * @author hgouramoni
 *
 */

@RestController
public class GetPosts {
	@Autowired
	PostsService postService;

	@GetMapping("posts")
	public ResponseEntity<List<Posts>> getAll() {
		System.out.println("GetPosts >> getAll method() has been invoked !");
		return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
	}
}