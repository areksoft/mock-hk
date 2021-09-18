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

import com.demo.dto.User;
import com.demo.services.UserService;

/**
 * @author hgouramoni
 *
 */
public class UserServiceImpl implements UserService{

	@Autowired
	RestTemplate restTemplate;
	
	final String uri = "https://gorest.co.in/public/v1/users";
	
	public static int retryCount = 0;
	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		
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
	private List<User> convertJSONArrayToDto(JSONArray jsonArray) {
		List<User> list = new ArrayList<User>();
		 for(int i=0;i<jsonArray.size();i++)
         {
			 
             JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
             Long id = (Long) jsonObject1.get("id");
             String name = (String) jsonObject1.get("name");
             String gender = (String) jsonObject1.get("gender");
             String email = (String) jsonObject1.get("email");
             String status = (String) jsonObject1.get("status");
             
             User user = new User();
             user.setId(id);
             user.setName(name);
             user.setGender(gender);
             user.setEmail(email);
             user.setStatus(status);
             
             list.add(user);

         }
		 
		 return list;
	}

	
	 
}
