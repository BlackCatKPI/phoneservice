package phoneservice.controller;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import phoneservice.model.UserDao;
import phoneservice.model.User;

@Controller
@RequestMapping("/user")
public class UserController 
{

 /*   @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam(value="phonenumber", required=false, defaultValue="(097)912-34-48") String phonenumber) {
        return new User("Alex", "Veskozi", new java.sql.Date(new java.util.Date().getTime()),phonenumber); 
    }
   */ 
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody String createUser(@RequestParam(value="phonenumber", required=false, defaultValue="(097)912-34-48") String phonenumber) 
    {
    	try 
    	{
    		User userEntity= new User("Alex", "Veskozi");
    		userDao.create(userEntity);
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