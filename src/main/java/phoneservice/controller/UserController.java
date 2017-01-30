package phoneservice.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import phoneservice.model.UserDao;
import phoneservice.model.UserEntity;
import phoneservice.serviceobjects.User;

@Controller
@RequestMapping("/user")
public class UserController 
{

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam(value="phonenumber", required=false, defaultValue="(097)912-34-48") String name) {
        return new User(1,"Alex", "Veskozi", new java.sql.Date(new java.util.Date().getTime())); 
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody String createUser(@RequestParam(value="firstname", required=true) String firstName,@RequestParam(value="lastname", required=true) String lastName,@RequestParam(value="phonenumber", required=true) String phoneNumber) 
    {
    	try 
    	{
    		UserEntity user = new UserEntity(firstName, lastName,phoneNumber);
    		userDao.create(user);
    	}
    	catch (Exception ex) 
    	{
    		return "Error creating the user: " + ex.toString();
    	}
    	return "User succesfully created!";
    }
    

    @Autowired
    private UserDao userDao;
}