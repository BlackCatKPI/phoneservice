package phoneservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController 
{

     @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam(value="phonenumber", required=false, defaultValue="(097)912-34-48") String name) {
        return new User(1,"Alex", "Veskozi", new java.sql.Date(new java.util.Date().getTime())); 
    }

}