/**
 * 
 */
package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.User;
/**
 * @author hgouramoni
 *
 */

 
@Service
public interface UserService {

	public List<User> getAll();
	
}
