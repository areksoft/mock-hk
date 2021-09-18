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

import com.demo.dto.User;
import com.demo.services.UserService;

/**
 * @author hgouramoni
 *
 */
 

	
@RestController
public class GetUserList {

	@Autowired
	UserService userService;
	 
	@GetMapping("users")
	public ResponseEntity<List<User>> getAll() {
		System.out.println("GetUserList >> getAll method() has been invoked !");
	    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}
	
}