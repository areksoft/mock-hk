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

import com.demo.dto.Comments;
import com.demo.services.CommentsService;

/**
 * @author hgouramoni
 *
 */
 
@RestController
public class GetComments {

	@Autowired
	CommentsService commentsService;

	@GetMapping("comments")
	public ResponseEntity<List<Comments>> getAll() {
		System.out.println("GetComments >> getAll method() has been invoked !");
		return new ResponseEntity<>(commentsService.getAll(), HttpStatus.OK);
	}

}