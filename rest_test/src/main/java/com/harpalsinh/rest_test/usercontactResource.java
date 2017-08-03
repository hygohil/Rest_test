package com.harpalsinh.rest_test;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.harpalsinh.rest_test.data_tier.jdbc_user;
import com.harpalsinh.rest_test.data_tier.jdbc_user_contact;
import com.harpalsinh.rest_test.pojo.user;
import com.harpalsinh.rest_test.pojo.user_contact_detail;

@Path("/contact")
public class usercontactResource {
	
	@GET
	@Path("/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)  
    public String getbyID(@PathParam("user_id") String user_id) {
		jdbc_user ju=new jdbc_user();
		jdbc_user_contact juc=new jdbc_user_contact();
		
    	user u=ju.getById(Integer.parseInt(user_id));
    	Gson g=new Gson();
    	String res=g.toJson(u);
    	StringBuilder sb=new StringBuilder(res);
    	sb.deleteCharAt(res.length()-1);
    	List<user_contact_detail> ll=juc.getById(Integer.parseInt(user_id));
    	res=",\"user_contact_details\":"+g.toJson(ll)+"}";
    	sb.append(res);
    	return "{\"success\":"+sb.toString()+"}";
    }

}
