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
import org.springframework.web.bind.annotation.RestController;

import phoneservice.model.UserDao;
import phoneservice.model.Phone;
import phoneservice.model.PhoneDao;
import phoneservice.model.User;

@RestController
@RequestMapping("/phone")
public class PhoneController 
{

 /*   @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam(value="phonenumber", required=false, defaultValue="(097)912-34-48") String phonenumber) {
        return new User("Alex", "Veskozi", new java.sql.Date(new java.util.Date().getTime()),phonenumber); 
    }
   */ 
    @RequestMapping(method=RequestMethod.POST)
    public String addPhone(@RequestBody Phone phone)
    {
    	try 
    	{
    		phoneDao.create(phone);
    	}
    	catch (Exception ex) 
    	{
    		return "Error creating the phone: " + ex.toString();
    	}
    	return "Phone succesfully created!";
    }
 

    @Autowired
    private PhoneDao phoneDao;
}