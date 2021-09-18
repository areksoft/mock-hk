/**
 * 
 */
package com.demo.controller;

/**
 * @author hgouramoni
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("hello")
	public String helloWorld() {
		System.out.println("Inside of Hello controller !!");
		
		return "Hello, Welcome to Public api!";
	}
}