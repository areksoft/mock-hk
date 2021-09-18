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

import com.demo.dto.Posts;
import com.demo.services.PostsService;

/**
 * @author hgouramoni
 *
 */
public class PostsServiceImpl implements PostsService{

	@Autowired
	RestTemplate restTemplate;
	
	final String uri = "https://gorest.co.in/public/v1/posts";
	public static int retryCount = 0;
	
	@Override
	public List<Posts> getAll() {
		List<Posts> list = new ArrayList<Posts>();
		
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
	private List<Posts> convertJSONArrayToDto(JSONArray jsonArray) {
		List<Posts> list = new ArrayList<Posts>();
		 for(int i=0;i<jsonArray.size();i++)
         {
			 
             JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
             Long id = (Long) jsonObject1.get("id");
             Long user_id = (Long) jsonObject1.get("user_id");
             String title = (String) jsonObject1.get("title");
             String body = (String) jsonObject1.get("body");
             
             Posts posts = new Posts();
             posts.setId(id);
             posts.setUserId(user_id);
             posts.setTitle(title);
             posts.setBody(body);
             
             list.add(posts);

         }
		 
		 return list;
	}

	
	 
}
