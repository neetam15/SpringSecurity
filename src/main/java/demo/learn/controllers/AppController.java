package demo.learn.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	
	@RequestMapping("/home")
	@ResponseBody
	public String home(Authentication authentication)
	{
		String msg = "iN hOME ";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
		     String role = authority.getAuthority();
                     msg += authentication.getName()+", You have "+ role;
		}
		
		return msg;
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		String msg = "iN hELLO";
		
		
		return msg;		
	}
}