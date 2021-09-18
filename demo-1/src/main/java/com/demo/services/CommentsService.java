/**
 * 
 */
package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.Comments;
/**
 * @author hgouramoni
 *
 */

 
@Service
public interface CommentsService {

	public List<Comments> getAll();
	
}
