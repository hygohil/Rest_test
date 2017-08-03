package com.harpalsinh.rest_test;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.harpalsinh.rest_test.data_tier.jdbc_user;
import com.harpalsinh.rest_test.pojo.user;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("users")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
    	jdbc_user ju=new jdbc_user();
    	List<user> li=ju.getList();
    	Gson g=new Gson();
    	String res=g.toJson(li);
    	return "{\"success\":"+res+"}";
    }
    
    @GET
    @Path("/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)  
    public String getbyID(@PathParam("user_id") String user_id) {
    	jdbc_user ju=new jdbc_user();
    	user u=ju.getById(Integer.parseInt(user_id));
    	Gson g=new Gson();
    	String res=g.toJson(u);
    	return "{\"success\":"+res+"}";
    }
}
