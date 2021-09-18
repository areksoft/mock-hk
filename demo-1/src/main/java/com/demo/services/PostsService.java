/**
 * 
 */
package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.Posts;
/**
 * @author hgouramoni
 *
 */

 
@Service
public interface PostsService {

	public List<Posts> getAll();
	
}
