package com.h2rd.refactoring.webController;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.service.IUsermanagementService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserResource{
    @Autowired
    IUsermanagementService usermanagenetServive;

    @RequestMapping(method=RequestMethod.POST,value = "/addUser")
    @ResponseBody
    public Response addUser(@RequestParam(value="name")String name, 
            @RequestParam(value="email")String email, @RequestParam(value="role")List<String> roles){
	 usermanagenetServive.addUser(name, email, roles);
         User user = new User(name, email, roles);
         return Response.ok().entity(user).build();
    }
  
    @RequestMapping(method=RequestMethod.POST,value = "/updateUser")
    @ResponseBody
    public Response updateUser(@RequestParam(value="name")String name, 
            @RequestParam(value="email")String email, @RequestParam(value="role")List<String> roles){
        usermanagenetServive.updateUser(name, email, roles);
         User user = new User(name, email, roles);
         return Response.ok().entity(user).build();

    }

    @RequestMapping(method=RequestMethod.DELETE,value = "/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam(value="name")String name, 
            @RequestParam(value="email")String email, @RequestParam(value="role")List<String> roles){
       usermanagenetServive.deleteUser(name, email, roles);
    }

    @RequestMapping(method=RequestMethod.GET,value = "/getUsers")
    @ResponseBody
    public Response getUsers() {
    	
        List<User> users = usermanagenetServive.getUsers();

        GenericEntity<List<User>> usersEntity = new GenericEntity<List<User>>(users) {};
        return Response.status(200).entity(usersEntity).build();
    }

    @RequestMapping(method=RequestMethod.GET,value = "/findUser")
    @ResponseBody
    public User findUser(@RequestParam(value="name")String name){
	return usermanagenetServive.findUser(name);
    }
}
