/**
 * 
 */
package com.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.Comments;
import com.demo.services.CommentsService;

/**
 * @author hgouramoni
 *
 */
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	RestTemplate restTemplate;
	
	final String uri = "https://gorest.co.in/public/v1/comments";
	public static int retryCount = 0;
	@Override
	public List<Comments> getAll() {
		List<Comments> list = new ArrayList<Comments>();
		
		String result = null;
	    JSONParser parser = new JSONParser();
	    try {
	    	
	 	    result = restTemplate.getForObject(uri, String.class);
			JSONObject json = (JSONObject) parser.parse(result);
			System.out.println("json >>"+json);
			JSONArray jsonArray = (JSONArray) json.get("data");
			list = convertJSONArrayToDto(jsonArray);
		} catch ( org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			retryCount ++;
			if(retryCount <= 3) {
				getAll(); //tr-try when Exception
			}
		}
	    
	    System.out.println(result);
	    if(result !=null)
	    	System.out.println("Successfully... fetched the response !!");
	    else
	    	System.out.println("Got empty response !!");
		return list;	
	}

	/**
	 * Method to convert the response
	 * @param jsonArray
	 * @return
	 */
	private List<Comments> convertJSONArrayToDto(JSONArray jsonArray) {
		List<Comments> list = new ArrayList<Comments>();
		 for(int i=0;i<jsonArray.size();i++)
         {
			 
             JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
             Long id = (Long) jsonObject1.get("id");
             Long post_id = (Long) jsonObject1.get("post_id");
             String name = (String) jsonObject1.get("name");
             String email = (String) jsonObject1.get("email");
             String body = (String) jsonObject1.get("body");
             
             
             Comments comment = new Comments();
             comment.setId(id);
             comment.setPostId(post_id);
             comment.setEmail(email);
             comment.setName(name);
             comment.setBody(body);
             
             list.add(comment);

         }
		 
		 return list;
	}

	
	 
}
